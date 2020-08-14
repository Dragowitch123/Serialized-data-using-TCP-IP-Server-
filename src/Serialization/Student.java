package Serialization;

import java.io.Serializable;

public class Student implements Serializable {
    private String name, mobile, email, rollno;
	private String course; course;

    public Student(String name, String mobile, String email, String rollno) {
        this.name = name;
        this.mobile = mobile;
        this.email = email;
        this.rollno = rollno;
        this.course = course;
    }

    public Student() {
    }

    public String getRollno() {
        return rollno;
    }

    public void setRollno(String rollno) {
        this.rollno = rollno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourse() {
        return getCourse();
    }

    public void setCourse(String course) {
        this.course = course;
    }
}