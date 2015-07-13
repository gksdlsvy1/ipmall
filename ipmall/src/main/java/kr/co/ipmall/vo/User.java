package kr.co.ipmall.vo;

import java.util.Date;

public class User {

	private Long user_no;
	private String email;
	private String pw;
	private String confirmPassword;
	private String name;
	private String phone;
	private int level;
	private Date create_time;
	private Date update_time;
	private String password;
	private String accountNum;
	private String accountName;
	/*
	private String accountNum;
	private String accountName;
	*/
	private int status;
	
	public final static int MANAGER = 1;
	public final static int CUSTOMER = 2;
	public final static int SELLER = 3;
	public final static int ACTIVE = 1;
	public final static int INACTIVE = 2;
	
	public User(){};

	public User(String email, String password, String name, String phone, int level, Date create_time, Date update_time,
			String accountNum, String accountName, int status) {
		System.out.println("User 생성자");
		this.email = email;
		this.pw = password;
		this.name = name;
		this.phone = phone;
		this.level = level;
		this.create_time = create_time;
		this.update_time = update_time;
		this.accountNum = accountNum;
		this.accountName = accountName;
		this.status = status;
	}

	public void setUserNo(Long user_no) {
		this.user_no = user_no;
	}

	public Long getUserNo() {
		return user_no;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}


	public String getName() {
		return name;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public int getLevel() {
		return level;
	}
	
	public void setLevel(int level) {
		this.level = level;
	}

	public Date getCreateTime() {
		return create_time;
	}
	
	public Date getUpdateTime() {
		return update_time;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}

	public Long getUser_no() {
		return user_no;
	}

	public void setUser_no(Long user_no) {
		this.user_no = user_no;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Date getUpdate_time() {
		return update_time;
	}

	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}


	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public void changePassword(String oldPassword, String newPassword) {
		if (!pw.equals(oldPassword))
			throw new kr.co.ipmall.model.exception.IdPasswordNotMatchingException();
		this.pw = newPassword;
	}
	
	public boolean matchPassword(String pwd) {
		System.out.println(this.pw);
		return this.pw.equals(pwd);
	}
	public boolean isPasswordEqualToConfirmPassword() {
		return pw.equals(confirmPassword);
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
