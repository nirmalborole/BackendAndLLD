package machine_coding.parking_lot.models;

public class InvoiceDetails extends BaseModel{
    private String name;
    private double Price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return Price;
    }

    public void setPrice(double price) {
        Price = price;
    }
}
