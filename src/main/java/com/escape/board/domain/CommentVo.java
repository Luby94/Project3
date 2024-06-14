package com.escape.board.domain;

public class CommentVo {
	
	private Long board_comment_idx;
	private Long board_idx;
	private String content;
	private String created;
	
	private Long board_comment_like_idx;
	private Long user_idx;
	
	public Long getBoard_comment_idx() {
		return board_comment_idx;
	}
	public void setBoard_comment_idx(Long board_comment_idx) {
		this.board_comment_idx = board_comment_idx;
	}
	public Long getBoard_idx() {
		return board_idx;
	}
	public void setBoard_idx(Long board_idx) {
		this.board_idx = board_idx;
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
	public Long getBoard_comment_like_idx() {
		return board_comment_like_idx;
	}
	public void setBoard_comment_like_idx(Long board_comment_like_idx) {
		this.board_comment_like_idx = board_comment_like_idx;
	}
	public Long getUser_idx() {
		return user_idx;
	}
	public void setUser_idx(Long user_idx) {
		this.user_idx = user_idx;
	}

	public CommentVo() {}
	public CommentVo(Long board_comment_idx, Long board_idx, String content, String created,
			Long board_comment_like_idx, Long user_idx) {
		super();
		this.board_comment_idx = board_comment_idx;
		this.board_idx = board_idx;
		this.content = content;
		this.created = created;
		this.board_comment_like_idx = board_comment_like_idx;
		this.user_idx = user_idx;
	}
	
	@Override
	public String toString() {
		return "CommentVo [board_comment_idx=" + board_comment_idx + ", board_idx=" + board_idx + ", content=" + content
				+ ", created=" + created + ", board_comment_like_idx=" + board_comment_like_idx + ", user_idx="
				+ user_idx + "]";
	}

}