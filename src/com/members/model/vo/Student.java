package com.members.model.vo;

public class Student {
	
	private String userId;
	private String studentTeacherStatus;
	private int point;
	private int penaltyPoint;
	private int reportStatus;
	private String interestingSubject;
	private String teamLeaderStatus;
	private int teamLeaderScore;
	private String enrollStudy;
	private String enrollLecture;
	private String lastLecture;
	private String lastStudy;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String userId, String studentTeacherStatus, int point, int penaltyPoint, int reportStatus,
			String interestingSubject, String teamLeaderStatus, int teamLeaderScore, String enrollStudy,
			String enrollLecture, String lastLecture, String lastStudy) {
		super();
		this.userId = userId;
		this.studentTeacherStatus = studentTeacherStatus;
		this.point = point;
		this.penaltyPoint = penaltyPoint;
		this.reportStatus = reportStatus;
		this.interestingSubject = interestingSubject;
		this.teamLeaderStatus = teamLeaderStatus;
		this.teamLeaderScore = teamLeaderScore;
		this.enrollStudy = enrollStudy;
		this.enrollLecture = enrollLecture;
		this.lastLecture = lastLecture;
		this.lastStudy = lastStudy;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStudentTeacherStatus() {
		return studentTeacherStatus;
	}

	public void setStudentTeacherStatus(String studentTeacherStatus) {
		this.studentTeacherStatus = studentTeacherStatus;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}

	public int getPenaltyPoint() {
		return penaltyPoint;
	}

	public void setPenaltyPoint(int penaltyPoint) {
		this.penaltyPoint = penaltyPoint;
	}

	public int getReportStatus() {
		return reportStatus;
	}

	public void setReportStatus(int reportStatus) {
		this.reportStatus = reportStatus;
	}

	public String getInterestingSubject() {
		return interestingSubject;
	}

	public void setInterestingSubject(String interestingSubject) {
		this.interestingSubject = interestingSubject;
	}

	public String getTeamLeaderStatus() {
		return teamLeaderStatus;
	}

	public void setTeamLeaderStatus(String teamLeaderStatus) {
		this.teamLeaderStatus = teamLeaderStatus;
	}

	public int getTeamLeaderScore() {
		return teamLeaderScore;
	}

	public void setTeamLeaderScore(int teamLeaderScore) {
		this.teamLeaderScore = teamLeaderScore;
	}

	public String getEnrollStudy() {
		return enrollStudy;
	}

	public void setEnrollStudy(String enrollStudy) {
		this.enrollStudy = enrollStudy;
	}

	public String getEnrollLecture() {
		return enrollLecture;
	}

	public void setEnrollLecture(String enrollLecture) {
		this.enrollLecture = enrollLecture;
	}

	public String getLastLecture() {
		return lastLecture;
	}

	public void setLastLecture(String lastLecture) {
		this.lastLecture = lastLecture;
	}

	public String getLastStudy() {
		return lastStudy;
	}

	public void setLastStudy(String lastStudy) {
		this.lastStudy = lastStudy;
	}

	@Override
	public String toString() {
		return "Student [userId=" + userId + ", studentTeacherStatus=" + studentTeacherStatus + ", point=" + point
				+ ", penaltyPoint=" + penaltyPoint + ", reportStatus=" + reportStatus + ", interestingSubject="
				+ interestingSubject + ", teamLeaderStatus=" + teamLeaderStatus + ", teamLeaderScore=" + teamLeaderScore
				+ ", enrollStudy=" + enrollStudy + ", enrollLecture=" + enrollLecture + ", lastLecture=" + lastLecture
				+ ", lastStudy=" + lastStudy + "]";
	}
	
	
	
	

}
