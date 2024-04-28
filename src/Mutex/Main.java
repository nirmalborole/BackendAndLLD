package Mutex;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Lock lock= new ReentrantLock();
        Count count=new Count(0);
        Adder adder= new Adder(count,lock);
        Subsractor subsractor= new Subsractor(count,lock);
        Thread t1= new Thread(adder);
        Thread t2= new Thread(subsractor);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("o/p;" + count.num);
    }
}
