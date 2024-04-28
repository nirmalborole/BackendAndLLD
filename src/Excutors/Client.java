package Excutors;

//import java.util.concurrent.Executor;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
import java.util.concurrent.*;

public class Client {
    public static void main(String[] args) {
        NumberPrinter numberPrinter= new NumberPrinter();
//        Thread t= new Thread(numberPrinter);
//        t.start();
//        ExecutorService ex= Executors.newFixedThreadPool(2);
        ExecutorService ex= Executors.newCachedThreadPool();
        for(int i=0;i<10;i++){
            ex.execute(numberPrinter);
        }
        ex.shutdown();
    }
}
