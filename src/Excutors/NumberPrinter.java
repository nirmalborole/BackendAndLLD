package Excutors;

public class NumberPrinter implements Runnable{
    @Override
    public void run() {
        System.out.println("I am in new thred");
        for(int i=0;i<10;i++){
            System.out.println("i:"+ i+ Thread.currentThread().getName());
        }
    }
}
