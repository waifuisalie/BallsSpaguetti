package massa.inc;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvDataProcessor {
    private List<Customer> customers;
    private List<Product> products;
    private List<Order> orders;

    public CsvDataProcessor(String csvFilePath) {
        customers = new ArrayList<>();
        products = new ArrayList<>();
        orders = new ArrayList<>();
        
        processCsvFile(csvFilePath);
    }

    private void processCsvFile(String csvFilePath) {
        try (FileReader fileReader = new FileReader(csvFilePath);
             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(fileReader)) {
                int orderId = 1; // Initialize the order ID counter

            for (CSVRecord record : csvParser) {
                String clientName = record.get("Nome do Cliente");
                String cnpj = record.get("CNPJ");
                String address = record.get("Endereço");
                String clientType = record.get("Tipo de Cliente");
                String pastaType = record.get("Tipo da Massa");
                double quantity = Double.parseDouble(record.get("QTD MASSA"));

                // Dynamically create customer and product instances based on CSV data
                Customer customer = createCustomer(clientType, clientName, cnpj, address);
                Product product = createProduct(pastaType);

                // Create an order based on the CSV data
                Order order = new Order(orderId, customer, product, quantity);
                orders.add(order);
                orderId++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to create a customer based on client type
    private Customer createCustomer(String clientType, String name, String cnpj, String address) {
        if ("Supermercado".equals(clientType)) {
            return new Supermarket(name, cnpj, address);
        } else if ("Restaurante".equals(clientType)) {
            return new Restaurant(name, cnpj, address);
        }
        // Handle other client types if needed
        return null;
    }

    // Method to create a product based on pasta type
    private Product createProduct(String pastaType) {
        // Fetch actual price and production data based on pasta type
        double kilogramPrice = 0; // Fetch actual price
        double maxProduction = 0; // Fetch actual max production
        
        return new Product(pastaType, kilogramPrice, maxProduction);
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<Product> getProducts() {
        return products;
    }

    public List<Order> getOrders() {
        return orders;
    }
}

