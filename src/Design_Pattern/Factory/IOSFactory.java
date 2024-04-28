package Design_Pattern.Factory;

import Design_Pattern.Factory.Products.Button;
import Design_Pattern.Factory.Products.IOSButton;
import Design_Pattern.Factory.Products.IOSmenu;
import Design_Pattern.Factory.Products.menu;

public class IOSFactory implements UIFactory{
    @Override
    public IOSButton createbutton() {
        return new IOSButton();
    }

    @Override
    public IOSmenu createmenu() {
        return new IOSmenu();
    }
}
