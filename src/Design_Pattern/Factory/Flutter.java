package Design_Pattern.Factory;

import Design_Pattern.Factory.Products.Platform;

public class Flutter {
    public static UIFactory getIOSFactoryByPlatform(Platform platform){
        if(platform.equals(platform.IOS)){
            return new IOSFactory();
        }else{
            return new AndroidFactory();
        }
    }
}
