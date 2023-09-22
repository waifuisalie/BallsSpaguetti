package massa.inc;

public class Supermercado extends Cliente{

    public Supermercado (String name, String CNPJ, String address){
        super(name,CNPJ,address);
    }
    

    public void customer_type(){
        System.out.println("Restaurant");
    }
}
