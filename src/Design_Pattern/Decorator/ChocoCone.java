package Design_Pattern.Decorator;

public class ChocoCone implements Ingredient {

    @Override
    public double getCost() {
        return 20;
    }

    @Override
    public String getDescription() {
        return "Choco cone";
    }
}