package com.escape.kakao.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaymentVo {
	
    //private String orderId;	// apply_idx
    //private String userId;	// user_idx
    //private int amount;	// apply_su
    
    private int apply_idx;
    private int card_idx;
    private int user_idx;
    private int package_idx;
    private int room_idx;
    private int airplane_time_idx;
    private int state;
    private int apply_su;
    private String created;
    
    public PaymentVo() {}
	public PaymentVo(int apply_idx, int card_idx, int user_idx, int package_idx, int room_idx, int airplane_time_idx,
			int state, int apply_su, String created) {
		super();
		this.apply_idx = apply_idx;
		this.card_idx = card_idx;
		this.user_idx = user_idx;
		this.package_idx = package_idx;
		this.room_idx = room_idx;
		this.airplane_time_idx = airplane_time_idx;
		this.state = state;
		this.apply_su = apply_su;
		this.created = created;
	}
	
	public int getApply_idx() {
		return apply_idx;
	}
	public void setApply_idx(int apply_idx) {
		this.apply_idx = apply_idx;
	}
	public int getCard_idx() {
		return card_idx;
	}
	public void setCard_idx(int card_idx) {
		this.card_idx = card_idx;
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
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public int getApply_su() {
		return apply_su;
	}
	public void setApply_su(int apply_su) {
		this.apply_su = apply_su;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	
	@Override
	public String toString() {
		return "PaymentVo [apply_idx=" + apply_idx + ", card_idx=" + card_idx + ", user_idx=" + user_idx
				+ ", package_idx=" + package_idx + ", room_idx=" + room_idx + ", airplane_time_idx=" + airplane_time_idx
				+ ", state=" + state + ", apply_su=" + apply_su + ", created=" + created + "]";
	}
    
}
