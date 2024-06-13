package com.escape.board.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BoardVo {
	 private Long board_idx;
	 private Long user_idx;
	 private String title;
	 private String content;
	 private String created;
	 private int hit;

	 public BoardVo() {}
	 public BoardVo(Long board_idx, Long user_idx, String title, String content, String created, int hit) {
		super();
		this.board_idx = board_idx;
		this.user_idx = user_idx;
		this.title = title;
		this.content = content;
		this.created = created;
		this.hit = hit;
	}
	 
	public Long getBoard_idx() {
		return board_idx;
	}
	public void setBoard_idx(Long board_idx) {
		this.board_idx = board_idx;
	}
	public Long getUser_idx() {
		return user_idx;
	}
	public void setUser_idx(Long user_idx) {
		this.user_idx = user_idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	
	@Override
	public String toString() {
		return "BoardVo [board_idx=" + board_idx + ", user_idx=" + user_idx + ", title=" + title + ", content="
				+ content + ", created=" + created + ", hit=" + hit + "]";
	}
	 
}
