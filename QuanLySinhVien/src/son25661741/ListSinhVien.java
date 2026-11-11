package son25661741;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;

public class ListSinhVien implements IFSinhVien {

    private ArrayList<SinhVien> danhSach;

    public ListSinhVien() {
        this.danhSach = new ArrayList<>();
    }

    public ListSinhVien(ArrayList<SinhVien> ds) {
        this.danhSach = (ds != null) ? ds : new ArrayList<>();
    }

    // ==================== THÊM, SỬA, XÓA ====================

    public boolean them(SinhVien sv) {
        if (sv == null || sv.getMaSV() == null) {
            return false;
        }

        // Không cho phép trùng mã sinh viên
        if (timTheoMa(sv.getMaSV()) != null) {
            return false;
        }

        return danhSach.add(sv);
    }

    public boolean sua(String maSV, SinhVien svMoi) {
        if (maSV == null || svMoi == null) {
            return false;
        }

        for (int i = 0; i < danhSach.size(); i++) {
            if (danhSach.get(i).getMaSV().equalsIgnoreCase(maSV)) {
                // Không cho sửa thành mã đã tồn tại ở sinh viên khác
                for (int j = 0; j < danhSach.size(); j++) {
                    if (j != i && danhSach.get(j).getMaSV()
                            .equalsIgnoreCase(svMoi.getMaSV())) {
                        return false;
                    }
                }

                danhSach.set(i, svMoi);
                return true;
            }
        }

        return false;
    }

    public boolean xoa(String maSV) {
        if (maSV == null) {
            return false;
        }

        return danhSach.removeIf(
                sv -> sv.getMaSV().equalsIgnoreCase(maSV));
    }

    public boolean xoaTatCa() {
        if (danhSach.isEmpty()) {
            return false;
        }

        danhSach.clear();
        return true;
    }

    // ==================== LẤY VÀ TÌM KIẾM ====================

    public List<SinhVien> layTatCa() {
        return new ArrayList<>(danhSach);
    }

    public SinhVien timTheoMa(String maSV) {
        if (maSV == null) {
            return null;
        }

        for (SinhVien sv : danhSach) {
            if (sv.getMaSV().equalsIgnoreCase(maSV)) {
                return sv;
            }
        }

        return null;
    }

    public List<SinhVien> tim(Predicate<SinhVien> dieuKien) {
        List<SinhVien> kq = new ArrayList<>();

        if (dieuKien == null) {
            return kq;
        }

        for (SinhVien sv : danhSach) {
            if (dieuKien.test(sv)) {
                kq.add(sv);
            }
        }

        return kq;
    }

    public List<SinhVien> timTheoTen(String tuKhoa) {
        List<SinhVien> kq = new ArrayList<>();

        if (tuKhoa == null) {
            return kq;
        }

        for (SinhVien sv : danhSach) {
            if (sv.getHoTen().toLowerCase()
                    .contains(tuKhoa.toLowerCase())) {
                kq.add(sv);
            }
        }

        return kq;
    }

    public List<SinhVien> timTheoLop(String lop) {
        List<SinhVien> kq = new ArrayList<>();

        if (lop == null) {
            return kq;
        }

        for (SinhVien sv : danhSach) {
            if (sv.getLop().equalsIgnoreCase(lop)) {
                kq.add(sv);
            }
        }

        return kq;
    }

    public List<SinhVien> timTheoLoai(String loai) {
        List<SinhVien> kq = new ArrayList<>();

        if (loai == null) {
            return kq;
        }

        for (SinhVien sv : danhSach) {
            if (sv.getLoai().equalsIgnoreCase(loai)) {
                kq.add(sv);
            }
        }

        return kq;
    }

    public List<SinhVien> timTheoMon(MonHoc monHoc) {
        List<SinhVien> kq = new ArrayList<>();

        for (SinhVien sv : danhSach) {
            if (sv.getMonHoc() == monHoc) {
                kq.add(sv);
            }
        }

        return kq;
    }

    // ==================== THỐNG KÊ ====================

    public int tongSoLuong() {
        return danhSach.size();
    }

    public double tongThanhTien() {
        double tong = 0;

        for (SinhVien sv : danhSach) {
            tong += sv.thanhTien();
        }

        return tong;
    }

    // ==================== SẮP XẾP ====================

    public void sapXep(Comparator<SinhVien> cmp) {
        if (cmp != null) {
            danhSach.sort(cmp);
        }
    }

    public void sapXepGiamDan(Comparator<SinhVien> cmp) {
        if (cmp != null) {
            danhSach.sort(cmp.reversed());
        }
    }

    public List<SinhVien> sapXepTheoTen() {
        List<SinhVien> kq = new ArrayList<>(danhSach);

        kq.sort(Comparator.comparing(SinhVien::getHoTen));

        return kq;
    }

    public List<SinhVien> sapXepTheoThanhTienGiamDan() {
        List<SinhVien> kq = new ArrayList<>(danhSach);

        kq.sort(
                Comparator.comparingDouble(SinhVien::thanhTien)
                        .reversed());

        return kq;
    }

    // ==================== ĐẾM THEO NHÓM ====================

    public <K> Map<K, Integer> demTheoNhom(
            Function<SinhVien, K> layKey) {

        Map<K, Integer> kq = new LinkedHashMap<>();

        for (SinhVien sv : danhSach) {
            kq.merge(layKey.apply(sv), 1, Integer::sum);
        }

        return kq;
    }

    // HAVING: chỉ giữ nhóm có số lượng >= minSoLuong
    public <K> Map<K, Integer> demTheoNhom_Having(
            Function<SinhVien, K> layKey,
            int minSoLuong) {

        Map<K, Integer> kq = new LinkedHashMap<>();

        Map<K, Integer> dem = demTheoNhom(layKey);

        for (Map.Entry<K, Integer> e : dem.entrySet()) {
            if (e.getValue() >= minSoLuong) {
                kq.put(e.getKey(), e.getValue());
            }
        }

        return kq;
    }

    // ==================== GOM NHÓM ====================

    public <K> Map<K, List<SinhVien>> nhomTheo(
            Function<SinhVien, K> layKey) {

        Map<K, List<SinhVien>> kq = new LinkedHashMap<>();

        for (SinhVien sv : danhSach) {
            K key = layKey.apply(sv);

            if (!kq.containsKey(key)) {
                kq.put(key, new ArrayList<>());
            }

            kq.get(key).add(sv);
        }

        return kq;
    }

    // ==================== TỔNG THEO NHÓM ====================

    public <K> Map<K, Double> tongTheoNhom(
            Function<SinhVien, K> layKey,
            ToDoubleFunction<SinhVien> layGiaTri) {

        Map<K, Double> kq = new LinkedHashMap<>();

        for (SinhVien sv : danhSach) {
            K key = layKey.apply(sv);
            double giaTri = layGiaTri.applyAsDouble(sv);

            kq.merge(key, giaTri, Double::sum);
        }

        return kq;
    }

    // HAVING: chỉ giữ nhóm có tổng >= minTong
    public <K> Map<K, Double> tongTheoNhom_Having(
            Function<SinhVien, K> layKey,
            ToDoubleFunction<SinhVien> layGiaTri,
            double minTong) {

        Map<K, Double> kq = new LinkedHashMap<>();

        Map<K, Double> tong = tongTheoNhom(layKey, layGiaTri);

        for (Map.Entry<K, Double> e : tong.entrySet()) {
            if (e.getValue() >= minTong) {
                kq.put(e.getKey(), e.getValue());
            }
        }

        return kq;
    }
}