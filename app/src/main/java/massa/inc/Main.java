package massa.inc;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        int numberOfWeeks = 4;

        for (int week = 1; week <= numberOfWeeks; week++) {
            // Load data for the current week
            String csvFilePath = "/home/waifuisalie/Documents/FUCKFUCK/app/week" + week + ".csv";
            CsvDataProcessor csvDataProcessor = new CsvDataProcessor(csvFilePath);

            List<Order> orders = csvDataProcessor.getOrders();

            // Process orders for the current week
            CsvWriter.writeOrdersToCsv(orders, week);

            // Create and write the cancelled orders for the current week

            // Write delivery orders for the current week
            CsvWriter.writeDeliveriesToCsv(orders, week);

            // You can add any other operations you need for each week here
        }
    }
    
}
