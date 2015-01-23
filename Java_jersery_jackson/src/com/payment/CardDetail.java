package com.payment;

public class CardDetail {
	
	int ccno;
	int ccsec;
	String ccholder;
	String cctype;
	public int getCcno() {
		return ccno;
	}
	public CardDetail(int ccno, int ccsec, String ccholder, String cctype) {
		super();
		this.ccno = ccno;
		this.ccsec = ccsec;
		this.ccholder = ccholder;
		this.cctype = cctype;
	}
	public void setCcno(int ccno) {
		this.ccno = ccno;
	}
	public int getCcsec() {
		return ccsec;
	}
	public void setCcsec(int ccsec) {
		this.ccsec = ccsec;
	}
	public String getCcholder() {
		return ccholder;
	}
	public void setCcholder(String ccholder) {
		this.ccholder = ccholder;
	}
	public String getCctype() {
		return cctype;
	}
	public void setCctype(String cctype) {
		this.cctype = cctype;
	}

}
