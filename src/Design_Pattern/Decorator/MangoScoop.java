package Design_Pattern.Decorator;

public class MangoScoop extends IngredientDecorator{
    public MangoScoop(Ingredient baseIngredient) {
        super(baseIngredient);
    }

    @Override
    public double getCost() {
        return baseIngredient.getCost()+34;
    }

    @Override
    public String getDescription() {
        return baseIngredient.getDescription()+ ", MangoScoop";
    }
}
