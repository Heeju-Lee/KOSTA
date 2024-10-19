package com.service.spring.domain;

public class Company {
	private String vcode;
	private String vendor;

	public Company() {
		super();
	}

	public Company(String vcode, String vendor) {
		super();
		this.vcode = vcode;
		this.vendor = vendor;
	}

	public String getVcode() {
		return vcode;
	}

	public void setVcode(String vcode) {
		this.vcode = vcode;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	@Override
	public String toString() {
		return "Company [vcode=" + vcode + ", vendor=" + vendor + "]";
	}

}
