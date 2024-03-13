package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Student;
import model.Attendance;

public class DatabaseManager {
    private static final String URL = "jdbc:sqlite:D:/project/SMS/src/main/school.db";
    private static Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = DriverManager.getConnection(URL);
        }
        return connection;
    }



    public static void createStudent(Student student) throws SQLException {
        String query = "INSERT INTO students (student_id, name, contact_details, parent_info) VALUES (?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement p = conn.prepareStatement(query)) {
            p.setInt(1, student.getStudentId());
            p.setString(2, student.getName());
            p.setString(3, student.getContactDetails());
            p.setString(4, student.getParentInfo());
            p.executeUpdate();
        }
    }

    public static Student readStudent(int studentId) throws SQLException {
        String query = "SELECT * FROM students WHERE student_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement p= conn.prepareStatement(query)) {
            p.setInt(1, studentId);
            ResultSet rs = p.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("student_id");
                String name = rs.getString("name");
                String contactDetails = rs.getString("contact_details");
                String parentInfo = rs.getString("parent_info");
                return new Student(id, name, contactDetails, parentInfo);
            }
        }
        return null;
    }

    public static void updateStudent(Student student) throws SQLException {
        String query = "UPDATE students SET name = ?, contact_details = ?, parent_info = ? WHERE student_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement p = conn.prepareStatement(query)) {
            p.setString(1, student.getName());
            p.setString(2, student.getContactDetails());
            p.setString(3, student.getParentInfo());
            p.setInt(4, student.getStudentId());
            p.executeUpdate();
        }
    }

    public static void deleteStudent(int studentId) throws SQLException {
        String query = "DELETE FROM students WHERE student_id = ?";
        try (Connection conn = getConnection();
             PreparedStatement p = conn.prepareStatement(query)) {
            p.setInt(1, studentId);
            p.executeUpdate();
        }
    }
}
