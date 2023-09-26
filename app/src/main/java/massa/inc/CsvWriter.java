package massa.inc;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvWriter {

    public static void writeOrdersToCsv(List<Order> orders, int week) {
        String productionFileName = "ProductionWeek" + week + ".csv";
        String canceledFileName = "CanceledOrdersWeek" + week + ".csv";

        try (FileWriter productionFileWriter = new FileWriter(productionFileName);
             CSVPrinter productionCsvPrinter = new CSVPrinter(productionFileWriter, CSVFormat.DEFAULT.withHeader(
                     "Order ID", "Customer Name", "CNPJ", "Address", "Product", "Amount (kg)"
             ));
             FileWriter canceledFileWriter = new FileWriter(canceledFileName);
             CSVPrinter canceledCsvPrinter = new CSVPrinter(canceledFileWriter, CSVFormat.DEFAULT.withHeader(
                     "Order ID", "Customer Name", "CNPJ", "Address", "Product", "Amount (kg)"
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
                            order.getType_of_pasta().getPastaType(),
                            order.getAmount()
                    );
                } else {
                    // Write to the production orders CSV file
                    productionCsvPrinter.printRecord(
                            order.getId_number(),
                            order.getCustomer().getName(),
                            order.getCustomer().getCNPJ(),
                            order.getCustomer().getAddress(),
                            order.getType_of_pasta().getPastaType(),
                            order.getAmount()
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
            
            if (existingOrder.getType_of_pasta().getPastaType() == "Espaguete") {
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
    
    
    
    
}
