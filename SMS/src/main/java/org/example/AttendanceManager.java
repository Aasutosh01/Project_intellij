package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;

public class AttendanceManager {
    private static final String URL = "jdbc:sqlite:D:/project/SMS/src/main/school.db";

    private static final String INSERT_ATTENDANCE = "INSERT INTO attendance (student_id, class_id, date, present) VALUES (?, ?, ?, ?)";

    public static void insertAttendance(int studentId, int classId, Date date, boolean present) {
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(INSERT_ATTENDANCE)) {
            pstmt.setInt(1, studentId);
            pstmt.setInt(2, classId);
            pstmt.setDate(3, new java.sql.Date(date.getTime()));
            pstmt.setBoolean(4, present);
            pstmt.executeUpdate();
            System.out.println("Attendance data inserted successfully.");
        } catch (SQLException e) {
            System.err.println("Error inserting attendance data: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        // Example usage:
        int studentId = 1;
        int classId = 101;
        Date date = new Date(); // Current date
        boolean present = true;

        insertAttendance(studentId, classId, date, present);
    }
}
