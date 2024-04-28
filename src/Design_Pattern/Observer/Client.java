package Design_Pattern.Observer;

public class Client {
    public static void main(String[] args) {
        InventoryPOEH inventoryPOEH=new InventoryPOEH();
        SellerPOEH sellerPOEH=new SellerPOEH();
        Publisher.getInstance().PlaceOrder();
    }
}
