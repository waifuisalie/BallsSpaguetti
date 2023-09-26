package massa.inc;

import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvWriter {

    public static void writeOrdersToCsv(List<Order> orders, int week) {
        String productionFileName = "ProductionWeek" + week + ".csv";
        String canceledFileName = "CanceledOrdersWeek" + week + ".csv";

        try (FileWriter productionFileWriter = new FileWriter(productionFileName);
             CSVPrinter productionCsvPrinter = new CSVPrinter(productionFileWriter, CSVFormat.DEFAULT.withHeader(
                     "Order ID", "Customer Name", "CNPJ", "Address", "Product", "Amount (kg)", "Client Type"
             ));
             FileWriter canceledFileWriter = new FileWriter(canceledFileName);
             CSVPrinter canceledCsvPrinter = new CSVPrinter(canceledFileWriter, CSVFormat.DEFAULT.withHeader(
                     "Order ID", "Customer Name", "CNPJ", "Address", "Product", "Amount (kg)", "Client Type"
             ))) {

            for (Order order : orders) {
                if (shouldOrderBeCanceled(order, week, orders)) {
                    order.setStatus("Canceled");
                    // Write to the canceled orders CSV file
                    canceledCsvPrinter.printRecord(
                            order.getId_number(),
                            order.getCustomer().getName(),
                            order.getCustomer().getCNPJ(),
                            order.getCustomer().getAddress(),
                            order.getProduct().getPastaType(),
                            order.getAmount(),
                            order.getCustomer().getClientType()
                    );
                } else {
                    // Write to the production orders CSV file
                    productionCsvPrinter.printRecord(
                            order.getId_number(),
                            order.getCustomer().getName(),
                            order.getCustomer().getCNPJ(),
                            order.getCustomer().getAddress(),
                            order.getProduct().getPastaType(),
                            order.getAmount(),
                            order.getCustomer().getClientType()
                    );
                }
            }

            System.out.println("CSV file " + productionFileName + " has been created successfully.");
            System.out.println("CSV file " + canceledFileName + " for canceled orders has been created successfully.");

        } catch (IOException e) {
            System.err.println("Error writing orders to CSV files: " + e.getMessage());
        }
    }

    public static boolean shouldOrderBeCanceled(Order order, int week, List<Order> orders) {
        // Check if the order should be canceled based on the cumulative amounts and week
        double cumulativeSpaguettiAmount = 0;
        double cumulativeCaneloneAmount = 0;
        double cumulativeTalharimAmount = 0;
        for (Order existingOrder : orders) {
            
            if (existingOrder.getProduct().getPastaType() == "Espaguete") {
                    System.out.println("LETS FUCKING GOO");
                    cumulativeSpaguettiAmount += existingOrder.getAmount();
                } 
        }
    
        // Check if the current order would exceed the cumulative limits
        if ((cumulativeSpaguettiAmount + order.getAmount())> 2000) {
            return true;
        } else if ((cumulativeCaneloneAmount + order.getAmount()) > 1600) {
            return true;
        } else if ((cumulativeTalharimAmount + order.getAmount()) > 1000) {
            return true;
        }
    
        return false;
    }

    public static void writeDeliveriesToCsv(List<Order> orders, int week) {
        String fileName = "DeliveryWeek" + week + ".csv";

        try (FileWriter fileWriter = new FileWriter(fileName);
             CSVPrinter csvPrinter = new CSVPrinter(fileWriter, CSVFormat.DEFAULT.withHeader(
                     "Client Type", "Client Name", "CNPJ", "Address", "Total Amount (kg)", "Price"
             ))) {

            for (Order order : orders) {
                if (!order.getStatus().equals("Canceled")) {
                    String clientType = order.getCustomer().getClientType();
                    double totalAmount = order.getAmount();
                    double price = calculatePrice(order); // You need to implement this method

                    csvPrinter.printRecord(
                            clientType,
                            order.getCustomer().getName(),
                            order.getCustomer().getCNPJ(),
                            order.getCustomer().getAddress(),
                            totalAmount,
                            price
                    );
                }
            }

            System.out.println("CSV file " + fileName + " for non-canceled orders has been created successfully.");

        } catch (IOException e) {
            System.err.println("Error writing non-canceled orders to CSV file: " + e.getMessage());
        }
    }

    // Implement a method to calculate the price based on the order details
    private static double calculatePrice(Order order) {
        double pricePerKg;
    
        // Determine the price per kg based on the type of pasta
        if ("Espaguete".equals(order.getProduct().getPastaType())) {
            pricePerKg = 10.0;
        } else if ("Canelone".equals(order.getProduct().getPastaType())) {
            pricePerKg = 20.0;
        } else if ("Talharim".equals(order.getProduct().getPastaType())) {
            pricePerKg = 12.0;
        } else {
            // Default price if the pasta type is not recognized
            pricePerKg = 0.0;
        }
    
        // Calculate the total price
        double totalAmount = order.getAmount();
        double totalPrice = totalAmount * pricePerKg;
    
        // Apply a 10% discount for supermarkets
        if (order.getCustomer().getClientType().equalsIgnoreCase("Supermarket")) {
            totalPrice *= 0.9; // 10% discount
        }
        System.out.println(totalPrice);
    
        return totalPrice;
    }
    
    
}