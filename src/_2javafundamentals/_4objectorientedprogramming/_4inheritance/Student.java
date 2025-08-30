package _2javafundamentals._4objectorientedprogramming._4inheritance;

import java.time.Year;

public class Student extends Person {
    private String studentId;
    private int score;
    private Year graduationYear;

    public Student(String firstName, String lastName, String studentId) {
        super(firstName, lastName);
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getScore() {
        return score;
    }

    public Year getGraduationYear() {
        return graduationYear;
    }

    @Override
    public String toString() {
        return super.toString() + ", student ID: " + studentId;
    }
}
