package massa.inc;

public class Customer {
    private String name;
    private String CNPJ;
    private String address;

    public Customer (String name, String CNPJ, String address) {
        this.name = name;
        this.CNPJ = CNPJ;
        this.address = address;
    }

    public String displayInformation() {
        String details = "\n" + "Name: " + name + "\n"
                       + "CNPJ: " + CNPJ + "\n" + "Address: " + address + "\n";
        //System.out.print(details);
        return details;
    }

    // Getters and setters (optional)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}