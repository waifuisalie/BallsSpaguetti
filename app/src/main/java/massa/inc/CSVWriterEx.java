package massa.inc;

import com.opencsv.CSVWriter;

import java.io.FileWriter;
import java.io.IOException;

public class CSVWriterEx {
    public static void main(String[] args) {
        String csvFilePath = "/home/waifuisalie/Documents/FUCKFUCK/app/monarks.csv"; // Specify the path for the output CSV file

        try (CSVWriter writer = new CSVWriter(new FileWriter(csvFilePath))) {
            // Create an array to represent a row of data
            String[] row1 = {"Nome do Cliente", "CNPJ", "Endereço", "Tipo de Cliente", "Tipo de Massa", "QTD de Massa"};
            
            
            // Write the rows to the CSV file
            writer.writeNext(row1);


            // You can write more rows as needed

            System.out.println("Data has been written to " + csvFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
