package com.app.application.hospital_app.common;

import com.app.application.hospital_app.model.BN;
import com.app.application.hospital_app.model.Major;

import java.util.ArrayList;
import java.util.List;

public class ListObject {
    public static final List<Major> getMajors() {
        List<Major> majors = new ArrayList<>();

        majors.add(Number.index_major_one, new Major(Number.index_major_one, "Khoa Mắt"));
        majors.add(Number.index_major_two, new Major(Number.index_major_two, "Khoa Tai – Mũi – Họng"));
        majors.add(Number.index_major_three, new Major(Number.index_major_three, "Khoa Da liễu"));
        majors.add(Number.index_major_four, new Major(Number.index_major_four, "Khoa Răng – Hàm – Mặt"));

        return majors;
    }

    public static final List<BN> getBns() {
        List<BN> list = new ArrayList<>();

        list.add(0, new BN(0, "0123456789", "03/04/2023 - 02/04/2024", "Hà Nội", "Nguyễn Thị A", "12/12/1997", 0, "Hà Nội"));
        list.add(1, new BN(1, "0123456799", "12/01/2023 - 11/01/2024", "Hải Phòng", "Trần Văn B", "23/04/2990", 1, "Hải Phòng"));
        list.add(2, new BN(2, "0123456999", "15/02/2023 - 14/02/2024", "Nam Định", "Phùng Thị C", "07/07/2003", 0, "Nam Định"));
        list.add(3, new BN(3, "0123456234", "21/12/2022 - 10/012/2023", "Tuyên Quang", "Trần Thị D", "03/06/2000", 0, "Tuyên Quang"));
        list.add(4, new BN(4, "0123456123", "07/09/2023 - 06/09/2024", "Thái Nguyên", "Phạm Văn E", "11/02/1993", 1, "Thái Nguyên"));
        list.add(5, new BN(5, "0123456734", "05/04/2022 - 04/05/2025", "Lâm Đồng", "Nguyễn Văn F", "03/08/1997", 1, "Lâm Đồng"));
        list.add(6, new BN(6, "0123456854", "18/10/2023 - 17/10/2026", "TP Hồ Chí Minh", "Đàm Thị G", "12/12/1997", 0, "Tp Hồ Chí Minh"));
        list.add(7, new BN(7, "0123456888", "25/07/2023 - 24/07/2024", "Đà Nẵng", "Dương Văn H", "12/12/1997", 1, "Đà Nẵng"));
        list.add(8, new BN(8, "0123456563", "12/06/2023 - 11/06/2024", "Nha Trang", "Đỗ Thị I", "12/12/1997", 0, "Nha Trang"));
        list.add(9, new BN(9, "0123456023", "28/09/2023 - 17/09/2024", "Huế", "Đỗ Văn D", "12/12/1997", 1, "Huế"));
        list.add(10, new BN(10, "0123456934", "01/01/2023 - 31/12/2026", "Nam Định", "Phạm Văn H", "12/12/1997", 1, "Nam Định"));
        list.add(11, new BN(11, "0123456125", "04/04/2023 - 03/04/2024", "Hải Phòng", "Nguyễn Thị H", "12/12/1997", 0, "Hải Phòng"));
        list.add(12, new BN(12, "0123456823", "03/08/2023 - 02/08/2026", "Hà Nội", "Phùng Thị F", "12/12/1997", 0, "Hà Nội"));

        return list;
    }
}
