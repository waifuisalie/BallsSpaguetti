package massa.inc;

import java.util.Calendar;

public class Order {
    // Attributes
    private int id_number;
    private Customer customer;
    private Product product;
    private double amount;
    private String status;
    private Calendar orderDate;


    // Constructor method
    public Order(int id_number, Customer customer, Product product, double amount) {
        this.id_number = id_number;
        this.customer = customer;
        this.product = product;
        this.amount = amount;
        this.status = "";
        this.orderDate = Calendar.getInstance();

    }

    public Product getType_of_pasta() {
        return null;
    }

    

    public int getOrderWeek() {
        // Get the week number using the Calendar class
        return orderDate.get(Calendar.WEEK_OF_YEAR);
    }

    // Getter method for order ID number
    public int getId_number() {
        return id_number;
    }

    // Getter method for customer
    public Customer getCustomer() {
        return customer;
    }

    // Getter method for type of pasta (product)
    public Product getProduct() {
        return product;
    }

    // Getter method for order amount
    public double getAmount() {
        return amount;
    }

    // Setter method for order status
    public void setStatus(String status) {
        this.status = status;
    }

    // Getter method for order status
    public String getStatus() {
        return status;
    }

    public double item_value () {
        double total = amount * product.kilogram_price();
        return total;
    }

    public double item_amount () {
        double total = amount;
        return total;
    }
/* 
    public String order_information() {
        String type; 
        if (type_of_pasta instanceof Spaguetti){
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
        if (type_of_pasta instanceof Spaguetti){
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
    }*/

    public double kilogram_price() {
        return product.kilogram_price();
    }
}

