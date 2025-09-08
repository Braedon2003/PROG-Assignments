/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.studentgrades;

/**
 * Entry point - creates sample students and prints the report.
 */
public class Main {

    public static void main(String[] args) {
        Student[] students = new Student[]{
            new Student("Alice", new double[]{85, 78, 90}),
            new Student("Bob", new double[]{65, 72, 55}),
            new Student("Clara", new double[]{95, 88, 82})
        };

        ReportGenerator.printReport(students);
    }
}
