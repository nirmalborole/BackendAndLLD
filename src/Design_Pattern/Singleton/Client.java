package Design_Pattern.Singleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        Map<String, Boolean>map= new ConcurrentHashMap<>();
        for(int i=0;i<100;i++){
            System.out.println("Iteration:"+i);
            Runnable r = () -> {
                DBConnection dbc= DBConnection.getInstance();
                map.put(dbc.toString(),true);
            };
            Thread t= new Thread(r);
            t.start();
            t.join();
        }
        System.out.println("Output:"+map.size());

    }
}
