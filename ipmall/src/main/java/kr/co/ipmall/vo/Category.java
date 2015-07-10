package kr.co.ipmall.vo;

public class Category {
	private int category_no;
	private int upper_category_num;
	private String name;
	private int status;
	public int getCategory_no() {
		return category_no;
	}
	public void setCategory_no(int category_no) {
		this.category_no = category_no;
	}
	public int getUpper_category_num() {
		return upper_category_num;
	}
	public void setUpper_category_num(int upper_category_num) {
		this.upper_category_num = upper_category_num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
