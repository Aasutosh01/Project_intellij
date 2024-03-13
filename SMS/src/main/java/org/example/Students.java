package org.example;

import model.Student;
import java.sql.SQLException;
import java.util.Scanner;

public class Students {
    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);


        System.out.println("Enter student details:");
        System.out.print("Student ID: ");
        int studentId = sn.nextInt();
        sn.nextLine(); // Consume newline
        System.out.print("Name: ");
        String name = sn.nextLine();
        System.out.print("Contact Details: ");
        String contactDetails = sn.nextLine();
        System.out.print("Parent Info: ");
        String parentInfo = sn.nextLine();


        Student s = new Student(studentId, name, contactDetails, parentInfo);


        try {
            DatabaseManager.createStudent(s);
            System.out.println("Student data inserted successfully.");
        } catch (SQLException e) {
            System.out.println("Error inserting student data: " + e.getMessage());
        }

        sn.close();
    }
}
