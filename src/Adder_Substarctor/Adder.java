package Adder_Substarctor;

public class Adder implements Runnable {
    Count count;
    public Adder(Count count){
        this.count=count;
    }

    @Override
    public void run() {
        for(int i=1;i<=100000;i++){
            count.num++;
            System.out.println("I am count"+i);
        }
    }
}
