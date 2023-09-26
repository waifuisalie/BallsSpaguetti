package massa.inc;

public class Restaurant extends Customer{


    public Restaurant (String name, String CNPJ, String address){
        super(name,CNPJ,address);
    }

    public void customer_type(){
        System.out.println("Restaurant");
    }
}
