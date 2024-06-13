package com.escape.login.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	
    private int user_idx;
    private String id;
    private String passwd;
    private String email;
    private int type;

    public User() {}
	public User(int user_idx, String id, String passwd, String email, int type) {
		super();
		this.user_idx = user_idx;
		this.id = id;
		this.passwd = passwd;
		this.email = email;
		this.type = type;
	}
	
	public int getUser_idx() {
		return user_idx;
	}
	public void setUser_idx(int user_idx) {
		this.user_idx = user_idx;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPasswd() {
		return passwd;
	}
	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	
	@Override
	public String toString() {
		return "User [user_idx=" + user_idx + ", id=" + id + ", passwd=" + passwd + ", email=" + email + ", type="
				+ type + "]";
	}
    
}