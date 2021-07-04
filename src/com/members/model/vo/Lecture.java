package com.members.model.vo;

public class Lecture {
	
	private int lectureNo;
	private String memberId;
	private String subject;
	private String lectureName;
	private String lectureIntroduction;
	private String lecIntroPhoto;
	private String lecPhotoRenamed;
	private String level;
	private String lectureHours; //총시간 
	private String totalTimes; //총횟수
	private String frequency;
	private String startDate;
	private String day;
	private String lectureStartTime;
	private String fixedTimeStatus;
	private String age;
	private String totalNumber; //총회원
	private String lectureNotice;
	private String noticeOriFile;
	private String noticeRenamed;
	private String lectureType;
	private String lectureStatus;
	private int price;
	
	
	public Lecture() {
		// TODO Auto-generated constructor stub
	}


	public Lecture(int lectureNo, String memberId, String subject, String lectureName, String lectureIntroduction,
			String lecIntroPhoto, String lecPhotoRenamed, String level, String lectureHours, String totalTimes,
			String frequency, String startDate, String day, String lectureStartTime, String fixedTimeStatus, String age,
			String totalNumber, String lectureNotice, String noticeOriFile, String noticeRenamed, String lectureType,
			String lectureStatus, int price) {
		super();
		this.lectureNo = lectureNo;
		this.memberId = memberId;
		this.subject = subject;
		this.lectureName = lectureName;
		this.lectureIntroduction = lectureIntroduction;
		this.lecIntroPhoto = lecIntroPhoto;
		this.lecPhotoRenamed = lecPhotoRenamed;
		this.level = level;
		this.lectureHours = lectureHours;
		this.totalTimes = totalTimes;
		this.frequency = frequency;
		this.startDate = startDate;
		this.day = day;
		this.lectureStartTime = lectureStartTime;
		this.fixedTimeStatus = fixedTimeStatus;
		this.age = age;
		this.totalNumber = totalNumber;
		this.lectureNotice = lectureNotice;
		this.noticeOriFile = noticeOriFile;
		this.noticeRenamed = noticeRenamed;
		this.lectureType = lectureType;
		this.lectureStatus = lectureStatus;
		this.price = price;
	}


	public int getLectureNo() {
		return lectureNo;
	}


	public void setLectureNo(int lectureNo) {
		this.lectureNo = lectureNo;
	}


	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}


	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject) {
		this.subject = subject;
	}


	public String getLectureName() {
		return lectureName;
	}


	public void setLectureName(String lectureName) {
		this.lectureName = lectureName;
	}


	public String getLectureIntroduction() {
		return lectureIntroduction;
	}


	public void setLectureIntroduction(String lectureIntroduction) {
		this.lectureIntroduction = lectureIntroduction;
	}


	public String getLecIntroPhoto() {
		return lecIntroPhoto;
	}


	public void setLecIntroPhoto(String lecIntroPhoto) {
		this.lecIntroPhoto = lecIntroPhoto;
	}


	public String getLecPhotoRenamed() {
		return lecPhotoRenamed;
	}


	public void setLecPhotoRenamed(String lecPhotoRenamed) {
		this.lecPhotoRenamed = lecPhotoRenamed;
	}


	public String getLevel() {
		return level;
	}


	public void setLevel(String level) {
		this.level = level;
	}


	public String getLectureHours() {
		return lectureHours;
	}


	public void setLectureHours(String lectureHours) {
		this.lectureHours = lectureHours;
	}


	public String getTotalTimes() {
		return totalTimes;
	}


	public void setTotalTimes(String totalTimes) {
		this.totalTimes = totalTimes;
	}


	public String getFrequency() {
		return frequency;
	}


	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}


	public String getStartDate() {
		return startDate;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	public String getDay() {
		return day;
	}


	public void setDay(String day) {
		this.day = day;
	}


	public String getLectureStartTime() {
		return lectureStartTime;
	}


	public void setLectureStartTime(String lectureStartTime) {
		this.lectureStartTime = lectureStartTime;
	}


	public String getFixedTimeStatus() {
		return fixedTimeStatus;
	}


	public void setFixedTimeStatus(String fixedTimeStatus) {
		this.fixedTimeStatus = fixedTimeStatus;
	}


	public String getAge() {
		return age;
	}


	public void setAge(String age) {
		this.age = age;
	}


	public String getTotalNumber() {
		return totalNumber;
	}


	public void setTotalNumber(String totalNumber) {
		this.totalNumber = totalNumber;
	}


	public String getLectureNotice() {
		return lectureNotice;
	}


	public void setLectureNotice(String lectureNotice) {
		this.lectureNotice = lectureNotice;
	}


	public String getNoticeOriFile() {
		return noticeOriFile;
	}


	public void setNoticeOriFile(String noticeOriFile) {
		this.noticeOriFile = noticeOriFile;
	}


	public String getNoticeRenamed() {
		return noticeRenamed;
	}


	public void setNoticeRenamed(String noticeRenamed) {
		this.noticeRenamed = noticeRenamed;
	}


	public String getLectureType() {
		return lectureType;
	}


	public void setLectureType(String lectureType) {
		this.lectureType = lectureType;
	}


	public String getLectureStatus() {
		return lectureStatus;
	}


	public void setLectureStatus(String lectureStatus) {
		this.lectureStatus = lectureStatus;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return "Lecture [lectureNo=" + lectureNo + ", memberId=" + memberId + ", subject=" + subject + ", lectureName="
				+ lectureName + ", lectureIntroduction=" + lectureIntroduction + ", lecIntroPhoto=" + lecIntroPhoto
				+ ", lecPhotoRenamed=" + lecPhotoRenamed + ", level=" + level + ", lectureHours=" + lectureHours
				+ ", totalTimes=" + totalTimes + ", frequency=" + frequency + ", startDate=" + startDate + ", day="
				+ day + ", lectureStartTime=" + lectureStartTime + ", fixedTimeStatus=" + fixedTimeStatus + ", age="
				+ age + ", totalNumber=" + totalNumber + ", lectureNotice=" + lectureNotice + ", noticeOriFile="
				+ noticeOriFile + ", noticeRenamed=" + noticeRenamed + ", lectureType=" + lectureType
				+ ", lectureStatus=" + lectureStatus + ", price=" + price + "]";
	}
	
	
	
	

}
