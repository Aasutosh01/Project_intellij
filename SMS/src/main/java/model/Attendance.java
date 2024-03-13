package model;

import java.util.Date;

public class Attendance {
    private int studentId;
    private int classId;
    private Date date;
    private boolean present;

    public Attendance(int studentId, int classId, Date date, boolean present) {
        this.studentId = studentId;
        this.classId = classId;
        this.date = date;
        this.present = present;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }


}
