package leThanhSon25661741;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class QuanLyPhongHoc {
    private final ArrayList<PhongHoc> danhSach = new ArrayList<>();

    // Them phong, khong cho trung ma
    public boolean themPhong(PhongHoc p) {
        if (p == null || timPhong(p.getMaPhong()) != null) {
            return false;
        }
        danhSach.add(p);
        return true;
    }

    // Tim phong theo ma
    public PhongHoc timPhong(String maPhong) {
        for (PhongHoc p : danhSach) {
            if (p.getMaPhong().equalsIgnoreCase(maPhong)) {
                return p;
            }
        }
        return null;
    }

    // Lay toan bo danh sach
    public List<PhongHoc> layDanhSach() {
        return new ArrayList<>(danhSach);
    }

    // Lay danh sach phong dat chuan
    public List<PhongHoc> layPhongDatChuan() {
        List<PhongHoc> ketQua = new ArrayList<>();
        for (PhongHoc p : danhSach) {
            if (p.datChuan()) {
                ketQua.add(p);
            }
        }
        return ketQua;
    }

    // Sap xep day nha tang dan
    public void sapXepTheoDayNha() {
        danhSach.sort(
            Comparator.comparing(
                PhongHoc::getDayNha,
                String.CASE_INSENSITIVE_ORDER
            )
        );
    }

    // Sap xep dien tich giam dan
    public void sapXepTheoDienTichGiamDan() {
        danhSach.sort(
            Comparator.comparingDouble(PhongHoc::getDienTich)
                      .reversed()
        );
    }

    // Sap xep so bong den tang dan
    public void sapXepTheoSoBongDenTangDan() {
        danhSach.sort(
            Comparator.comparingInt(PhongHoc::getSoBongDen)
        );
    }

    // Cap nhat thong tin chung theo ma
    public boolean capNhatPhong(String maPhong,
                                String dayNha,
                                double dienTich,
                                int soBongDen) {
        PhongHoc p = timPhong(maPhong);

        if (p == null || dienTich <= 0 || soBongDen <= 0) {
            return false;
        }

        p.setDayNha(dayNha);
        p.setDienTich(dienTich);
        p.setSoBongDen(soBongDen);
        return true;
    }

    // Xoa phong theo ma
    public boolean xoaPhong(String maPhong) {
        PhongHoc p = timPhong(maPhong);
        if (p == null) {
            return false;
        }
        danhSach.remove(p);
        return true;
    }

    // Tinh tong so phong
    public int tinhTongSoPhong() {
        return danhSach.size();
    }

    // Dem phong may tinh co dung 60 may
    public long demPhongMayTinhCo60May() {
        return danhSach.stream()
            .filter(p -> p instanceof PhongMayTinh)
            .map(p -> (PhongMayTinh) p)
            .filter(p -> p.getSoMayTinh() == 60)
            .count();
    }

    // In danh sach
    public void xuatDanhSach(List<PhongHoc> ds) {
        if (ds.isEmpty()) {
            System.out.println("Danh sach rong!");
            return;
        }

        for (PhongHoc p : ds) {
            p.xuatThongTin();
        }
    }

    public void xuatTatCa() {
        xuatDanhSach(danhSach);
    }
}

