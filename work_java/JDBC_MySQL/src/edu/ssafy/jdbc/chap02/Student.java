package edu.ssafy.jdbc.chap02;

public class Student {
	private String name;
	private int hakbun;
	private String gender;
	private String birthday;

	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(String ename, int hakbun, String gender, String birthday) {
		super();
		this.name = ename;
		this.hakbun = hakbun;
		this.gender = gender;
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "Student [ename=" + name + ", hakbun=" + hakbun + ", gender=" + gender + ", birthday=" + birthday + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String ename) {
		this.name = ename;
	}

	public int getHakbun() {
		return hakbun;
	}

	public void setHakbun(int hakbun) {
		this.hakbun = hakbun;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
}
