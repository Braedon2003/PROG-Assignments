package com.mycompany.ice_task4;

public class ICE_Task4 {

    public static void main(String[] args) {
        Series manager = new Series();

        System.out.println("******************************");
        System.out.println(" Enter (1) to launch menu or any other key to exit ");
        String input = manager.scanner.nextLine();

        if (!input.equals("1")) {
            manager.ExitSeriesApplication();
        }

        boolean running = true;
        while (running) {
            System.out.println("\nPlease select one of the following menu items:");
            System.out.println("(1) Capture a new Series");
            System.out.println("(2) Search for a Series");
            System.out.println("(3) Update Series Information");
            System.out.println("(4) Delete a Series");
            System.out.println("(5) Print a Series Report");
            System.out.println("(6) Exit Application");

            System.out.print("Choose an option: ");
            String choice = manager.scanner.nextLine();

            switch (choice) {
                case "1":
                    manager.CaptureSeries();
                    break;
                case "2":
                    manager.SearchSeries();
                    break;
                case "3":
                    manager.UpdateSeries();
                    break;
                case "4":
                    manager.DeleteSeries();
                    break;
                case "5":
                    manager.SeriesReport();
                    break;
                case "6":
                    manager.ExitSeriesApplication();
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}

