import java.util.Scanner;

/**
 * Lop TestCD: chuong trinh chinh (entry point).
 * Hien thi menu va dieu phoi cac chuc nang cua ListCD.
 */
public class TestCD {

    // ============ MENU ============
    /**
     * In menu chuc nang ra man hinh.
     * Phuong thuc tinh, khong can tao doi tuong de goi.
     */
    public static void menu() {
        System.out.println("\n========= MENU QUAN LY CD =========");
        System.out.println("1. Nhap CD tu ban phim");
        System.out.println("2. Xoa CD theo ma");
        System.out.println("3. Cap nhat gia CD theo ma");
        System.out.println("4. In danh sach CD");
        System.out.println("5. Tinh tong thanh tien");
        System.out.println("0. Thoat");
        System.out.println("===================================");
        System.out.print("Chon chuc nang: ");
    }

    // ============ MAIN ============
    /**
     * Ham main: khoi dong chuong trinh.
     *  - Nhap so luong CD toi da ban dau
     *  - Vong lap hien thi menu, doc lua chon
     *  - Goi cac phuong thuc tuong ung cua ListCD
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Bước 1: nhập sức chứa ban đầu
        System.out.print("Nhap so luong CD toi da ban dau: ");
        int n = Integer.parseInt(sc.nextLine());
        ListCD ds = new ListCD(n);

        // Bước 2: vòng lặp chính
        int chon;
        do {
            menu();
            try {
                chon = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                chon = -1;   // giá trị không hợp lệ
            }

            switch (chon) {
                case 1:
                    ds.nhapCD(sc);
                    break;
                case 2:
                    ds.xoaCD(sc);
                    break;
                case 3:
                    ds.capNhatGiaCD(sc);
                    break;
                case 4:
                    ds.inDS();
                    break;
                case 5:
                    System.out.printf("Tong thanh tien: %.2f%n",
                                        ds.tongThanhTien());
                    break;
                case 0:
                    System.out.println("Ket thuc chuong trinh.");
                    break;
                default:
                    System.out.println("Chuc nang khong hop le!");
            }
        } while (chon != 0);

        sc.close();
    }
}
