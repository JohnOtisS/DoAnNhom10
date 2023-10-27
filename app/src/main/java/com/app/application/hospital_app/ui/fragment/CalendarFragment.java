package com.app.application.hospital_app.ui.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.app.application.hospital_app.R;
import com.app.application.hospital_app.database.dao.DatabaseDAO;
import com.app.application.hospital_app.databinding.FragmentCalendarBinding;
import com.app.application.hospital_app.model.Calendar;
import com.app.application.hospital_app.model.Event;
import com.app.application.hospital_app.ui.adapter.CalendarAdapter;
import com.app.application.hospital_app.ui.adapter.EventAdapter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CalendarFragment extends Fragment {

    private FragmentCalendarBinding binding;

    private LocalDate selectedDate;
    private ArrayList<Calendar> daysInMonth;
    private CalendarAdapter calendarAdapter;
    private DatabaseDAO dao;
    private List<Event> events;
    private EventAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentCalendarBinding.inflate(getLayoutInflater());

        init();
        onClick();

        return binding.getRoot();
    }

    private void init() {
        selectedDate = LocalDate.now();
        daysInMonth = new ArrayList<>();
        setMonthView();
        dao = new DatabaseDAO(requireActivity());
        events = new ArrayList<>();
        adapter = new EventAdapter(requireActivity(), events);
        binding.rcvEvent.setAdapter(adapter);
    }

    private void onClick() {
        binding.buttonNext.setOnClickListener(view -> nextMonthAction());
        binding.buttonPrev.setOnClickListener(view -> previousMonthAction());
    }

    private void setMonthView() {
        binding.monthYearTV.setText(monthYearFromDate(selectedDate));
        daysInMonth = daysInMonthArray(selectedDate);
        calendarAdapter = new CalendarAdapter(daysInMonth, (position, calendar) -> clickDate(position, calendar));
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(requireActivity().getApplicationContext(), 7);
        binding.calendarRecyclerView.setLayoutManager(layoutManager);
        binding.calendarRecyclerView.setAdapter(calendarAdapter);
    }

    private void clickDate(int position, Calendar calendar) {
        if (calendar.getI() != 0) {
            for (int i = 0; i < daysInMonth.size(); i++) {
                daysInMonth.get(i).setSelected(false);
            }

            daysInMonth.get(position).setSelected(true);
            calendarAdapter.setDaysOfMonth(daysInMonth);
            String arr[] = calendar.getDateFormat().split("/");
            arr[0] = arr[0].length() == 1 ? "0" + arr[0] : arr[0];
            String date = arr[0] + "/" + arr[1] + "/" + arr[2];
            events = dao.eventDAO.getEvent(date);
            adapter.setList(events);
        }
    }

    private ArrayList<Calendar> daysInMonthArray(LocalDate date) {
        ArrayList<Calendar> daysInMonthArray = new ArrayList<>();
        YearMonth yearMonth = YearMonth.from(date);

        int daysInMonth = yearMonth.lengthOfMonth();

        LocalDate firstOfMonth = selectedDate.withDayOfMonth(1);
        int dayOfWeek = firstOfMonth.getDayOfWeek().getValue();

        for (int i = 1; i <= 42; i++) {
            String temp = (i - dayOfWeek) + " " + binding.monthYearTV.getText();
            String[] arrDate = temp.split(" ");
            String dateString = arrDate[0] + "/" + arrDate[2] + "/" + arrDate[3];
            if (i <= dayOfWeek || i > daysInMonth + dayOfWeek) {
                daysInMonthArray.add(
                        new Calendar(
                                0, false, 0, ""
                        )
                );
            } else {
                daysInMonthArray.add(new Calendar(
                        i - dayOfWeek,
                        false,
                        0,
                        dateString
                ));
            }
        }


        return daysInMonthArray;
    }

    private String monthYearFromDate(LocalDate date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");
        return date.format(formatter);
    }

    public void previousMonthAction() {
        selectedDate = selectedDate.minusMonths(1);
        setMonthView();
    }

    public void nextMonthAction() {
        selectedDate = selectedDate.plusMonths(1);
        setMonthView();
    }

    private long convertDateToLong(String input) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date date = sdf.parse(input);
            long timestamp = date.getTime();
            return timestamp;
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return 0;
    }
}