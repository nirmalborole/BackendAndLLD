package Concurrent_ds;

import java.util.concurrent.atomic.AtomicInteger;

public class main {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger ai= new AtomicInteger(0);
//        System.out.println(ai.incrementAndGet());
//        System.out.println(ai.decrementAndGet());
        Adder adder= new Adder(ai);
        Subsractor subsractor = new Subsractor(ai);
        Thread t1= new Thread(adder);
        Thread t2= new Thread(subsractor);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("op:"+ ai.get());
    }
}
