package com.escape.airplane.domain;

public class AirplaneVo {

	// City
	private int city_idx;
	
	// Country(City 중복)
	private int country_idx;
	private String name;
	private String ename;
	
	
	// 생성자
	public AirplaneVo() {}
	public AirplaneVo(int city_idx, int country_idx, String name, String ename) {
		super();
		this.city_idx = city_idx;
		this.country_idx = country_idx;
		this.name = name;
		this.ename = ename;
	}
	
	// Getter/Setter
	public int getCity_idx() {
		return city_idx;
	}
	public void setCity_idx(int city_idx) {
		this.city_idx = city_idx;
	}
	public int getCountry_idx() {
		return country_idx;
	}
	public void setCountry_idx(int country_idx) {
		this.country_idx = country_idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	
	// toString
	@Override
	public String toString() {
		return "AirplaneVo [city_idx=" + city_idx + ", country_idx=" + country_idx + ", name=" + name + ", ename="
				+ ename + "]";
	}
	
}
