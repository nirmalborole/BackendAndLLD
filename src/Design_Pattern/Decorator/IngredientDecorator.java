package Design_Pattern.Decorator;

public abstract class IngredientDecorator implements Ingredient {
    Ingredient baseIngredient;

    public IngredientDecorator(Ingredient baseIngredient) {
        this.baseIngredient = baseIngredient;
    }
}
