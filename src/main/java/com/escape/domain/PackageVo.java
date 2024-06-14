package com.escape.domain;

public class PackageVo {
	int package_idx;
	int user_idx;
	String duration;
	String title;
	String start_date;
	String end_date;
	int limited_person;
	String price;
	String detail1;
	String detail2;
	String detail3;
	String zip_code;
	String address1;
	String address2;
	int ptype_idx;
	int hit;
	int category;

	public PackageVo() {}
	public PackageVo(int package_idx, int user_idx, String duration, String title, String start_date, String end_date,
			int limited_person, String price, String detail1, String detail2, String detail3, String zip_code,
			String address1, String address2, int ptype_idx, int hit, int category) {
		super();
		this.package_idx = package_idx;
		this.user_idx = user_idx;
		this.duration = duration;
		this.title = title;
		this.start_date = start_date;
		this.end_date = end_date;
		this.limited_person = limited_person;
		this.price = price;
		this.detail1 = detail1;
		this.detail2 = detail2;
		this.detail3 = detail3;
		this.zip_code = zip_code;
		this.address1 = address1;
		this.address2 = address2;
		this.ptype_idx = ptype_idx;
		this.hit = hit;
		this.category = category;
	}
	
	public int getPackage_idx() {
		return package_idx;
	}
	public void setPackage_idx(int package_idx) {
		this.package_idx = package_idx;
	}
	public int getUser_idx() {
		return user_idx;
	}
	public void setUser_idx(int user_idx) {
		this.user_idx = user_idx;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getStart_date() {
		return start_date;
	}
	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}
	public String getEnd_date() {
		return end_date;
	}
	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}
	public int getLimited_person() {
		return limited_person;
	}
	public void setLimited_person(int limited_person) {
		this.limited_person = limited_person;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getDetail1() {
		return detail1;
	}
	public void setDetail1(String detail1) {
		this.detail1 = detail1;
	}
	public String getDetail2() {
		return detail2;
	}
	public void setDetail2(String detail2) {
		this.detail2 = detail2;
	}
	public String getDetail3() {
		return detail3;
	}
	public void setDetail3(String detail3) {
		this.detail3 = detail3;
	}
	public String getZip_code() {
		return zip_code;
	}
	public void setZip_code(String zip_code) {
		this.zip_code = zip_code;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public int getPtype_idx() {
		return ptype_idx;
	}
	public void setPtype_idx(int ptype_idx) {
		this.ptype_idx = ptype_idx;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public int getCategory() {
		return category;
	}
	public void setCategory(int category) {
		this.category = category;
	}
	
	@Override
	public String toString() {
		return "PackageVo [package_idx=" + package_idx + ", user_idx=" + user_idx + ", duration=" + duration
				+ ", title=" + title + ", start_date=" + start_date + ", end_date=" + end_date + ", limited_person="
				+ limited_person + ", price=" + price + ", detail1=" + detail1 + ", detail2=" + detail2 + ", detail3="
				+ detail3 + ", zip_code=" + zip_code + ", address1=" + address1 + ", address2=" + address2
				+ ", ptype_idx=" + ptype_idx + ", hit=" + hit + ", category=" + category + "]";
	}
	
}
