package massa.inc;


public class Order {
    private int id_number;
    private Customer customer;
    private Product product;
    private double amount;
    private String status;
    private int week;

    public Order(int id_number, Customer customer, Product product, double amount, int week) {
        this.id_number = id_number;
        this.customer = customer;
        this.product = product;
        this.amount = amount;
        this.status = ""; // é necessário inicializar
        this.week = week;

    }

    public int getOrderWeek() {
        return week;
    }

    public int getId_number() {
        return id_number;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Product getProduct() {
        return product;
    }

    public double getAmount() {
        return amount;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }


    public double item_amount () {
        double total = amount;
        return total;
    }


}

