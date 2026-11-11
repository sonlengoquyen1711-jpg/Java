package leThanhSon25661741;
import java.util.Scanner;

public abstract class PhongHoc {
    protected String maPhong;
    protected String dayNha;
    protected double dienTich;
    protected int soBongDen;

    public PhongHoc() {
    }

    public PhongHoc(String maPhong, String dayNha,
                    double dienTich, int soBongDen) {
        this.maPhong = maPhong;
        this.dayNha = dayNha;
        this.dienTich = dienTich;
        this.soBongDen = soBongDen;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public String getDayNha() {
        return dayNha;
    }

    public double getDienTich() {
        return dienTich;
    }

    public int getSoBongDen() {
        return soBongDen;
    }

    public void setDayNha(String dayNha) {
        this.dayNha = dayNha;
    }

    public void setDienTich(double dienTich) {
        this.dienTich = dienTich;
    }

    public void setSoBongDen(int soBongDen) {
        this.soBongDen = soBongDen;
    }

    public void nhapThongTin(Scanner sc) {
        System.out.print("Nhap ma phong: ");
        maPhong = sc.nextLine();

        System.out.print("Nhap day nha: ");
        dayNha = sc.nextLine();

        System.out.print("Nhap dien tich: ");
        dienTich = Double.parseDouble(sc.nextLine());

        System.out.print("Nhap so bong den: ");
        soBongDen = Integer.parseInt(sc.nextLine());
    }

    // Dieu kien chung: dat chuan anh sang
    public boolean duAnhSang() {
        return dienTich / soBongDen <= 10;
    }

    // Moi loai phong tu cai dat dieu kien rieng
    public abstract boolean datChuan();

    public abstract void xuatThongTin();
}