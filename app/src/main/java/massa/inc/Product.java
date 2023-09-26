package massa.inc;

public class Product {
    private String pastaType;
    private double quantity;
    private double kilogram_price;

    public Product (String pastaType, double quantity, double kilogram_price) {
        this.pastaType = pastaType;
        this.quantity = quantity;
        this.kilogram_price = kilogram_price;
    }

    // Getter method for product name
    public String getPastaType() {
       
        return pastaType;
    }
    
    protected double quantity (){
        return quantity;
    }

    protected double kilogram_price() {
        return kilogram_price;
    }

}
