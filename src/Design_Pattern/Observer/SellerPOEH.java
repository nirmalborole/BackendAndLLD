package Design_Pattern.Observer;

public class SellerPOEH implements EventHandler{

    public SellerPOEH(){
        Publisher.getInstance().register(this);
    }
    @Override
    public void handle() {
        System.out.println("seller handling the place order");
    }

    public void unregister(){
        Publisher.getInstance().unregister(this);
    }
}
