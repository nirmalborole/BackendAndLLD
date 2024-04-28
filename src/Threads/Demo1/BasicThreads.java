package Threads.Demo1;

public class BasicThreads implements Runnable{

    @Override
    public void run() {
        System.out.println("I am in new Theads" + Thread.currentThread().getName());
    }
}
