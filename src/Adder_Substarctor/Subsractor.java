package Adder_Substarctor;

public class Subsractor implements Runnable {
    Count count;
    public Subsractor(Count count){
        this.count=count;
    }

    @Override
    public void run() {
        for(int i=1;i<=100000;i++){
            count.num--;
            System.out.println("I am count"+i);
        }
    }
}
