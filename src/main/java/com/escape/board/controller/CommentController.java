package com.escape.board.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.escape.board.domain.CommentVo;
import com.escape.board.mapper.BoardMapper;
import com.escape.board.mapper.CommentMapper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class CommentController {

	// BOARD_COMMENT_TB
	@Autowired
	private CommentMapper commentMapper;
	@Autowired
	private BoardMapper boardMapper;

	@GetMapping("/Api/Board/{board_idx}/commentGet")
	@ResponseBody
	public List<CommentVo> commentGet(@PathVariable Long board_idx
	) {

		// 댓글 목록 조회
		List<CommentVo> commentList = commentMapper.getCommentList(board_idx);
		return commentList;
	}

	@PostMapping("/Api/Board/{board_idx}/commentCreate")
	@ResponseBody
	@Transactional
	public List<CommentVo> commentCreate(@PathVariable Long board_idx, @RequestBody CommentVo commentVo) {

		// 댓글 목록 조회
		List<CommentVo> commentList = commentMapper.getCommentList(board_idx);

		// 댓글 생성
		commentVo.setBoard_idx(board_idx);
		commentVo.setBoard_comment_idx(commentVo.getBoard_comment_idx());
		commentVo.setBoard_comment_like_idx(commentVo.getBoard_comment_like_idx());

		commentMapper.insertComment(commentVo);

		return commentList;
	}

	@PostMapping("/Api/Board/{board_idx}/{board_comment_idx}/commentDelete")
	@ResponseBody
	public List<CommentVo> deleteCreate(@PathVariable Long board_idx, @PathVariable Long board_comment_idx,
			@RequestBody CommentVo commentVo) {

		// 댓글 삭제
		commentVo.setBoard_comment_idx(board_comment_idx);
		commentVo.setBoard_idx(board_idx);
		commentMapper.deleteComment(commentVo);

		// 댓글 목록 조회
		List<CommentVo> commentList = commentMapper.getCommentList(commentVo);

		return commentList;
	}

	// ==================댓글 좋아요
	@PostMapping("/Api/Board/{board_idx}/{board_comment_idx}/addLike")
	@ResponseBody
	public ResponseEntity<String> AddLike(
				@PathVariable Long board_idx, 
				@PathVariable Long board_comment_idx,
				@RequestBody CommentVo commentVo
			) {

		commentVo.setBoard_idx(board_idx);
		commentVo.setBoard_comment_idx(board_comment_idx);

		CommentVo existingLike = commentMapper.selectLikes(commentVo);
		System.out.println("===============addLike === existingLike: " + existingLike);

		if (existingLike != null) {
			commentMapper.deleteLikes(commentVo);
			return ResponseEntity.ok("북마크가 존재함 delete");
		} else {
			commentMapper.addLikes(commentVo); // insert
			return ResponseEntity.ok("북마크가 존재안함 insert");
		}
	}

	@PostMapping("/Api/Board/{board_idx}/{board_comment_idx}/deleteLike")
	@ResponseBody
	public ResponseEntity<String> DeleteLike(
				@PathVariable Long board_idx, 
				@PathVariable Long board_comment_idx, 
				@RequestBody CommentVo commentVo
			) {

		System.out.println("======deletelike == board_idx: " + board_idx);
		System.out.println("======deletelike == board_comment_idx: " + board_comment_idx);

		commentVo.setBoard_idx(board_idx);
		commentVo.setBoard_comment_idx(board_comment_idx);

		commentMapper.deleteLikes(commentVo);

		return ResponseEntity.ok("delete");

	}

}