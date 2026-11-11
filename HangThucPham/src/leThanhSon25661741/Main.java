package leThanhSon25661741;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        QuanLyHangThucPham ql = new QuanLyHangThucPham();

        HangThucPham h1 = new HangThucPham(
                1,
                "TP01",
                "Sua tuoi",
                LocalDate.of(2026, 9, 1),
                LocalDate.of(2026, 10, 1),
                25000
        );

        HangThucPham h2 = new HangThucPham(
                2,
                "TP02",
                "Banh mi",
                LocalDate.of(2026, 9, 5),
                LocalDate.of(2026, 9, 20),
                15000
        );

        HangThucPham h3 = new HangThucPham(
                3,
                "TP03",
                "Sua chua",
                LocalDate.of(2026, 8, 20),
                LocalDate.of(2026, 9, 25),
                12000
        );

        HangThucPham h4 = new HangThucPham(
                4,
                "TP04",
                "Nuoc ngot",
                LocalDate.of(2026, 9, 10),
                LocalDate.of(2027, 1, 10),
                10000
        );

        HangThucPham h5 = new HangThucPham(
                5,
                "TP05",
                "Mi tom",
                LocalDate.of(2026, 7, 15),
                LocalDate.of(2026, 12, 15),
                8000
        );

        // Them vao danh sach
        ql.them(h1);
        ql.them(h2);
        ql.them(h3);
        ql.them(h4);
        ql.them(h5);

        System.out.println("\n===== DANH SACH BAN DAU =====");
        ql.hienThiDanhSach();
        System.out.println("\n===== TIM HANG THEO ID =====");

        HangThucPham tim = ql.timTheoID(3);

        if (tim != null) {
            System.out.println("Tim thay:");
            System.out.println(tim);
        } else {
            System.out.println("Khong tim thay!");
        }


        System.out.println("\n===== TIM THEO TIEN TO 'SUA' =====");

        QuanLyHangThucPham ketQuaTienTo =
                ql.timTheoTienTo("Sua");

        ketQuaTienTo.hienThiDanhSach();

      

        System.out.println("\n===== TIM THEO HAU TO 'mi' =====");

        QuanLyHangThucPham ketQuaHauTo =
                ql.timTheoHauTo("mi");

        ketQuaHauTo.hienThiDanhSach();

        System.out.println("\n===== TIM GAN GIONG 'nuoc' =====");

        QuanLyHangThucPham ketQuaGanGiong =
                ql.timGanGiong("nuoc");

        ketQuaGanGiong.hienThiDanhSach();

      
        System.out.println("\n===== SAP XEP GIA TANG DAN =====");

        ql.sapXepTheoGia(true);

        ql.hienThiDanhSach();


        System.out.println("\n===== SAP XEP GIA GIAM DAN =====");

        ql.sapXepTheoGia(false);

        ql.hienThiDanhSach();

    
        System.out.println("\n===== SAP XEP THEO NGAY SAN XUAT TANG DAN =====");

        ql.sapXepTheoNgaySanXuat(true);

        ql.hienThiDanhSach();

     

        System.out.println("\n===== SAP XEP THEO NGAY HET HAN TANG DAN =====");

        ql.sapXepTheoNgayHetHan(true);

        ql.hienThiDanhSach();

      
        System.out.println(
                "\n===== TRICH LOC NGAY SAN XUAT "
                + "01/09/2026 -> 10/09/2026 ====="
        );

        QuanLyHangThucPham locTheoSX =
                ql.trichLocTheoNgaySanXuat(
                        LocalDate.of(2026, 9, 1),
                        LocalDate.of(2026, 9, 10)
                );

        locTheoSX.hienThiDanhSach();

   

        System.out.println(
                "\n===== TRICH LOC NGAY HET HAN "
                + "20/09/2026 -> 31/12/2026 ====="
        );

        QuanLyHangThucPham locTheoHH =
                ql.trichLocTheoNgayHetHan(
                        LocalDate.of(2026, 9, 20),
                        LocalDate.of(2026, 12, 31)
                );

        locTheoHH.hienThiDanhSach();

    

        System.out.println("\n===== THONG KE =====");

        ql.thongKe();

    
        System.out.println("\n===== THONG KE THANG 09/2026 =====");

        ql.thongKeTheoThang(9, 2026);

     

        System.out.println("\n===== SUA HANG CO ID = 2 =====");

        boolean suaThanhCong = ql.sua(
                2,
                "Banh mi sandwich",
                LocalDate.of(2026, 9, 5),
                LocalDate.of(2026, 10, 5),
                18000
        );

        if (suaThanhCong) {
            System.out.println("Sua thanh cong!");
        } else {
            System.out.println("Sua that bai!");
        }

        ql.hienThiDanhSach();


        System.out.println("\n===== XOA HANG CO ID = 4 =====");

        boolean xoaThanhCong = ql.xoa(4);

        if (xoaThanhCong) {
            System.out.println("Xoa thanh cong!");
        } else {
            System.out.println("Xoa that bai!");
        }

        ql.hienThiDanhSach();

   

        System.out.println("\n===== THONG KE SAU KHI SUA/XOA =====");

        ql.thongKe();

        System.out.println("\n===== CHUONG TRINH KET THUC =====");
    }
}
