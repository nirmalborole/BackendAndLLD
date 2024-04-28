package Adder_Substarctor;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Count count=new Count(0);
        Adder adder= new Adder(count);
        Subsractor subsractor= new Subsractor(count);
        Thread t1= new Thread(adder);
        Thread t2= new Thread(subsractor);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println("o/p;" + count.num);
    }
}
