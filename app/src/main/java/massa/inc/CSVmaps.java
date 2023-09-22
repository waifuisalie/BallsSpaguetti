package massa.inc;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CSVmaps {
    public static void main(String[] args) {
        String csvFilePath = "/home/waifuisalie/Documents/FUCKFUCK/app/wowee.csv"; // Replace with the path to your CSV file
        String targetProduct = "Product B"; // Replace with the product name you want to check

        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            String[] header = reader.readNext(); // Read the header row (optional)

            Map<String, Integer> productQuantityMap = new HashMap<>();

            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                String productName = nextLine[0].trim(); // Assuming product name is in the first column
                int quantityLimit = Integer.parseInt(nextLine[1].trim()); // Assuming quantity limit is in the second column

                productQuantityMap.put(productName, quantityLimit);
            }
            // Loop through all products and their quantity limits
            for (Map.Entry<String, Integer> entry : productQuantityMap.entrySet()) {
                String productName = entry.getKey();
                int quantityLimit = entry.getValue();
                System.out.println("Product: " + productName);
                System.out.println("Quantity Limit: " + quantityLimit);
                System.out.println();
            }

            // Check the quantity limit for the target product
            if (productQuantityMap.containsKey(targetProduct)) {
                int quantityLimitForTargetProduct = productQuantityMap.get(targetProduct);
                System.out.println("Quantity Limit for " + targetProduct + ": " + quantityLimitForTargetProduct);
            } else {
                System.out.println("Product not found: " + targetProduct);
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }
        
    }
}

