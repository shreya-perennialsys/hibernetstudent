package com.example.hibernetstudent;

public class Student {

    private int roll;
    private int marks;
    private String grade;
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMarks() {
        return marks;
    }

    public int getRoll() {
        return roll;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public void setRoll(int roll) {
        this.roll = roll;
    }

}
