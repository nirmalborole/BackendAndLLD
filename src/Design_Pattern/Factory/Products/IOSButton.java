package Design_Pattern.Factory.Products;

public class IOSButton implements Button{
    @Override
    public void click() {
        System.out.println("clicking on IOS Button");
    }
}
