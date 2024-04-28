package Concurrent_ds;

import Adder_Substarctor.Count;

import java.util.concurrent.atomic.AtomicInteger;

public class Subsractor implements Runnable {
    private AtomicInteger ai;
    public Subsractor(AtomicInteger ai){
        this.ai=ai;
    }

    @Override
    public void run() {
        for(int i=1;i<=100000;i++){
            ai.decrementAndGet();
            System.out.println("I am count"+i);
        }
    }
}
