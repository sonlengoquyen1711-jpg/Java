package leThanhSon25661741;

import java.time.LocalDate;

public class QuanLyHangThucPham {

    private HangThucPham[] danhSach; // Mang nguyen thuy
    private int soLuong;             // So phan tu hien co
    private int khaNang;             // Suc chua hien tai

    private static final int KICH_THUOC_BAN_DAU = 5;

    public QuanLyHangThucPham() {
        danhSach = new HangThucPham[KICH_THUOC_BAN_DAU];
        soLuong = 0;
        khaNang = KICH_THUOC_BAN_DAU;
    }


    private void moRongMang() {
        int kichThuocMoi = khaNang * 2;

        HangThucPham[] mangMoi =
                new HangThucPham[kichThuocMoi];

        for (int i = 0; i < soLuong; i++) {
            mangMoi[i] = danhSach[i];
        }

        danhSach = mangMoi;
        khaNang = kichThuocMoi;

        System.out.println(
                "Da mo rong mang len "
                + khaNang + " phan tu."
        );
    }

 

    public int timViTriTheoMa(String maHang) {

        for (int i = 0; i < soLuong; i++) {

            if (danhSach[i].getMaHang()
                    .equalsIgnoreCase(maHang)) {

                return i;
            }
        }

        return -1;
    }

  
    public int timViTriTheoID(int id) {

        for (int i = 0; i < soLuong; i++) {

            if (danhSach[i].getId() == id) {
                return i;
            }
        }

        return -1;
    }

 
    public boolean them(HangThucPham h) {

        if (h == null) {
            return false;
        }

        // Kiem tra trung ma
        if (timViTriTheoMa(h.getMaHang()) != -1) {

            System.out.println(
                    "Loi: Ma hang "
                    + h.getMaHang()
                    + " da ton tai."
            );

            return false;
        }

        // Neu day mang thi mo rong
        if (soLuong == khaNang) {
            moRongMang();
        }

        danhSach[soLuong] = h;
        soLuong++;

        return true;
    }

    public boolean xoa(int id) {

        int viTri = timViTriTheoID(id);

        if (viTri == -1) {

            System.out.println(
                    "Khong tim thay hang co ID " + id
            );

            return false;
        }

        for (int i = viTri; i < soLuong - 1; i++) {
            danhSach[i] = danhSach[i + 1];
        }

        danhSach[soLuong - 1] = null;
        soLuong--;

        return true;
    }

   

    public boolean sua(
            int id,
            String tenMoi,
            LocalDate ngaySXMoi,
            LocalDate ngayHHMoi,
            float giaMoi) {

        int viTri = timViTriTheoID(id);

        if (viTri == -1) {

            System.out.println(
                    "Khong tim thay hang co ID " + id
            );

            return false;
        }

        HangThucPham h = danhSach[viTri];

        h.setTenHang(tenMoi);
        h.setNgaySanXuat(ngaySXMoi);
        h.setNgayHetHan(ngayHHMoi);
        h.setGia(giaMoi);

        return true;
    }


    public HangThucPham timTheoID(int id) {

        int viTri = timViTriTheoID(id);

        if (viTri == -1) {
            return null;
        }

        return danhSach[viTri];
    }


    public void sapXepTheoGia(boolean tangDan) {

        for (int i = 0; i < soLuong - 1; i++) {

            for (int j = i + 1; j < soLuong; j++) {

                boolean canDoi;

                if (tangDan) {
                    canDoi = danhSach[i].getGia()
                            > danhSach[j].getGia();
                } else {
                    canDoi = danhSach[i].getGia()
                            < danhSach[j].getGia();
                }

                if (canDoi) {

                    HangThucPham temp = danhSach[i];

                    danhSach[i] = danhSach[j];
                    danhSach[j] = temp;
                }
            }
        }

        System.out.println(
                "Da sap xep theo gia "
                + (tangDan ? "tang dan" : "giam dan")
        );
    }


