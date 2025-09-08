/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.ice_task4;

import java.util.ArrayList;
import java.util.Scanner;

public class Series {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<SeriesModel> seriesList = new ArrayList<>();

    public static void CaptureSeries() {
        System.out.print("Enter Series ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter Series Name: ");
        String name = scanner.nextLine();

        int ageRestriction = 0;
        boolean validAge = false;
        while (!validAge) {
            System.out.print("Enter Series Age Restriction (2-18): ");
            String ageInput = scanner.nextLine();
            try {
                ageRestriction = Integer.parseInt(ageInput);
                if (ageRestriction >= 2 && ageRestriction <= 18) {
                    validAge = true;
                } else {
                    System.out.println("Incorrect age! Enter a number between 2 and 18.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input! Enter a numeric value.");
            }
        }

        System.out.print("Enter Number of Episodes: ");
        String episodes = scanner.nextLine();

        SeriesModel series = new SeriesModel(id, name, String.valueOf(ageRestriction), episodes);
        seriesList.add(series);

        System.out.println("\nSeries information has been saved successfully!");
    }

    public static void SearchSeries() {
        if (seriesList.isEmpty()) {
            System.out.println("No series have been added yet.");
            return;
        }

        System.out.print("Enter the Series ID to search for: ");
        String searchId = scanner.nextLine();
        boolean found = false;

        for (SeriesModel s : seriesList) {
            if (s.seriesInfo[0].equalsIgnoreCase(searchId)) {
                System.out.println("\nSeries found!");
                System.out.println("Series ID: " + s.seriesInfo[0]);
                System.out.println("Series Name: " + s.seriesInfo[1]);
                System.out.println("Age Restriction: " + s.seriesInfo[2]);
                System.out.println("Number of Episodes: " + s.seriesInfo[3]);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No data can be found.\n");
        }
    }

    public static void UpdateSeries() {
        if (seriesList.isEmpty()) {
            System.out.println("No series have been added yet.");
            return;
        }

        System.out.print("Enter the Series ID to update: ");
        String updateId = scanner.nextLine();
        boolean updated = false;

        for (SeriesModel s : seriesList) {
            if (s.seriesInfo[0].equalsIgnoreCase(updateId)) {
                System.out.print("Enter new Series Name (current: " + s.seriesInfo[1] + "): ");
                String newName = scanner.nextLine();
                s.seriesInfo[1] = newName;

                int newAge = 0;
                boolean validNewAge = false;
                while (!validNewAge) {
                    System.out.print("Enter new Age Restriction (2-18) (current: " + s.seriesInfo[2] + "): ");
                    String ageInput = scanner.nextLine();
                    try {
                        newAge = Integer.parseInt(ageInput);
                        if (newAge >= 2 && newAge <= 18) {
                            validNewAge = true;
                            s.seriesInfo[2] = String.valueOf(newAge);
                        } else {
                            System.out.println("Incorrect age! Enter a number between 2 and 18.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input! Enter a numeric value.");
                    }
                }

                System.out.print("Enter new Number of Episodes (current: " + s.seriesInfo[3] + "): ");
                String newEpisodes = scanner.nextLine();
                s.seriesInfo[3] = newEpisodes;

                System.out.println("\nSeries information updated successfully!\n");
                updated = true;
                break;
            }
        }

        if (!updated) {
            System.out.println("No data can be found.\n");
        }
    }

    public static void DeleteSeries() {
        if (seriesList.isEmpty()) {
            System.out.println("No series have been added yet.");
            return;
        }

        System.out.print("Enter the Series ID to delete: ");
        String deleteId = scanner.nextLine();
        boolean deleted = false;

        for (int i = 0; i < seriesList.size(); i++) {
            SeriesModel s = seriesList.get(i);
            if (s.seriesInfo[0].equalsIgnoreCase(deleteId)) {
                System.out.println("\nSeries found:");
                System.out.println("Series ID: " + s.seriesInfo[0]);
                System.out.println("Series Name: " + s.seriesInfo[1]);
                System.out.println("Age Restriction: " + s.seriesInfo[2]);
                System.out.println("Number of Episodes: " + s.seriesInfo[3]);

                System.out.print("Are you sure you want to delete this series? (Y/N): ");
                String confirm = scanner.nextLine();
                if (confirm.equalsIgnoreCase("Y")) {
                    seriesList.remove(i);
                    System.out.println("Series deleted successfully!\n");
                } else {
                    System.out.println("Deletion canceled.\n");
                }

                deleted = true;
                break;
            }
        }

        if (!deleted) {
            System.out.println("No data can be found.\n");
        }
    }

    public static void SeriesReport() {
        if (seriesList.isEmpty()) {
            System.out.println("No series have been added yet.\n");
            return;
        }

        System.out.println("\n===== Series Report =====");
        for (SeriesModel s : seriesList) {
            System.out.println("Series ID: " + s.seriesInfo[0]);
            System.out.println("Series Name: " + s.seriesInfo[1]);
            System.out.println("Age Restriction: " + s.seriesInfo[2]);
            System.out.println("Number of Episodes: " + s.seriesInfo[3]);
            System.out.println("---------------------------");
        }
        System.out.println("===========================\n");
    }

    public static void ExitSeriesApplication() {
        System.out.println("Exiting program...");
        scanner.close();
        System.exit(0);
    }
}