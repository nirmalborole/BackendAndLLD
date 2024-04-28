package Design_Pattern.Decorator;

public class Main {
    public static void main(String[] args) {
        Ingredient icecream=
                new ChocoChips(
                        new StwaberrySyrup(
                                new MangoScoop(
                                        new ChocoCone()
                                )
                        )
                );

        System.out.println(icecream.getCost());
        System.out.println(icecream.getDescription());
    }
}
