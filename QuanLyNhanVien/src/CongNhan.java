public class CongNhan {
		private String maCN;
		private String mHo;
		private String mTen;
		private int mSoSP;

		public String getMaCN() {
			return maCN;
		}
		public void setMaCN(String maCN) {
			this.maCN = maCN;
		}
		public String getmHo() {
			return mHo;
		}
		public void setmHo(String mHo) {
			this.mHo = mHo;
		}
		public String getmTen() {
			return mTen;
		}
		public void setmTen(String mTen) {
			this.mTen = mTen;
		}
		public int getmSoSP() {
			return mSoSP;
		}
		public void setmSoSP(int mSoSP) {
			if(mSoSP<0) {
				System.out.println("Error");
			}
			else {
				this.mSoSP = mSoSP;
			}
		}
		
		public CongNhan(String maCN, String mHo, String mTen, int mSoSP) {
			super();
			this.maCN = maCN;
			this.mHo = mHo;
			this.mTen = mTen;
			this.mSoSP = mSoSP;
		}
		public double tinhLuong(int mSoSP) {
			if(mSoSP<=199 && mSoSP>=1) {
				return mSoSP*0.5;
			}
			else if(mSoSP<=399 && mSoSP>=200) {
				return mSoSP*0.55;
			}
			else if(mSoSP<=599 && mSoSP>=400) {
				return mSoSP*0.6;
			}
			else if(mSoSP>=600) {
				return mSoSP*0.65;
			}
			else {
				return 0;
			}
		}
		@Override
		public String toString() {
			return "maCN = " + maCN + ", Ho = " + mHo + ", Ten = " + mTen + ", So san pham = " + mSoSP + ", Luong = " + tinhLuong(mSoSP);
		}
	}	