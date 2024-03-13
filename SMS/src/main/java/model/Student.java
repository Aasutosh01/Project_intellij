package model;

public class Student {
    private int studentId;
    private String name;
    private String contactDetails;
    private String parentInfo;

    public Student(int studentId, String name, String contactDetails, String parentInfo) {
        this.studentId = studentId;
        this.name = name;
        this.contactDetails = contactDetails;
        this.parentInfo = parentInfo;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactDetails() {
        return contactDetails;
    }

    public void setContactDetails(String contactDetails) {
        this.contactDetails = contactDetails;
    }

    public String getParentInfo() {
        return parentInfo;
    }

    public void setParentInfo(String parentInfo) {
        this.parentInfo = parentInfo;
    }
}
