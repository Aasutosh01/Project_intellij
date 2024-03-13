package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Create {
    private static final String URL = "jdbc:sqlite:D:/project/SMS/src/main/school.db";

    private static final String STUDENTS = "CREATE TABLE IF NOT EXISTS students (" +
            "student_id INTEGER PRIMARY KEY," +
            "name TEXT NOT NULL," +
            "contact_details TEXT," +
            "parent_info TEXT" +
            ")";

    private static final String ATTENDANCE = "CREATE TABLE IF NOT EXISTS attendance (" +
            "attendance_id INTEGER PRIMARY KEY," +
            "student_id INTEGER," +
            "class_id INTEGER," +
            "date DATE," +
            "present BOOLEAN," +
            "FOREIGN KEY(student_id) REFERENCES students(student_id)," +
            "FOREIGN KEY(class_id) REFERENCES classes(class_id)" +
            ")";

    public static void createTables() {
        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement stmt1 = conn.prepareStatement(STUDENTS);
             PreparedStatement stmt2 = conn.prepareStatement(ATTENDANCE)) {
            stmt1.executeUpdate();
            stmt2.executeUpdate();
            System.out.println("Tables 'students' and 'attendance' created successfully.");
        } catch (SQLException e) {
            System.err.println("Error creating tables: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        createTables();
    }
}
