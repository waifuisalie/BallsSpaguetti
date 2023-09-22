package massa.inc;

import com.opencsv.CSVReader;

import java.io.FileReader;
import java.io.IOException;

import com.opencsv.exceptions.CsvValidationException;


public class CSVReaderEx {
    public static void main(String[] args) {
        String csvFilePath = "/home/waifuisalie/Documents/FUCKFUCK/app/yourfile.csv"; // Replace with the path to your CSV file

        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            String[] nextLine;
            while ((nextLine = reader.readNext()) != null) {
                for (String cell : nextLine) {
                    System.out.print(cell + "\t"); // Print each cell value
                }
                System.out.println(); // Move to the next line for the next row
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvValidationException e) {
            e.printStackTrace();
        }
    }
}
