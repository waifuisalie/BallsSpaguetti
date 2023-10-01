package massa.inc;

//Stefan Benjamim Seixas Lourenço Rodrigues

import java.util.List;

public class Main {
    public static void main(String[] args) {
        int numberOfWeeks = 4;

        for (int week = 1; week <= numberOfWeeks; week++) {
            // Dados para a semana atual
            String csvFilePath = "/home/waifuisalie/Documents/FUCKFUCK/app/week" + week + ".csv";
            CsvDataProcessor csvDataProcessor = new CsvDataProcessor(csvFilePath, week);

            List<Order> orders = csvDataProcessor.getOrders();

            // Escreve os pedidos
            CsvWriter.writeOrdersToCsv(orders, week);

            // Escreve as entregas
            CsvWriter.writeDeliveriesToCsv(orders, week);

        }
    }  
}
