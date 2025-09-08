
package com.mycompany.studentgrades;

/**
 * Student extends Person and stores marks in an array.
 * Contains methods that use loops to compute average, highest, lowest.
 */
public class Student extends Person {

    private double[] marks; // information-hiding

    public Student(String name, double[] marks) {
        super(name);
        if (marks == null || marks.length == 0) {
            throw new IllegalArgumentException("marks must not be null or empty");
        }
        this.marks = marks.clone(); // defensive copy
    }

    // Returns defensive copy to keep original array private
    public double[] getMarks() {
        return marks.clone();
    }

    public void setMarks(double[] marks) {
        if (marks == null || marks.length == 0) {
            throw new IllegalArgumentException("marks must not be null or empty");
        }
        this.marks = marks.clone();
    }

    public double getAverage() {
        double sum = 0;
        for (double m : marks) { // loop
            sum += m;
        }
        return sum / marks.length;
    }

    public double getHighest() {
        double max = marks[0];
        for (int i = 1; i < marks.length; i++) { // loop
            if (marks[i] > max) {
                max = marks[i];
            }
        }
        return max;
    }

    public double getLowest() {
        double min = marks[0];
        for (int i = 1; i < marks.length; i++) { // loop
            if (marks[i] < min) {
                min = marks[i];
            }
        }
        return min;
    }
}

