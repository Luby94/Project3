package com.escape.kakao.domain;

public class PaymentVo {
	
	// APPLY_TB
    private int apply_idx;
    private int user_idx;
    private int package_idx;
    private int room_idx;
    private int airplane_time_idx;
    private int apply_su;
    private int state;
    private String created;

    // CARD_TB
    private int card_idx;

    public PaymentVo() {}
	public PaymentVo(int apply_idx, int user_idx, int package_idx, int room_idx, int airplane_time_idx, int apply_su,
			int state, String created, int card_idx) {
		super();
		this.apply_idx = apply_idx;
		this.user_idx = user_idx;
		this.package_idx = package_idx;
		this.room_idx = room_idx;
		this.airplane_time_idx = airplane_time_idx;
		this.apply_su = apply_su;
		this.state = state;
		this.created = created;
		this.card_idx = card_idx;
	}
	
	public int getApply_idx() {
		return apply_idx;
	}
	public void setApply_idx(int apply_idx) {
		this.apply_idx = apply_idx;
	}
	public int getUser_idx() {
		return user_idx;
	}
	public void setUser_idx(int user_idx) {
		this.user_idx = user_idx;
	}
	public int getPackage_idx() {
		return package_idx;
	}
	public void setPackage_idx(int package_idx) {
		this.package_idx = package_idx;
	}
	public int getRoom_idx() {
		return room_idx;
	}
	public void setRoom_idx(int room_idx) {
		this.room_idx = room_idx;
	}
	public int getAirplane_time_idx() {
		return airplane_time_idx;
	}
	public void setAirplane_time_idx(int airplane_time_idx) {
		this.airplane_time_idx = airplane_time_idx;
	}
	public int getApply_su() {
		return apply_su;
	}
	public void setApply_su(int apply_su) {
		this.apply_su = apply_su;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public int getCard_idx() {
		return card_idx;
	}
	public void setCard_idx(int card_idx) {
		this.card_idx = card_idx;
	}
	
	@Override
	public String toString() {
		return "PaymentVo [apply_idx=" + apply_idx + ", user_idx=" + user_idx + ", package_idx=" + package_idx
				+ ", room_idx=" + room_idx + ", airplane_time_idx=" + airplane_time_idx + ", apply_su=" + apply_su
				+ ", state=" + state + ", created=" + created + ", card_idx=" + card_idx + "]";
	}

}
