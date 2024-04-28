package Excutors.callable;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class client {
    public static void main(String[] args) throws Exception {
        RandomNumber rn= new RandomNumber();
        ExecutorService executorService=Executors.newFixedThreadPool(2);
        Future<Integer> fi= executorService.submit(rn);
        System.out.println("I am processing");
        System.out.println("I am processing still");
        Integer i = fi.get();
        System.out.println(i);
        executorService.shutdown();
    }
}
