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
        double maxCaneloneLimit = 1600;
        double currentCaneloneSum = 0;
        double maxEspagueteLimit = 2000;
        double currentEspagueteSum = 0;
        double maxTalharimLimit = 1000;
        double currentTalharimSum = 0;

        String csvFilePath = "/home/waifuisalie/Documents/FUCKFUCK/app/pedidosyeeey.csv";


        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            String[] header = reader.readNext(); // Read the header row (optional)

            String[] nextLine;
            List<Supermercado> supermercadoList = new ArrayList<>();
            List<Restaurante> restauranteList = new ArrayList<>();
            List<Espaguete> espagueteList = new ArrayList<>();
            List<Talharim> talharimList = new ArrayList<>();
            List<Canelone> caneloneList = new ArrayList<>();

            while ((nextLine = reader.readNext()) != null) {
                String nomeCliente = nextLine[0];
                String CNPJCliente = nextLine[1];
                String EnderecoCliente = nextLine[2];
                String tipoCliente = nextLine[3];
                String tipoMassa = nextLine[4];
                double QTDMassa = Double.parseDouble(nextLine[5]);

                // Check the value of "Tipo de Cliente" to determine which constructor to use
                if ("Supermercado".equalsIgnoreCase(tipoCliente)) {
                    // Create a Supermercado instance and add it to the Supermercado list
                    supermercadoList.add(new Supermercado(nomeCliente, CNPJCliente, EnderecoCliente));
                } else if ("Restaurante".equalsIgnoreCase(tipoCliente)) {
                    // Create a Restaurante instance and add it to the Restaurante list
                    restauranteList.add(new Restaurante(nomeCliente, CNPJCliente, EnderecoCliente));
                }

              
                // Check the value of "Tipo da Massa" to determine which constructor to use
                if ("Espaguete".equalsIgnoreCase(tipoMassa)) {
                    // Check if adding the new Canelone exceeds the limit
                    if (currentEspagueteSum + QTDMassa <= maxEspagueteLimit) {
                        // Add the Espaguete to the list
                        Espaguete espaguete = new Espaguete(QTDMassa, 20);
                        espagueteList.add(espaguete);
                        
                        // Update the current sum of Canelone quantities
                        currentEspagueteSum += QTDMassa;

                    } else if (currentEspagueteSum + QTDMassa >= maxEspagueteLimit) {
                        String csvFilePathError = "/home/waifuisalie/Documents/FUCKFUCK/app/monarks.csv"; // Specify the path for the output CSV file

                        try (CSVWriter errorWriter = new CSVWriter(new FileWriter(csvFilePathError, true))) {
                            // Create an array to represent a row of data
                            String QTDMassaStr = Double.toString(QTDMassa);
                            String[] errorRow = {nomeCliente, CNPJCliente, EnderecoCliente, tipoCliente, tipoMassa, QTDMassaStr};
                            
                            
                            // Write the rows to the CSV file
                            errorWriter.writeNext(errorRow);

                
                            // You can write more rows as needed
                
                            System.out.println("Data has been written to " + csvFilePathError);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    
                } else if ("Canelone".equalsIgnoreCase(tipoMassa)) {
                    
                    // Check if adding the new Canelone exceeds the limit
                    if (currentCaneloneSum + QTDMassa <= maxCaneloneLimit) {
                        // Add the Canelone to the list
                        Canelone canelone = new Canelone(QTDMassa, 50);
                        caneloneList.add(canelone);
                        
                        // Update the current sum of Canelone quantities
                        currentCaneloneSum += QTDMassa;
                    } else if (currentCaneloneSum + QTDMassa > maxCaneloneLimit) {

                        String csvFilePathError = "/home/waifuisalie/Documents/FUCKFUCK/app/monarks.csv"; // Specify the path for the output CSV file

                        try (CSVWriter errorWriter = new CSVWriter(new FileWriter(csvFilePathError, true))) {
                            // Create an array to represent a row of data
                            String QTDMassaStr = Double.toString(QTDMassa);
                            String[] errorRow = {nomeCliente, CNPJCliente, EnderecoCliente, tipoCliente, tipoMassa, QTDMassaStr};
                            
                            
                            // Write the rows to the CSV file
                            errorWriter.writeNext(errorRow);

                
                            // You can write more rows as needed
                
                            System.out.println("Data has been written to " + csvFilePathError);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    }

                } else if ("Talharim".equalsIgnoreCase(tipoMassa)) {

                    // Check if adding the new Canelone exceeds the limit
                    if (currentTalharimSum + QTDMassa <= maxTalharimLimit) {
                        // Add the Talharim to the list
                        Talharim talharim = new Talharim(QTDMassa, 22);
                        talharimList.add(talharim);
                        
                        // Update the current sum of Canelone quantities
                        currentTalharimSum += QTDMassa;
                    } else if (currentTalharimSum + QTDMassa > maxTalharimLimit) {
                        String csvFilePathError = "/home/waifuisalie/Documents/FUCKFUCK/app/monarks.csv"; // Specify the path for the output CSV file

                        try (CSVWriter errorWriter = new CSVWriter(new FileWriter(csvFilePathError, true))) {
                            // Create an array to represent a row of data
                            String QTDMassaStr = Double.toString(QTDMassa);
                            String[] errorRow = {nomeCliente, CNPJCliente, EnderecoCliente, tipoCliente, tipoMassa, QTDMassaStr};
                            
                            
                            // Write the rows to the CSV file
                            errorWriter.writeNext(errorRow);

                
                            // You can write more rows as needed
                
                            System.out.println("Data has been written to " + csvFilePathError);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                
                }
            }
        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();
        }


      

        // clientes
        Supermercado super1 = new Supermercado("lol", "0000.0000","Boa Vista");
        Supermercado super2 = new Supermercado("Big", "3333.4444","Bacacheri");
        Supermercado super3 = new Supermercado("Carrefour", "5555.7777","Juvevê");
        
        Restaurante rest1 = new Restaurante("Dona Ambrosina", "9999.0000", "Bigorrilho");
        Restaurante rest2 = new Restaurante("Cão Veio", "8888.0000", "Batel");

        // tipos de massa = produtos
        Espaguete spaguetti = new Espaguete(9, 2000);
        Canelone canelone = new Canelone(12, 1600);
        Talharim talharim = new Talharim(14, 1000);


        //System.out.println(spaguetti.max_production());

        //rest1.customer_information();
        //System.out.println(rest1.customer_information());

        // pedidos
        //First Week
        Pedido firstWeek_o1 = new Pedido(1, super1, spaguetti, 200);
        Pedido firstWeek_o2 = new Pedido(2, super1, canelone, 240);
        Pedido firstWeek_o3 = new Pedido(3, super2, talharim, 300);
        Pedido firstWeek_o4 = new Pedido(4, super2, spaguetti, 348);
        Pedido firstWeek_o5 = new Pedido(5, super3, spaguetti, 568);
        Pedido firstWeek_o6 = new Pedido(6, super3, talharim, 120);
        Pedido firstWeek_o7 = new Pedido(7, rest1, talharim, 140);
        Pedido firstWeek_o8 = new Pedido(8, rest1, canelone, 640);
        Pedido firstWeek_o9 = new Pedido(9, rest2, spaguetti, 234);
        Pedido firstWeek_o10 = new Pedido(10, rest2, talharim, 320);

        //System.out.println(firstWeek_o1.order_information());
        firstWeek_o2.order_information();
        firstWeek_o3.order_information();
        firstWeek_o4.order_information();
        firstWeek_o5.order_information();
        firstWeek_o6.order_information();
        firstWeek_o7.order_information();
        firstWeek_o8.order_information();
        firstWeek_o9.order_information();
        firstWeek_o10.order_information();

        
        
    }
}
