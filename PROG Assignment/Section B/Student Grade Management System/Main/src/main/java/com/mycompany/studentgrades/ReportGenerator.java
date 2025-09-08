/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.studentgrades;

/**
 * Responsible for printing a console report of students.
 */
public class ReportGenerator {

    public static void printReport(Student[] students) {
        System.out.println("================= STUDENT REPORT =================");
        System.out.printf("%-15s | %-7s | %-7s | %-7s%n", "Name", "Average", "Highest", "Lowest");
        System.out.println("-------------------------------------------------");

        for (Student s : students) { // loop to iterate array of students
            System.out.printf("%-15s | %7.2f | %7.2f | %7.2f%n",
                    s.getName(),
                    s.getAverage(),
                    s.getHighest(),
                    s.getLowest());
        }

        System.out.println("=================================================");
    }
}




