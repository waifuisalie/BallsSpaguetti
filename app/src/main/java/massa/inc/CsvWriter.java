package massa.inc;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class CsvWriter {

    public static void writeOrdersToCsv(List<Order> orders, int week) {
        // Define o nome dos arquivos CSV de produção e cancelamento com base na semana
        String productionFileName = "ProductionWeek" + week + ".csv";
        String canceledFileName = "CanceledOrdersWeek" + week + ".csv";

        try (FileWriter productionFileWriter = new FileWriter(productionFileName);
             CSVPrinter productionCsvPrinter = new CSVPrinter(productionFileWriter, CSVFormat.DEFAULT.withHeader(
                     "ID do Pedido", "Nome do Cliente", "CNPJ", "Endereço", "Produto", "Quantidade (kg)", "Tipo de Cliente"
             ))) {

            shouldOrderBeCanceled(week, orders, canceledFileName);
            for (Order order : orders) {
                // Verifica se o pedido deve ser cancelado com base na função shouldOrderBeCanceled
            
                if (!"Cancelado".equals(order.getStatus())){
                    // Escreve no arquivo CSV de pedidos de produção
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

            System.out.println("[ + ] " + productionFileName);
            System.out.println("[ + ] " + canceledFileName);

        } catch (IOException e) {
            System.err.println("Erro ao escrever pedidos nos arquivos CSV: " + e.getMessage());
        }
    }

    public static void shouldOrderBeCanceled(int week, List<Order> orders, String canceledFileName) {
        
        // inicializa as quantidades
        double quantidadeCumulativaSpaguetti = 0;
        double quantidadeCumulativaCanelone = 0;
        double quantidadeCumulativaTalharim = 0;
        try (FileWriter canceledFileWriter = new FileWriter(canceledFileName);
        CSVPrinter canceledCsvPrinter = new CSVPrinter(canceledFileWriter, CSVFormat.DEFAULT.withHeader(
            "ID do Pedido", "Nome do Cliente", "CNPJ", "Endereço", "Produto", "Quantidade (kg)", "Tipo de Cliente"
            ))) {
                for (Order pedidoExistente : orders) {
                    if (isSameWeek(pedidoExistente, week)) {
                        if ("Espaguete".equals(pedidoExistente.getProduct().getPastaType())) {
                            quantidadeCumulativaSpaguetti += pedidoExistente.getAmount();
                            // condition to print order that exceeds
                            if ((quantidadeCumulativaSpaguetti) > 2000) {
                                pedidoExistente.setStatus("Cancelado");
                                System.out.println("[ * ]" + "Order: " + pedidoExistente.getCustomer().getName() + " type: " + pedidoExistente.getProduct().getPastaType() + " got cancelled" +"\n");
                                // Escreve no arquivo CSV de pedidos cancelados
                                canceledCsvPrinter.printRecord(
                                        pedidoExistente.getId_number(),
                                        pedidoExistente.getCustomer().getName(),
                                        pedidoExistente.getCustomer().getCNPJ(),
                                        pedidoExistente.getCustomer().getAddress(),
                                        pedidoExistente.getProduct().getPastaType(),
                                        pedidoExistente.getAmount(),
                                        pedidoExistente.getCustomer().getClientType()
                                        );
                                quantidadeCumulativaSpaguetti = quantidadeCumulativaSpaguetti - pedidoExistente.getAmount();
                                    }
                                } else if ("Canelone".equals(pedidoExistente.getProduct().getPastaType())) {
                                    quantidadeCumulativaCanelone += pedidoExistente.getAmount();

         
                            //condition to print order that exceeds
                            if ((quantidadeCumulativaCanelone) > 1600) {
                                pedidoExistente.setStatus("Cancelado");
                                System.out.println("[ * ]" + "Order: " + pedidoExistente.getCustomer().getName() + " type: " + pedidoExistente.getProduct().getPastaType() + " got cancelled" + "\n");
                                // Escreve no arquivo CSV de pedidos cancelados
                                canceledCsvPrinter.printRecord(
                                    pedidoExistente.getId_number(),
                                    pedidoExistente.getCustomer().getName(),
                                    pedidoExistente.getCustomer().getCNPJ(),
                                    pedidoExistente.getCustomer().getAddress(),
                                    pedidoExistente.getProduct().getPastaType(),
                                    pedidoExistente.getAmount(),
                                    pedidoExistente.getCustomer().getClientType()
                                );
                                quantidadeCumulativaCanelone = quantidadeCumulativaCanelone - pedidoExistente.getAmount();
                             }
                            } else if ("Talharim".equals(pedidoExistente.getProduct().getPastaType())) {
                                quantidadeCumulativaTalharim += pedidoExistente.getAmount();

                            //condition to print order that exceeds
                            if ((quantidadeCumulativaTalharim) > 1000) {
                                pedidoExistente.setStatus("Cancelado");
                                System.out.println("[ * ]" + "Order: " + pedidoExistente.getCustomer().getName() + " type: " + pedidoExistente.getProduct().getPastaType() + " got cancelled" + "\n");
                                // Escreve no arquivo CSV de pedidos cancelados
                                canceledCsvPrinter.printRecord(
                                        pedidoExistente.getId_number(),
                                        pedidoExistente.getCustomer().getName(),
                                        pedidoExistente.getCustomer().getCNPJ(),
                                        pedidoExistente.getCustomer().getAddress(),
                                        pedidoExistente.getProduct().getPastaType(),
                                        pedidoExistente.getAmount(),
                                        pedidoExistente.getCustomer().getClientType()
                                );
                                quantidadeCumulativaTalharim = quantidadeCumulativaTalharim - pedidoExistente.getAmount();
                            }
                        }
                    }
                }
            
        } catch (Exception e) {
            System.err.println("Erro ao escrever pedidos nos arquivos CSV: " + e.getMessage());
        }




}
   

public static void writeDeliveriesToCsv(List<Order> orders, int week) {
    // Define o nome do arquivo CSV de entregas com base na semana
    String fileName = "DeliveriesWeek" + week + ".csv";

    try (FileWriter fileWriter = new FileWriter(fileName);
         CSVPrinter csvPrinter = new CSVPrinter(fileWriter, CSVFormat.DEFAULT.withHeader(
                 "Tipo de Cliente", "Nome do Cliente", "CNPJ", "Endereço", "Quantidade Total (kg)", "Preço"
         ))) {
        // Itera sobre a lista de pedidos
        for (Order order : orders) {
            // Verifica se o pedido não está cancelado
            if (!order.getStatus().equals("Cancelado")) {
                // Obtém o tipo de cliente, quantidade total e preço do pedido
                String clientType = order.getCustomer().getClientType();
                double totalAmount = order.getAmount();
                double price = calculatePrice(order);

                // Escreve os detalhes da entrega no arquivo CSV
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
        System.out.println("[ + ] " + fileName);
    } catch (IOException e) {
        System.err.println("Erro ao escrever pedidos não cancelados no arquivo CSV: " + e.getMessage());
    }
}

private static double calculatePrice(Order order) {
    double pricePerKg;

    // Determina o preço por quilo com base no tipo de massa
    if ("Espaguete".equals(order.getProduct().getPastaType())) {
        pricePerKg = 10.0;
    } else if ("Canelone".equals(order.getProduct().getPastaType())) {
        pricePerKg = 20.0;
    } else if ("Talharim".equals(order.getProduct().getPastaType())) {
        pricePerKg = 12.0;
    } else {
        pricePerKg = 0.0;
    }

    double totalAmount = order.getAmount();
    double totalPrice = totalAmount * pricePerKg;

    // Aplica um desconto de 10% para supermercados
    if (order.getCustomer().getClientType().equalsIgnoreCase("Supermercado")) {
        System.out.print("desconto ativado");
        totalPrice *= 0.9; 
    }

    return totalPrice;
}

// Função para verificar se o pedido pertence à mesma semana
public static boolean isSameWeek(Order order, int week) {
    return order.getOrderWeek() == week;
}
}