    public void sapXepTheoNgaySanXuat(boolean tangDan) {

        for (int i = 0; i < soLuong - 1; i++) {

            for (int j = i + 1; j < soLuong; j++) {

                boolean canDoi;

                if (tangDan) {

                    canDoi = danhSach[i]
                            .getNgaySanXuat()
                            .isAfter(
                                    danhSach[j]
                                            .getNgaySanXuat()
                            );

                } else {

                    canDoi = danhSach[i]
                            .getNgaySanXuat()
                            .isBefore(
                                    danhSach[j]
                                            .getNgaySanXuat()
                            );
                }

                if (canDoi) {

                    HangThucPham temp = danhSach[i];

                    danhSach[i] = danhSach[j];
                    danhSach[j] = temp;
                }
            }
        }

        System.out.println(
                "Da sap xep theo ngay san xuat "
                + (tangDan ? "tang dan" : "giam dan")
        );
    }

   
    public void sapXepTheoNgayHetHan(boolean tangDan) {

        for (int i = 0; i < soLuong - 1; i++) {

            for (int j = i + 1; j < soLuong; j++) {

                boolean canDoi;

                if (tangDan) {

                    canDoi = danhSach[i]
                            .getNgayHetHan()
                            .isAfter(
                                    danhSach[j]
                                            .getNgayHetHan()
                            );

                } else {

                    canDoi = danhSach[i]
                            .getNgayHetHan()
                            .isBefore(
                                    danhSach[j]
                                            .getNgayHetHan()
                            );
                }

                if (canDoi) {

                    HangThucPham temp = danhSach[i];

                    danhSach[i] = danhSach[j];
                    danhSach[j] = temp;
                }
            }
        }

        System.out.println(
                "Da sap xep theo ngay het han "
                + (tangDan ? "tang dan" : "giam dan")
        );
    }

 

    public QuanLyHangThucPham timTheoTienTo(String tuKhoa) {

        QuanLyHangThucPham ketQua =
                new QuanLyHangThucPham();

        String tk = tuKhoa.toLowerCase();

        for (int i = 0; i < soLuong; i++) {

            if (danhSach[i]
                    .getTenHang()
                    .toLowerCase()
                    .startsWith(tk)) {

                ketQua.them(danhSach[i]);
            }
        }

        return ketQua;
    }

   

    public QuanLyHangThucPham timTheoHauTo(String tuKhoa) {

        QuanLyHangThucPham ketQua =
                new QuanLyHangThucPham();

        String tk = tuKhoa.toLowerCase();

        for (int i = 0; i < soLuong; i++) {

            if (danhSach[i]
                    .getTenHang()
                    .toLowerCase()
                    .endsWith(tk)) {

                ketQua.them(danhSach[i]);
            }
        }

        return ketQua;
    }

 

    public QuanLyHangThucPham timGanGiong(String tuKhoa) {

        QuanLyHangThucPham ketQua =
                new QuanLyHangThucPham();

        String tk = tuKhoa.toLowerCase();

        for (int i = 0; i < soLuong; i++) {

            if (danhSach[i]
                    .getTenHang()
                    .toLowerCase()
                    .contains(tk)) {

                ketQua.them(danhSach[i]);
            }
        }

        return ketQua;
    }


