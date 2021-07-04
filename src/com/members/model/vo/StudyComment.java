package com.members.model.vo;

import java.sql.Date;

public class StudyComment {

	private int studygroupNo;
	private int studycommentLevel;
	private String commentWriter;
	private String commentContent;
	private Date commentDate;
	private int commentReference;
	private int commentNo;
	
	public StudyComment() {
		// TODO Auto-generated constructor stub
	}

	public StudyComment(int studygroupNo, int studycommentLevel, String commentWriter, String commentContent,
			Date commentDate, int commentReference, int commentNo) {
		super();
		this.studygroupNo = studygroupNo;
		this.studycommentLevel = studycommentLevel;
		this.commentWriter = commentWriter;
		this.commentContent = commentContent;
		this.commentDate = commentDate;
		this.commentReference = commentReference;
		this.commentNo = commentNo;
	}

	public int getStudygroupNo() {
		return studygroupNo;
	}

	public void setStudygroupNo(int studygroupNo) {
		this.studygroupNo = studygroupNo;
	}

	public int getStudycommentLevel() {
		return studycommentLevel;
	}

	public void setStudycommentLevel(int studycommentLevel) {
		this.studycommentLevel = studycommentLevel;
	}

	public String getCommentWriter() {
		return commentWriter;
	}

	public void setCommentWriter(String commentWriter) {
		this.commentWriter = commentWriter;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public int getCommentReference() {
		return commentReference;
	}

	public void setCommentReference(int commentReference) {
		this.commentReference = commentReference;
	}

	public int getCommentNo() {
		return commentNo;
	}

	public void setCommentNo(int commentNo) {
		this.commentNo = commentNo;
	}

	@Override
	public String toString() {
		return "StudyComment [studygroupNo=" + studygroupNo + ", studycommentLevel=" + studycommentLevel
				+ ", commentWriter=" + commentWriter + ", commentContent=" + commentContent + ", commentDate="
				+ commentDate + ", commentReference=" + commentReference + ", commentNo=" + commentNo + "]";
	}
	
	
	
	
}
