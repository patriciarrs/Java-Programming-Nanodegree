package _2javafundamentals._4objectorientedprogramming._4inheritance;

public class Student extends Person {
    private String studentId;
    private int score;

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

    @Override
    public String toString() {
        return super.toString() + ", student ID: " + studentId;
    }
}
