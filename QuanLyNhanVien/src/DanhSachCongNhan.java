public class DanhSachCongNhan {
	private int count;
	private CongNhan[] ds;
		
	public DanhSachCongNhan(int n) {
		ds = new CongNhan[n];
		count = 0;
	}
		
	public boolean themCongNhan(CongNhan cn) {
		if(count < ds.length) {
			ds[count] = cn;
			count++;
			return true;
		}
		return false;
	}
		
	public void xuatTTCV() {
		for(int i=0; i<count; i++) {
			System.out.println(ds[i]);
		}
	}
		
	public int tinhSoLuongCV() {
		return count;
	}
		
	public void xuatTTCNCC() {
		for(int i = 0; i<count; i++) {
			if(ds[i].getmSoSP()>200) {
				System.out.println(ds[i]);
			}
		}
	}
		
	public void sapXepGiam() {
		for(int i=0; i< count-1; i++) {
			for(int j = i+1; j<count; j++) {
				if(ds[i].getmSoSP()<ds[j].getmSoSP()) {
					CongNhan temp = ds[i];
					ds[i] = ds[j];
					ds[j] = temp;
				}
			}
		}
	}
}

