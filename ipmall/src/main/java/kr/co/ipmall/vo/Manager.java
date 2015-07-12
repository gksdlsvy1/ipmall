package kr.co.ipmall.vo;

import java.util.Date;

public class Manager extends User{
	private int manager_no;
	private String department;
	private String position;
	public Manager(String email, String password, String name, String phone,
			int level, Date create_time, Date update_time, String accountNum, String accountName, int status , String department, String position) {
		// TODO Auto-generated constructor stub
		super(email, password, name, phone, level, create_time, update_time, accountNum, accountName, status);
		this.department = department;
		this.position = position;
	}
	
	public Manager(User user){
		super(user.getEmail(), user.getPw(), user.getName(), user.getPhone(), user.getLevel(), user.getCreate_time(), user.getUpdate_time(),
				user.getAccountNum(), user.getAccountName(), user.getStatus());
		this.department = ((Manager)user).getDepartment();
		this.position = ((Manager)user).getPosition();
	}
	
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public int getManager_no() {
		return manager_no;
	}

}
