package Synchronized_Method;

public class Adder implements Runnable {
    Count count;
    public Adder(Count count){
        this.count=count;
    }

    @Override
    public void run() {
        for(int i=1;i<=100000;i++){
            count.increment();
//            System.out.println("I am count"+i);
        }
    }
}
