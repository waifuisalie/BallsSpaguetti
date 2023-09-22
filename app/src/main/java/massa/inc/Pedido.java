package massa.inc;

public class Pedido {
    private Cliente customer;
    private Produto type_of_pasta;
    private int id_number;
    private double amount;

    public Pedido(int id_number, Cliente customer, Produto type_of_pasta, double amount) {
        this.id_number = id_number;
        this.customer = customer;
        this.type_of_pasta = type_of_pasta;
        this.amount = amount;
    }

    public double item_value () {
        double total = amount * type_of_pasta.kilogram_price();
        return total;
    }

    public double item_amount () {
        double total = amount;
        return total;
    }

    public String order_information() {
        String type; 
        if (type_of_pasta instanceof Espaguete){
            type = "Spaguetti";
        } else {
            if (type_of_pasta instanceof Canelone){
                type = "Canelone";
            } else {
                type = "Talharim";
            }
        }
        String order_details = customer.displayInformation() + "Order ID: " + id_number + "\n" + "Pasta type: " + type + "\n" +
        "Amount: " + amount + "kg" + "\n";
        customer.displayInformation();
        //System.out.println(order_details);
        return order_details;
    }

    public String order_informationDelivery(){
        String type; 
        if (type_of_pasta instanceof Espaguete){
            type = "Spaguetti";
        } else {
            if (type_of_pasta instanceof Canelone){
                type = "Canelone";
            } else {
                type = "Talharim";
            }
        }
        String order_details = "Order ID: " + id_number + "\n" + "Pasta type: " + type + "\n" +
        "Amount: " + amount + "kg" + "\n";
        return order_details;
    }

    public double kilogram_price() {
        return type_of_pasta.kilogram_price();
    }
}

