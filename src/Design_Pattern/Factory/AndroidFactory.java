package Design_Pattern.Factory;


import Design_Pattern.Factory.Products.Androidmenu;
import Design_Pattern.Factory.Products.AndroidButton;

public class AndroidFactory implements UIFactory{
    @Override
    public AndroidButton createbutton() {
        return new AndroidButton();
    }

    @Override
    public Androidmenu createmenu() {
        return new Androidmenu();
    }
}
