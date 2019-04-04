package com.example.studentlist;

public class Student {
private String name;
private int id;
private String major;
private boolean attendance ;
private double avg;
private String dateOfBirth;

    public Student() {
    }

    public Student(String name, int id, String major, boolean attendance, double avg, String DOB) {
        this.name = name;
        this.id = id;
        this.major = major;
        this.attendance = attendance;
        this.avg = avg;
        this.dateOfBirth = DOB;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public boolean isAttendance() {
        return attendance;
    }

    public void setAttendance(boolean attendance) {
        this.attendance = attendance;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}

