package Design_Pattern.Observer;

public class InventoryPOEH implements EventHandler{

    public InventoryPOEH(){
        Publisher.getInstance().register(this);
    }
    @Override
    public void handle() {
        System.out.println("placing an order");
    }

    public void unregister(){
        Publisher.getInstance().unregister(this);
    }
}
