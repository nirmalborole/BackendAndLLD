package Excutors.callable;

import java.util.Random;
import java.util.concurrent.Callable;

public class RandomNumber implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Random random= new Random();
        System.out.println("I am a ramdom number");
        return random.nextInt();
    }
}
