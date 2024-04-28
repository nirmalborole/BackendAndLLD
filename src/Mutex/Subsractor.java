package Mutex;

import java.util.concurrent.locks.Lock;

public class Subsractor implements Runnable {
    Count count;
    Lock lock;
    public Subsractor(Count count, Lock lock){
        this.count=count;
        this.lock=lock;
    }

    @Override
    public void run() {
        for(int i=1;i<=100000;i++){
            lock.lock();
            count.num--;
            lock.unlock();
            System.out.println("I am count"+i);
        }
    }
}
