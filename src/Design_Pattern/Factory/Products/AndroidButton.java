package Design_Pattern.Factory.Products;

public class AndroidButton implements Button {
    @Override
    public void click() {
        System.out.println("Clicking on android button");
    }
}
