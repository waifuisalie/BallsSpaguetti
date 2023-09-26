package massa.inc;

import java.util.ArrayList;
import java.util.List;

public class Entrega {
    
    private double delivery_full_price;
    private double delivery_full_mass;
    private Customer customer;
    private ArrayList<Order> deliverys;

    public Entrega (Customer customer, List<Order> orders) { 
        this.customer = customer;
        this.deliverys = new ArrayList<Order>();
        this.delivery_full_price = total_value(orders);
        this.delivery_full_mass = total_mass(orders);
    }

    public void include_order(Order o) {
        deliverys.add(o);
    }

    public double total_value(List<Order> orders) {
        delivery_full_price = 0;
        for (Order order : orders) {
            delivery_full_price += order.item_value();
        }
        if (customer instanceof Supermarket) {
            delivery_full_price *= 0.9;
        }
        return delivery_full_price;  
    }

    public double total_mass(List<Order> orders){
        delivery_full_mass = 0;
        for (Order order : orders) {
            delivery_full_mass += order.item_amount();
        }
        return delivery_full_mass;
    }
    /* 
    public String delivery_information() {
        String type; 
        if (customer instanceof Supermarket){
            type = "Supermarket";
        } else {
            type = "Restaurant";
        }
        
        StringBuilder delivery_details = new StringBuilder();
        delivery_details.append("\nClient Type: ").append(type).append(customer.displayInformation());
        
        for (Order o : deliverys) {
            delivery_details.append(o.order_informationDelivery()).append("\n");
        }
        String delivery_full_massFormatted = String.format("%.2f", delivery_full_mass);
        String delivery_full_priceFormatted = String.format("%.2f", delivery_full_price);
        //delivery_details.append("\n");
        delivery_details.append("Total mass: ").append(delivery_full_massFormatted).append("kg\n");
        delivery_details.append("Total Price: $").append(delivery_full_priceFormatted).append("\n\n");
    
        return delivery_details.toString();
    }*/
}
