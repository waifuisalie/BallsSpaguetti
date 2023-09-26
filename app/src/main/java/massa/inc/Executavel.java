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
        String csvFilePath = "/home/waifuisalie/Documents/FUCKFUCK/app/pedidosyeeey.csv";


       CsvDataProcessor csvDataProcessor = new CsvDataProcessor(csvFilePath);

       List<Customer> customers = csvDataProcessor.getCustomers();
       List<Product> products = csvDataProcessor.getProducts();
       List<Order> orders = csvDataProcessor.getOrders();
       for (Order order : orders) {
           /* 
        System.out.println("Order ID: " + order.getId_number());
        System.out.println("Customer: " + order.getCustomer().getName());
        System.out.println("CNPJ: " + order.getCustomer().getCNPJ());
        System.out.println("Endereço: " + order.getCustomer().getAddress());
        System.out.println("Product: " + order.getType_of_pasta().getPastaType());
        System.out.println("Amount: " + order.getAmount() + "kg");
        System.out.println("\n");*/
        }

        
        // Assuming you have a list of production orders named "orders" and the current week number as "week"
    
    int week = 1; // Replace with the actual week number
    CsvWriter.writeOrdersToCsv(orders, week);

        
    }
}