    public QuanLyHangThucPham trichLocTheoNgaySanXuat(
            LocalDate tuNgay,
            LocalDate denNgay) {

        QuanLyHangThucPham ketQua =
                new QuanLyHangThucPham();

        if (tuNgay == null || denNgay == null) {
            return ketQua;
        }

        if (tuNgay.isAfter(denNgay)) {
            return ketQua;
        }

        for (int i = 0; i < soLuong; i++) {

            LocalDate ngay =
                    danhSach[i].getNgaySanXuat();

            if (!ngay.isBefore(tuNgay)
                    && !ngay.isAfter(denNgay)) {

                ketQua.them(danhSach[i]);
            }
        }

        return ketQua;
    }

  
    public QuanLyHangThucPham trichLocTheoNgayHetHan(
            LocalDate tuNgay,
            LocalDate denNgay) {

        QuanLyHangThucPham ketQua =
                new QuanLyHangThucPham();

        if (tuNgay == null || denNgay == null) {
            return ketQua;
        }

        if (tuNgay.isAfter(denNgay)) {
            return ketQua;
        }

        for (int i = 0; i < soLuong; i++) {

            LocalDate ngay =
                    danhSach[i].getNgayHetHan();

            if (!ngay.isBefore(tuNgay)
                    && !ngay.isAfter(denNgay)) {

                ketQua.them(danhSach[i]);
            }
        }

        return ketQua;
    }

   
    public void thongKe() {

        if (soLuong == 0) {

            System.out.println(
                    "Danh sach rong, khong co du lieu thong ke."
            );

            return;
        }

        int tongSoLuong = soLuong;

        float tongGia = 0;
        float giaCaoNhat = danhSach[0].getGia();
        float giaThapNhat = danhSach[0].getGia();

        int soHangHetHan = 0;

        LocalDate homNay = LocalDate.now();

        for (int i = 0; i < soLuong; i++) {

            float gia = danhSach[i].getGia();

            tongGia += gia;

            if (gia > giaCaoNhat) {
                giaCaoNhat = gia;
            }

            if (gia < giaThapNhat) {
                giaThapNhat = gia;
            }

            if (danhSach[i]
                    .getNgayHetHan()
                    .isBefore(homNay)) {

                soHangHetHan++;
            }
        }

        float giaTrungBinh =
                tongGia / tongSoLuong;

        System.out.println("\n========== THONG KE ==========");
        System.out.println(
                "Tong so mat hang: " + tongSoLuong
        );

        System.out.printf(
                "Tong gia tri: %.2f%n",
                tongGia
        );

        System.out.printf(
                "Gia trung binh: %.2f%n",
                giaTrungBinh
        );

        System.out.printf(
                "Gia cao nhat: %.2f%n",
                giaCaoNhat
        );

        System.out.printf(
                "Gia thap nhat: %.2f%n",
                giaThapNhat
        );

        System.out.println(
                "So hang da het han: " + soHangHetHan
        );

        System.out.println("==============================");
    }

  
    public void thongKeTheoThang(int thang, int nam) {

        if (thang < 1 || thang > 12) {

            System.out.println(
                    "Thang khong hop le!"
            );

            return;
        }

        if (nam < 1) {

            System.out.println(
                    "Nam khong hop le!"
            );

            return;
        }

        int soLuongThang = 0;
        float tongGiaThang = 0;

        for (int i = 0; i < soLuong; i++) {

            LocalDate ngay =
                    danhSach[i].getNgaySanXuat();

            if (ngay.getMonthValue() == thang
                    && ngay.getYear() == nam) {

                soLuongThang++;
                tongGiaThang += danhSach[i].getGia();
            }
        }

        System.out.println(
                "\n====== THONG KE THANG "
                + thang + "/" + nam + " ======"
        );

        System.out.println(
                "So mat hang san xuat trong thang: "
                + soLuongThang
        );

        System.out.printf(
                "Tong gia tri: %.2f%n",
                tongGiaThang
        );

        if (soLuongThang > 0) {

            System.out.printf(
                    "Gia trung binh: %.2f%n",
                    tongGiaThang / soLuongThang
            );
        } else {

            System.out.println(
                    "Khong co mat hang nao trong thang."
            );
        }

        System.out.println(
                "================================"
        );
    }

 

    public void hienThiDanhSach() {

        if (soLuong == 0) {

            System.out.println(
                    "Danh sach hang thuc pham rong!"
            );

            return;
        }

        System.out.println(
                "\n================ DANH SACH HANG THUC PHAM ================"
        );

        System.out.printf(
                "%-5s %-12s %-25s %-15s %-15s %-12s%n",
                "ID",
                "Ma hang",
                "Ten hang",
                "Ngay SX",
                "Ngay HH",
                "Gia"
        );

        System.out.println(
                "--------------------------------------------------------------------------"
        );

        for (int i = 0; i < soLuong; i++) {

            HangThucPham h = danhSach[i];

            System.out.printf(
                    "%-5d %-12s %-25s %-15s %-15s %-12.2f%n",
                    h.getId(),
                    h.getMaHang(),
                    h.getTenHang(),
                    h.getNgaySanXuat(),
                    h.getNgayHetHan(),
                    h.getGia()
            );
        }

        System.out.println(
                "=========================================================="
        );
    }

   

    public int getSoLuong() {
        return soLuong;
    }


    public void hienThiThongTin() {
        hienThiDanhSach();
    }
}
