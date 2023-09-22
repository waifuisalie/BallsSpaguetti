package massa.inc;

public class Restaurante extends Cliente{


    public Restaurante (String name, String CNPJ, String address){
        super(name,CNPJ,address);
    }

    public void customer_type(){
        System.out.println("Restaurant");
    }
}
