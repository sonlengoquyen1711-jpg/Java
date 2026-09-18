
import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
			
		System.out.println("Nhap so luong cong nhan: ");
		int n = sc.nextInt();
		sc.nextLine();
			
		//Tao danh sach cong nhan
		DanhSachCongNhan ds = new DanhSachCongNhan(n);
			
		//Nhap thong tin
		for(int i=0; i<n; i++) {
			System.out.println("Nhap thong tin CN thu "+(i+1));
			System.out.println("Nhap Ma cong nhan: ");
			String maCN = sc.nextLine();
			System.out.println("Nhap Ho: ");
			String mHo = sc.nextLine();
			System.out.println("Nhap Ten: ");
			String mTen = sc.nextLine();
			System.out.println("Nhap so san pham: ");
			int mSoSP = sc.nextInt();
			sc.nextLine();
				
			CongNhan cn = new CongNhan(maCN, mHo, mTen, mSoSP);

			if (ds.themCongNhan(cn)) {
			    System.out.println("Thêm thành công!");
			} else {
			        System.out.println("Danh sách đầy!");
			}
		}
			
			
		System.out.println("Tinh so luong cong nhan: "+ ds.tinhSoLuongCV());
			
			
		System.out.println("Xuat thong tin cong nhan lam tren 200 SP:");
		ds.xuatTTCNCC();
			
		System.out.println("Xuat danh sach giam dan: ");
		ds.sapXepGiam();
		ds.xuatTTCV();
		
	}
}
