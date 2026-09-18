public class CD {
	//Khai bao thuoc tinh (Dong goi)
	private String maCD;  //Ma CD - duy nhat dung de dinh danh
	private String tuaCD; //Tua de CD
	private String caSy;  //Ten ca sy
	private int soBaiHat; //so bai hat (rang buoc > 0)
	private float gia;    //Don gia
	
	//Getter / Setter
	public String getMaCD() {
		return maCD;
	}
	public void setMaCD(String maCD) {
		this.maCD = maCD;
	}
	public String getTuaCD() {
		return tuaCD;
	}
	public void setTuaCD(String tuaCD) {
		this.tuaCD = tuaCD;
	}
	public String getCaSy() {
		return caSy;
	}
	public void setCaSy(String caSy) {
		this.caSy = caSy;
	}
	public int getSoBaiHat() {
		return soBaiHat;
	}
	public void setSoBaiHat(int soBai) throws Exception{
		if(soBai>0) {
			this.soBaiHat = soBaiHat;
		} else {
			throw new Exception("So bai hat phai lon hon 0");
		}
	}
/**
 * Setter co rang buoc: so bai hat phai > 0
 * 
 */
	public float getGia() {
		return gia;
	}
	public void setGia(float gia) {
		this.gia = gia;
	}
	//Constructor rong
	public CD() { }
	/**
	 * Constructor day du
	 * @param tuaCD tua de CD
	 * @param caSyten ca sy
	 * @param soBai so bai hat (phai >0)
	 * @param gia don gia
	 * @param maCD ma CD
	 * @throws Exception neu soBai <=0
	 */
	public CD(String tuaCD, String caSy, int soBai, float gia, String maCD) throws Exception{
		this.tuaCD = tuaCD;
		this.caSy = caSy;
		this.setSoBaiHat(soBai); //Tai su dung rang buoc
		this.gia = gia;
		this.maCD = maCD;
	}
	//In tieu de bang
	/**
	 * phuong thuc tinh: in dong tieu de cho bang danh sach CD
	 * Su dung String.format de can le cot
	 */
	public static void tieuDe() {
		System.out.println("In danh sach CD");
		//Ve dong gach ngang
		for(int i=0; i<100; i++) System.out.println("-");
		System.out.println();
		
		//In tieu de tung cot (canh phai 10 ky tu)
		String s = String.format("|%10s|%10s|%10s|%10s|%10s|%10s|", "Ma CD", "Tua CD", "Ca Sy", "So Bai", "Don Gia", "Thanh Tien");
		System.out.println(s);
		
		//Ve dong gach ngang phia duoi
		for(int i = 0; i<100; i++)
			System.out.println("-");
		System.out.println();
	}
	
	//Ghi de toString
	/**
	 * Tra ve chuoi bieu dien 1 CD
	 * Duoc goi tu dung khi in: sysout(cd)
	 */
	public String toString() {
		return String.format("|%10s|%10s|%10s|%10s|%10.2f|%10.2f",maCD,tuaCD,caSy,soBaiHat,gia,gia*soBaiHat);
	}
}
