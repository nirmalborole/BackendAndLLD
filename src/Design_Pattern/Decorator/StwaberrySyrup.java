package Design_Pattern.Decorator;

public class StwaberrySyrup extends IngredientDecorator{
    public StwaberrySyrup(Ingredient baseIngredient) {
        super(baseIngredient);
    }

    @Override
    public double getCost() {
        return baseIngredient.getCost()+ 40;
    }

    @Override
    public String getDescription() {
        return baseIngredient.getDescription()+ ", Adding syrup";
    }
}
