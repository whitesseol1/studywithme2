package com.members.model.vo;

public class Teacher {
	
	private String userId;
	private String studentTeacherStatus;
	private String academicCareer;
	private String collegeName;
	private String major;
	private String certificate;
	private String career;
	private String selfIntroduction;
	private int teacherEvaluation;
	private String openLecture;
	private int penalty;
	private String lastLecture;
	
	public Teacher() {
		// TODO Auto-generated constructor stub
	}

	public Teacher(String userId, String studentTeacherStatus, String academicCareer, String collegeName, String major,
			String certificate, String career, String selfIntroduction, int teacherEvaluation, String openLecture,
			int penalty, String lastLecture) {
		super();
		this.userId = userId;
		this.studentTeacherStatus = studentTeacherStatus;
		this.academicCareer = academicCareer;
		this.collegeName = collegeName;
		this.major = major;
		this.certificate = certificate;
		this.career = career;
		this.selfIntroduction = selfIntroduction;
		this.teacherEvaluation = teacherEvaluation;
		this.openLecture = openLecture;
		this.penalty = penalty;
		this.lastLecture = lastLecture;
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

	public String getAcademicCareer() {
		return academicCareer;
	}

	public void setAcademicCareer(String academicCareer) {
		this.academicCareer = academicCareer;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}

	public String getSelfIntroduction() {
		return selfIntroduction;
	}

	public void setSelfIntroduction(String selfIntroduction) {
		this.selfIntroduction = selfIntroduction;
	}

	public int getTeacherEvaluation() {
		return teacherEvaluation;
	}

	public void setTeacherEvaluation(int teacherEvaluation) {
		this.teacherEvaluation = teacherEvaluation;
	}

	public String getOpenLecture() {
		return openLecture;
	}

	public void setOpenLecture(String openLecture) {
		this.openLecture = openLecture;
	}

	public int getPenalty() {
		return penalty;
	}

	public void setPenalty(int penalty) {
		this.penalty = penalty;
	}

	public String getLastLecture() {
		return lastLecture;
	}

	public void setLastLecture(String lastLecture) {
		this.lastLecture = lastLecture;
	}

	@Override
	public String toString() {
		return "Teacher [userId=" + userId + ", studentTeacherStatus=" + studentTeacherStatus + ", academicCareer="
				+ academicCareer + ", collegeName=" + collegeName + ", major=" + major + ", certificate=" + certificate
				+ ", career=" + career + ", selfIntroduction=" + selfIntroduction + ", teacherEvaluation="
				+ teacherEvaluation + ", openLecture=" + openLecture + ", penalty=" + penalty + ", lastLecture="
				+ lastLecture + "]";
	}

	
	
}
