package Design_Pattern.Factory;

import Design_Pattern.Factory.Products.Button;
import Design_Pattern.Factory.Products.Platform;
import Design_Pattern.Factory.Products.menu;

public class Client {
    public static void main(String[] args) {
        UIFactory uiFactory = Flutter.getIOSFactoryByPlatform(Platform.IOS);
        menu createmenu = uiFactory.createmenu();
        createmenu.render();
        Button buttinios = uiFactory.createbutton();
        buttinios.click();


    }
}
