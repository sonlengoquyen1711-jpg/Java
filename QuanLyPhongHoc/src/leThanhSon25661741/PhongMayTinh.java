package leThanhSon25661741;


import java.util.Scanner;

public class PhongMayTinh extends PhongHoc {
    private int soMayTinh;

    public PhongMayTinh() {
        super();
    }

    public PhongMayTinh(String maPhong, String dayNha,
                        double dienTich, int soBongDen,
                        int soMayTinh) {
        super(maPhong, dayNha, dienTich, soBongDen);
        this.soMayTinh = soMayTinh;
    }

    public int getSoMayTinh() {
        return soMayTinh;
    }

    public void setSoMayTinh(int soMayTinh) {
        this.soMayTinh = soMayTinh;
    }

    @Override
    public void nhapThongTin(Scanner sc) {
        super.nhapThongTin(sc);

        System.out.print("Nhap so may tinh: ");
        soMayTinh = Integer.parseInt(sc.nextLine());
    }

    @Override
    public boolean datChuan() {
        return soMayTinh > 0
            && dienTich / soMayTinh >= 1.5
            && duAnhSang();
    }

    @Override
    public void xuatThongTin() {
        System.out.println(
            "Loai: Phong may tinh"
            + " | Ma: " + maPhong
            + " | Day: " + dayNha
            + " | Dien tich: " + dienTich
            + " | Bong den: " + soBongDen
            + " | So may tinh: " + soMayTinh
            + " | Dat chuan: " + (datChuan() ? "Co" : "Khong")
        );
    }
}

