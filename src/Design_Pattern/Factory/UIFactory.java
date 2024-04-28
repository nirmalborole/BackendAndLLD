package Design_Pattern.Factory;

import Design_Pattern.Factory.Products.Button;
import Design_Pattern.Factory.Products.menu;

public interface UIFactory {
    Button createbutton();
    menu createmenu();
}
