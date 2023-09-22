package massa.inc;

public class Produto {
    private double quantity;
    private double kilogram_price;

    public Produto (double quantity, double kilogram_price) {
        this.quantity = quantity;
        this.kilogram_price = kilogram_price;
    }
    
    protected double quantity (){
        return quantity;
    }

    protected double kilogram_price() {
        return kilogram_price;
    }

}
