package Synchronized_Block;

import java.util.concurrent.locks.Lock;

public class Subsractor implements Runnable {
    Count count;
    final Object lock;
    public Subsractor(Count count, Object lock){
        this.count=count;
        this.lock=lock;
    }

    @Override
    public void run() {
        for(int i=1;i<=100000;i++){
            synchronized (lock) {
                count.num--;
            }
            System.out.println("I am count"+i);
        }
    }
}
