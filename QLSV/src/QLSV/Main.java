package QLSV;

import java.util.Scanner;
public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		SV sv1=new SV(1,"Hoang",8,9);
		System.out.println("Nhap thong tin sv2:");
	    SV sv2 = SV.nhap();
	    SV sv3 = new SV();
	    System.out.println("Nhap thong tin sv3:");
	    Scanner sc = new Scanner(System.in);
	    System.out.print("Nhap ma SV: ");
	    sv3.setMaSV(sc.nextInt());
	    sc.nextLine();
	    System.out.print("Nhap ho ten: ");
	    sv3.setHoTen(sc.nextLine());
	    System.out.print("Nhap diem LT: ");
	    sv3.setDiemLT(sc.nextDouble());
	    System.out.print("Nhap diem TH: ");
	    sv3.setDiemTH(sc.nextDouble());
	    // Xuat
	    System.out.println("\nThong tin sinh vien:");
	    System.out.println(sv1);
	    System.out.println(sv2);
	    System.out.println(sv3);
	}

}
