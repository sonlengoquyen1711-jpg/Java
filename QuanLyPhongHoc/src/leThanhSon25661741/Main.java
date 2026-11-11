package leThanhSon25661741;


import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final QuanLyPhongHoc ql = new QuanLyPhongHoc();

    public static void main(String[] args) {
        int chon;

        do {
            System.out.println("\n========== QUAN LY PHONG HOC ==========");
            System.out.println("1. Them phong hoc");
            System.out.println("2. Xuat danh sach phong hoc");
            System.out.println("3. Tim phong theo ma");
            System.out.println("4. Xoa phong theo ma");
            System.out.println("5. Cap nhat thong tin chung");
            System.out.println("6. Xuat cac phong dat chuan");
            System.out.println("7. Sap xep theo day nha tang dan");
            System.out.println("8. Sap xep theo dien tich giam dan");
            System.out.println("9. Sap xep theo so bong den tang dan");
            System.out.println("10. Dem tong so phong");
            System.out.println("11. Dem phong may tinh co 60 may");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon: ");

            chon = Integer.parseInt(sc.nextLine());

            switch (chon) {
                case 1:
                    themPhong();
                    break;

                case 2:
                    ql.xuatTatCa();
                    break;

                case 3:
                    timPhong();
                    break;

                case 4:
                    xoaPhong();
                    break;

                case 5:
                    capNhatPhong();
                    break;

                case 6:
                    ql.xuatDanhSach(ql.layPhongDatChuan());
                    break;

                case 7:
                    ql.sapXepTheoDayNha();
                    ql.xuatTatCa();
                    break;

                case 8:
                    ql.sapXepTheoDienTichGiamDan();
                    ql.xuatTatCa();
                    break;

                case 9:
                    ql.sapXepTheoSoBongDenTangDan();
                    ql.xuatTatCa();
                    break;

                case 10:
                    System.out.println("Tong so phong: "
                            + ql.tinhTongSoPhong());
                    break;

                case 11:
                    System.out.println("So phong may tinh co 60 may: "
                            + ql.demPhongMayTinhCo60May());
                    break;

                case 0:
                    System.out.println("Ket thuc chuong trinh!");
                    break;

                default:
                    System.out.println("Lua chon khong hop le!");
            }

        } while (chon != 0);

        sc.close();
    }

    // Them phong hoc
    private static void themPhong() {
        System.out.println("\n1. Phong ly thuyet");
        System.out.println("2. Phong may tinh");
        System.out.println("3. Phong thi nghiem");
        System.out.print("Chon loai phong: ");

        int loai = Integer.parseInt(sc.nextLine());
        PhongHoc p;

        switch (loai) {
            case 1:
                p = new PhongLyThuyet();
                break;
            case 2:
                p = new PhongMayTinh();
                break;
            case 3:
                p = new PhongThiNghiem();
                break;
            default:
                System.out.println("Loai phong khong hop le!");
                return;
        }

        p.nhapThongTin(sc);

        if (ql.themPhong(p)) {
            System.out.println("Them phong thanh cong!");
        } else {
            System.out.println("Ma phong bi trung!");
        }
    }

    // Tim phong
    private static void timPhong() {
        System.out.print("Nhap ma phong can tim: ");
        String ma = sc.nextLine();

        PhongHoc p = ql.timPhong(ma);

        if (p != null) {
            p.xuatThongTin();
        } else {
            System.out.println("Khong tim thay phong!");
        }
    }

    // Xoa phong
    private static void xoaPhong() {
        System.out.print("Nhap ma phong can xoa: ");
        String ma = sc.nextLine();

        if (ql.xoaPhong(ma)) {
            System.out.println("Xoa thanh cong!");
        } else {
            System.out.println("Khong tim thay phong!");
        }
    }

    // Cap nhat thong tin chung
    private static void capNhatPhong() {
        System.out.print("Nhap ma phong can cap nhat: ");
        String ma = sc.nextLine();

        if (ql.timPhong(ma) == null) {
            System.out.println("Khong tim thay phong!");
            return;
        }

        System.out.print("Nhap day nha moi: ");
        String day = sc.nextLine();

        System.out.print("Nhap dien tich moi: ");
        double dienTich = Double.parseDouble(sc.nextLine());

        System.out.print("Nhap so bong den moi: ");
        int soBongDen = Integer.parseInt(sc.nextLine());

        if (ql.capNhatPhong(ma, day, dienTich, soBongDen)) {
            System.out.println("Cap nhat thanh cong!");
        } else {
            System.out.println("Du lieu khong hop le!");
        }
    }
}

