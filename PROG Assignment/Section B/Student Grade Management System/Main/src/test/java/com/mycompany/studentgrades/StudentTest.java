/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.studentgrades;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void testAverage() {
        Student s = new Student("Test", new double[]{90, 80, 70});
        assertEquals(80.0, s.getAverage(), 1e-6);
    }

    @Test
    void testHighest() {
        Student s = new Student("Test", new double[]{90, 80, 70});
        assertEquals(90.0, s.getHighest(), 1e-6);
    }

    @Test
    void testLowest() {
        Student s = new Student("Test", new double[]{90, 80, 70});
        assertEquals(70.0, s.getLowest(), 1e-6);
    }

    @Test
    void testConstructorRejectsEmptyArray() {
        assertThrows(IllegalArgumentException.class, () -> new Student("Empty", new double[]{}));
    }
}

