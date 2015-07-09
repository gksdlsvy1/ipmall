package kr.co.ipmall.dao.vo;

import java.util.Date;

public class Seller extends User {
	private int seller_no;
	private String address;
	private String brNumber;
	

	public Seller(String email, String password, String name, String phone,
			int level, Date create_time, Date update_time, String accountNum, String accountName, int status,
			String address, String brNumber) {
		// TODO Auto-generated constructor stub
		super(email, password, name, phone, level, create_time, update_time, accountNum, accountName, status);
		this.address = address;
		this.brNumber = brNumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBrNumber() {
		return brNumber;
	}
	public void setBrNumber(String brNumber) {
		this.brNumber = brNumber;
	}
	public int getSeller_no() {
		return seller_no;
	}

}
