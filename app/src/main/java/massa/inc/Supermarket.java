package massa.inc;

public class Supermarket extends Customer{

    public Supermarket (String name, String CNPJ, String address){
        super(name,CNPJ,address);
    }
    

    public void customer_type(){
        System.out.println("Restaurant");
    }
}
