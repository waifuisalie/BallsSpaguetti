package massa.inc;

public class Supermarket extends Customer{

    public Supermarket (String name, String CNPJ, String address, String clientType){
        super(name,CNPJ,address, clientType);
    }
    

    public void customer_type(){
        System.out.println("Restaurant");
    }
}
