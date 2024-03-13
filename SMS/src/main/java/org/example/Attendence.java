package org.example;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Attendence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input attendance details
        System.out.println("Enter attendance details:");
        System.out.print("Student ID: ");
        int studentId = scanner.nextInt();
        System.out.print("Class ID: ");
        int classId = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Date (yyyy-MM-dd): ");
        String dateString = scanner.nextLine();
        Date date = null;
        try {
            date = new SimpleDateFormat("yyyy-MM-dd").parse(dateString);
        } catch (ParseException e) {
            System.err.println("Invalid date format. Please use yyyy-MM-dd format.");
            System.exit(1);
        }
        System.out.print("Present (true/false): ");
        boolean present = scanner.nextBoolean();

        // Insert attendance into the database
        AttendanceManager.insertAttendance(studentId, classId, date, present);

        scanner.close();
    }
}
