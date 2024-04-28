package Mutex;

import java.util.concurrent.locks.Lock;

public class Adder implements Runnable {
    Count count;
    Lock lock;
    public Adder(Count count, Lock lock){
        this.count=count;
        this.lock=lock;
    }

    @Override
    public void run() {
        for(int i=1;i<=100000;i++){
            lock.lock();
            count.num++;
            lock.unlock();
            System.out.println("I am count"+i);
        }
    }
}
