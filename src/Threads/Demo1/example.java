package Threads.Demo1;

public class example {
    public static void main(String[] args) {
        BasicThreads basicThreads= new BasicThreads();
        System.out.println("I am in main Theads" + Thread.currentThread().getName());
        Thread t= new Thread(basicThreads);
        t.start();
    }
}
