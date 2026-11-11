package QLSV;

import java.util.Scanner;

public class SV {
	// Khai bao bien
	private int maSV;
    private String hoTen;
    private double diemLT;
    private double diemTH;
    
	public int getMaSV() {
		return maSV;
	}

	public void setMaSV(int ma) throws Exception {
		if (ma>0) {
			this.maSV=ma;
		} else {
			throw new Exception("Loi!");
		}
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) throws Exception {
		if (hoTen!=null && !hoTen.trim().isEmpty()) {
			this.hoTen=hoTen;
		} else {
			throw new Exception("Loi");
		}
	}

	public double getDiemLT() {
		return diemLT;
	}

	public void setDiemLT(double diemLT) throws Exception {
		if (diemLT>=0 && diemLT<=10) {
			this.diemLT=diemLT;
		} else {
			throw new Exception("Loi");
		}
	}

	public double getDiemTH() {
		return diemTH;
	}

	public void setDiemTH(double diemTH) throws Exception {
		if (diemTH>=0 && diemTH<=10) {
			this.diemTH=diemTH;
		} else {
			throw new Exception("Loi");
		}
	}
	
	public SV(int maSV, String hoTen, double diemLT, double diemTH) throws Exception {
		setMaSV(maSV);
	    setHoTen(hoTen);
	    setDiemLT(diemLT);
	    setDiemTH(diemTH);
	}
	public SV() {
	    maSV = 0;
	    hoTen = "";
	    diemLT = 0;
	    diemTH = 0;
	}
	
	public double getaverage() {
		return (getDiemLT()+getDiemTH())/2;
	}
	public static final SV nhap() throws Exception {
		Scanner sc= new Scanner(System.in);
	    System.out.print("Nhap ma SV: ");
	    int maSV = sc.nextInt();
	    sc.nextLine();
	    System.out.print("Nhap ho ten: ");
	    String hoTen = sc.nextLine();
	    System.out.print("Nhap diem LT: ");
	    double diemLT = sc.nextDouble();
	    System.out.print("Nhap diem TH: ");
	    double diemTH = sc.nextDouble();
	    return new SV(maSV, hoTen, diemLT, diemTH);
	}
	
	@Override
	public String toString() {
		return String.format("%-10d %-20s %-10.2f %-10.2f %-10.2f", maSV,hoTen,diemLT,diemTH,getaverage());
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		SV sv1=new SV(1,"Hoang",8,9);
		System.out.println("Nhap thong tin sv2:");
	    SV sv2 = nhap();
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
