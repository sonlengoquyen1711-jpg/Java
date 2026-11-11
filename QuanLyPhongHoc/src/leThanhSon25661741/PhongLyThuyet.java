package leThanhSon25661741;

import java.util.Scanner;

public class PhongLyThuyet extends PhongHoc {
    private boolean coMayChieu;

    public PhongLyThuyet() {
        super();
    }

    public PhongLyThuyet(String maPhong, String dayNha,
                         double dienTich, int soBongDen,
                         boolean coMayChieu) {
        super(maPhong, dayNha, dienTich, soBongDen);
        this.coMayChieu = coMayChieu;
    }

    public boolean isCoMayChieu() {
        return coMayChieu;
    }

    public void setCoMayChieu(boolean coMayChieu) {
        this.coMayChieu = coMayChieu;
    }

    @Override
    public void nhapThongTin(Scanner sc) {
        super.nhapThongTin(sc);

        System.out.print("Co may chieu (true/false): ");
        coMayChieu = Boolean.parseBoolean(sc.nextLine());
    }

    @Override
    public boolean datChuan() {
        return coMayChieu && duAnhSang();
    }

    @Override
    public void xuatThongTin() {
        System.out.println(
            "Loai: Phong ly thuyet"
            + " | Ma: " + maPhong
            + " | Day: " + dayNha
            + " | Dien tich: " + dienTich
            + " | Bong den: " + soBongDen
            + " | May chieu: " + (coMayChieu ? "Co" : "Khong")
            + " | Dat chuan: " + (datChuan() ? "Co" : "Khong")
        );
    }
}