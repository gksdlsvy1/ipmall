package kr.co.ipmall.vo;

import java.util.Date;

public class Customer extends User{
	private int customer_no;
	private String birthday;
	private int sex;
	
	public Customer(){
		//super();
	}
	
	public Customer(String email, String password, String name, String phone,
			int level, Date create_time, Date update_time, String accountNum, String accountName, int status,
			String birthday, int sex ) {
		// TODO Auto-generated constructor stub
		super(email, password, name, phone, level, create_time, update_time, accountNum, accountName, status);
		this.birthday = birthday;
		this.sex = sex;
	}
	
	public Customer(User user){
		super(user.getEmail(), user.getPw(), user.getName(), user.getPhone(), user.getLevel(), user.getCreate_time(), user.getUpdate_time(),
				user.getAccountNum(), user.getAccountName(), user.getStatus());
		this.birthday = ((Customer)user).getBirthday();
		this.sex = ((Customer)user).getSex();
	}
	
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public int getCustomer_no() {
		return customer_no;
	}
}
