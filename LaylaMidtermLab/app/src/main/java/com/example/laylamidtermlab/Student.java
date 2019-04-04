package com.example.laylamidtermlab;

public class Student {
    private String name,dateOfBirth ;
    private double avg;
    private int phone;
    private boolean manle;

    public Student() {
    }

    public Student(String name, String dateOfBirth, double avg, int phone, boolean male) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.avg = avg;
        this.phone = phone;
        this.manle = male;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public boolean isMale() {
        return manle;
    }

    public void setMale(boolean manle) {
        this.manle = manle;
    }
}
