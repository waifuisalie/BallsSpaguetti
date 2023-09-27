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

    public CsvDataProcessor(String csvFilePath, int week) {
        customers = new ArrayList<>();
        products = new ArrayList<>();
        orders = new ArrayList<>();
        
        processCsvFile(csvFilePath, week);
    }

    private void processCsvFile(String csvFilePath, int week) {
        try (FileReader fileReader = new FileReader(csvFilePath);
             CSVParser csvParser = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(fileReader)) {
                int orderId = 1; // Inicializa id do pedido

            for (CSVRecord record : csvParser) {
                String clientName = record.get("Nome do Cliente");
                String cnpj = record.get("CNPJ");
                String address = record.get("Endereço");
                String clientType = record.get("Tipo de Cliente");
                String pastaType = record.get("Tipo da Massa");
                double quantity = Double.parseDouble(record.get("QTD MASSA"));

                // Dinamicamente cria as instâncias de cliente e produto
                Customer customer = createCustomer(clientType, clientName, cnpj, address);
                Product product = createProduct(pastaType);

                // Cria a ordem de pedido
                Order order = new Order(orderId, customer, product, quantity, week);
                orders.add(order);
                orderId++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Método que cria cliente baseado se é supermercado ou restaurante
    private Customer createCustomer(String clientType, String name, String cnpj, String address) {
        if ("Supermercado".equals(clientType)) {
            return new Supermarket(name, cnpj, address, clientType);
        } else if ("Restaurante".equals(clientType)) {
            return new Restaurant(name, cnpj, address, clientType);
        } else {
            return null;
        }
    }

    // Método que cria produto baseado que tipo de produto que é
    private Product createProduct(String pastaType) {
        return new Product(pastaType);
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

