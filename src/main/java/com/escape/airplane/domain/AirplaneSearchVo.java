package com.escape.airplane.domain;

public class AirplaneSearchVo {

	// Field
	private int airplane_time_idx;
	private int airplane_idx;
	private String start_date;
	private String end_date;
	private String start_time;
	private String end_time;
	private int departure_loc;
	private int arrival_loc;
	private int known;
	
	// Constructor
	public AirplaneSearchVo() {}
	public AirplaneSearchVo(int airplane_time_idx, int airplane_idx, String start_date, String end_date,
			String start_time, String end_time, int departure_loc, int arrival_loc, int known) {
		this.airplane_time_idx = airplane_time_idx;
		this.airplane_idx = airplane_idx;
		this.start_date = start_date;
		this.end_date = end_date;
		this.start_time = start_time;
		this.end_time = end_time;
		this.departure_loc = departure_loc;
		this.arrival_loc = arrival_loc;
		this.known = known;
	}
	
	// Getter/Setter
	public int getAirplane_time_idx() {
		return airplane_time_idx;
	}
	public void setAirplane_time_idx(int airplane_time_idx) {
		this.airplane_time_idx = airplane_time_idx;
	}
	public int getAirplane_idx() {
		return airplane_idx;
	}
	public void setAirplane_idx(int airplane_idx) {
		this.airplane_idx = airplane_idx;
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
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public int getDeparture_loc() {
		return departure_loc;
	}
	public void setDeparture_loc(int departure_loc) {
		this.departure_loc = departure_loc;
	}
	public int getArrival_loc() {
		return arrival_loc;
	}
	public void setArrival_loc(int arrival_loc) {
		this.arrival_loc = arrival_loc;
	}
	public int getKnown() {
		return known;
	}
	public void setKnown(int known) {
		this.known = known;
	}
	
	// toString
	@Override
	public String toString() {
		return "AirplaneSearchVo [airplane_time_idx=" + airplane_time_idx + ", airplane_idx=" + airplane_idx
				+ ", start_date=" + start_date + ", end_date=" + end_date + ", start_time=" + start_time + ", end_time="
				+ end_time + ", departure_loc=" + departure_loc + ", arrival_loc=" + arrival_loc + ", known=" + known
				+ "]";
	}
	
}
