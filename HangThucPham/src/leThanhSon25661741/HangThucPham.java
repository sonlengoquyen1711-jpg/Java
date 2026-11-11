package leThanhSon25661741;

import java.time.LocalDate;

public class HangThucPham {
	private int id;
	private final String maHang;
	private String tenHang;
	private LocalDate ngaySanXuat;
	private LocalDate ngayHetHan;
	private float gia;
	
	private static int demSoLuong = 0;

	//Constructor mac dinh
	public HangThucPham() {
	
		this.id = ++demSoLuong;
		this.maHang = "Mac_Dinh";
		this.tenHang = "Hang mac dinh";
		this.ngaySanXuat = LocalDate.now();
		this.ngayHetHan = LocalDate.now().plusDays(7);
		this.gia = 1.0f;
	}

	public HangThucPham(int id, String maHang, String tenHang, LocalDate ngaySanXuat, LocalDate ngayHetHan, float gia) {
		
		this.id = ++demSoLuong;
		
		if(maHang == null || maHang.trim().isEmpty())
			throw new IllegalArgumentException("Ma hang khong duoc de trong!");
		if(tenHang == null || tenHang.trim().isEmpty())
			throw new IllegalArgumentException("Ten hang khong duoc de trong!");
		if(gia<=0)
			throw new IllegalArgumentException("Gia phai lon hon 0!");
		if(!kiemTraNgaySanXuat(ngaySanXuat))
			throw new IllegalArgumentException("Ngay san xuat khong duoc la tuong lai!");
		if(!kiemTraNgayHetHan(ngaySanXuat, ngayHetHan))
			throw new IllegalArgumentException("Ngay het han phai sau ngay san xuat");
		
		this.maHang = maHang;
		this.tenHang = tenHang;
		this.ngaySanXuat = ngaySanXuat;
		this.ngayHetHan = ngayHetHan;
		this.gia = gia;
	}
	//Kiem tra ngay
	private boolean kiemTraNgaySanXuat(LocalDate ngaySanXuat) {
		return ngaySanXuat != null && !ngaySanXuat.isAfter(LocalDate.now());
	}
	private boolean kiemTraNgayHetHan(LocalDate ngaySanXuat, LocalDate ngayHetHan) {
		return ngaySanXuat != null && ngayHetHan!=null && ngayHetHan.isAfter(ngaySanXuat);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenHang() {
		return tenHang;
	}

	public void setTenHang(String tenHang) {
		if(tenHang == null || tenHang.trim().isEmpty())
			throw new IllegalArgumentException("Ten hang khong duoc bo trong");
		this.tenHang = tenHang;
	}

	public LocalDate getNgaySanXuat() {
		return ngaySanXuat;
	}

	public void setNgaySanXuat(LocalDate ngaySanXuat) {
		if(!kiemTraNgaySanXuat(ngaySanXuat))
			throw new IllegalArgumentException("Ngay san xuat khong duoc la tuong lai!");
		if(this.ngayHetHan != null && !kiemTraNgayHetHan(ngaySanXuat, this.ngayHetHan))
			throw new IllegalArgumentException("Ngay san xuat phai truoc ngay het han!");
		this.ngaySanXuat = ngaySanXuat;
	}

	public LocalDate getNgayHetHan() {
		return ngayHetHan;
	}

	public void setNgayHetHan(LocalDate ngayHetHan) {
		if(!kiemTraNgayHetHan(ngaySanXuat, ngayHetHan))
			throw new IllegalArgumentException("Ngay het han phai sau ngay san xuat");
		if(!(this.ngaySanXuat==null))
			throw new IllegalArgumentException("Ngay het han phai sau ngay san xuat!");
		this.ngayHetHan = ngayHetHan;
	}

	public float getGia() {
		return gia;
	}

	public void setGia(float gia) {
		if(gia<=0)
			throw new IllegalArgumentException("Gia phai lon hon 0!");
		this.gia = gia;
	}

	public static int getDemSoLuong() {
		return demSoLuong;
	}

	public static void setDemSoLuong(int demSoLuong) {
		HangThucPham.demSoLuong = demSoLuong;
	}

	public String getMaHang() {
		return maHang;
	}
}
