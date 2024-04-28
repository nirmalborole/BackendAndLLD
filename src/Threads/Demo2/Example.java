package Threads.Demo2;

public class Example{
    public static void main(String[] args) {
        EvenPrinter evenPrinter=new EvenPrinter();
        OddPrinter oddPrinter=new OddPrinter();
        Thread t1= new Thread(evenPrinter);
        Thread t2= new Thread(oddPrinter);
        t1.start();
        t2.start();

    }

}
