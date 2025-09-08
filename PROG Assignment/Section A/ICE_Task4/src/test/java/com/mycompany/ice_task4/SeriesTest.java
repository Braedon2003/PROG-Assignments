package com.mycompany.ice_task4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class SeriesTest {

    @BeforeEach
    void clearSeriesList() {
        Series.seriesList.clear(); // clear before each test
    }

    @Test
    void TestSearchSerries() {
        Series.seriesList.add(new SeriesModel("S001", "Test Series", "10", "12"));

        String simulatedInput = "S001\n";
        InputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        Series.scanner = new Scanner(in);

        Series.SearchSeries();

        SeriesModel s = Series.seriesList.get(0);
        assertEquals("S001", s.seriesInfo[0]);
        assertEquals("Test Series", s.seriesInfo[1]);
    }

    @Test
    void TestSearchSeries_SeriesNotFound() {
        String simulatedInput = "S999\n";
        InputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        Series.scanner = new Scanner(in);

        Series.SearchSeries();

        assertTrue(Series.seriesList.isEmpty());
    }

    @Test
    void TestUpdateSeries() {
        Series.seriesList.add(new SeriesModel("S001", "Old Name", "10", "12"));

        String simulatedInput = "S001\nNew Name\n12\n15\n";
        InputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        Series.scanner = new Scanner(in);

        Series.UpdateSeries();

        SeriesModel s = Series.seriesList.get(0);
        assertEquals("New Name", s.seriesInfo[1]);
        assertEquals("12", s.seriesInfo[2]);
        assertEquals("15", s.seriesInfo[3]);
    }

    @Test
    void TestDeleteSeries() {
        Series.seriesList.add(new SeriesModel("S001", "Test Series", "10", "12"));

        String simulatedInput = "S001\nY\n";
        InputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        Series.scanner = new Scanner(in);

        Series.DeleteSeries();

        assertTrue(Series.seriesList.isEmpty());
    }

    @Test
    void TestDeleteSeries_SeriesNotFound() {
        Series.seriesList.add(new SeriesModel("S001", "Test Series", "10", "12"));

        String simulatedInput = "S999\n";
        InputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        Series.scanner = new Scanner(in);

        Series.DeleteSeries();

        assertEquals(1, Series.seriesList.size());
    }

    @Test
    void TestSeriesAgeRestriction_AgeValid() {
        String simulatedInput = "S001\nSeries Name\n10\n12\n";
        InputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        Series.scanner = new Scanner(in);

        Series.CaptureSeries();

        SeriesModel s = Series.seriesList.get(0);
        assertEquals("10", s.seriesInfo[2]);
    }

    @Test
    void TestSeriesAgeRestriction_SeriesAgeInValid() {
        // Corrected input: final valid age is 12
        String simulatedInput = "S001\nSeries Name\nabc\n20\n12\n12\n"; 
        InputStream in = new ByteArrayInputStream(simulatedInput.getBytes());
        Series.scanner = new Scanner(in);

        Series.CaptureSeries();

        SeriesModel s = Series.seriesList.get(0);
        assertEquals("12", s.seriesInfo[2]); // final valid age
    }
}



