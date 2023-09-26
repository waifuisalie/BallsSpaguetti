package massa.inc;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.lang.invoke.StringConcatFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.opencsv.CSVWriter;
import java.io.FileWriter;

public class Executavel {
    public static void main(String [] args) {
        int numberOfWeeks = 4;
        
        for (int week = 1; week <= numberOfWeeks; week++) {
            String csvFilePath = "/home/waifuisalie/Documents/FUCKFUCK/app/pedidosyeeey.csv";
            // Load data for the current week
            CsvDataProcessor csvDataProcessor = new CsvDataProcessor(csvFilePath);

            List<Order> orders = csvDataProcessor.getOrders();

            // Process orders for the current week
            CsvWriter.writeOrdersToCsv(orders, week);

            

            // Write delivery orders for the current week
            CsvWriter.writeDeliveriesToCsv(orders, week);

            // You can add any other operations you need for each week here
        }

        
    }
}
