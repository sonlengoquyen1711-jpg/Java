package leThanhSon25661741;


import java.util.Scanner;

public class PhongThiNghiem extends PhongHoc {
    private String chuyenNganh;
    private int sucChua;
    private boolean coBonRua;

    public PhongThiNghiem() {
        super();
    }

    public PhongThiNghiem(String maPhong, String dayNha,
                          double dienTich, int soBongDen,
                          String chuyenNganh, int sucChua,
                          boolean coBonRua) {
        super(maPhong, dayNha, dienTich, soBongDen);
        this.chuyenNganh = chuyenNganh;
        this.sucChua = sucChua;
        this.coBonRua = coBonRua;
    }

    public String getChuyenNganh() {
        return chuyenNganh;
    }

    public int getSucChua() {
        return sucChua;
    }

    public boolean isCoBonRua() {
        return coBonRua;
    }

    @Override
    public void nhapThongTin(Scanner sc) {
        super.nhapThongTin(sc);

        System.out.print("Nhap chuyen nganh: ");
        chuyenNganh = sc.nextLine();

        System.out.print("Nhap suc chua: ");
        sucChua = Integer.parseInt(sc.nextLine());

        System.out.print("Co bon rua (true/false): ");
        coBonRua = Boolean.parseBoolean(sc.nextLine());
    }

    @Override
    public boolean datChuan() {
        return coBonRua && duAnhSang();
    }

    @Override
    public void xuatThongTin() {
        System.out.println(
            "Loai: Phong thi nghiem"
            + " | Ma: " + maPhong
            + " | Day: " + dayNha
            + " | Dien tich: " + dienTich
            + " | Bong den: " + soBongDen
            + " | Chuyen nganh: " + chuyenNganh
            + " | Suc chua: " + sucChua
            + " | Bon rua: " + (coBonRua ? "Co" : "Khong")
            + " | Dat chuan: " + (datChuan() ? "Co" : "Khong")
        );
    }
}

