package Lambadas;

public class Main {
    public static void main(String[] args) {
        A a= new A(){
            @Override
            public void show() {
                System.out.println(" I AM in new A");
            }
        };
        a.show();
        D d= new D(){
            @Override
            public void Demo() {
                System.out.println("I in demo");
            }
        };
        d.Demo();
        D dlambada=() -> System.out.println("I am in lambada");
        dlambada.Demo();

        Runnable r= new Runnable() {
            @Override
            public void run() {
                System.out.println("I am in new thread"+ Thread.currentThread().getName());
            }
        };
        Thread t=new Thread(r);
        t.start();

        Runnable rlambada=() -> System.out.println("I am in new lambada thread"+ Thread.currentThread().getName());
        Thread tlambada=new Thread(rlambada);
        tlambada.start();

        C clambada= n -> {
            System.out.println(("C:"+ n*n));
        };
        clambada.squre(5);
        E elambada= (n,m)-> n+m;
        System.out.println("E:"+(elambada.sum(4,5)));
    }
}
class A {
    public void show(){
        System.out.println("I am in A");
    }
}
@FunctionalInterface
interface D{
    public void Demo();
}

interface C{
    public void squre(int a);
}

interface E{
    public int sum(int a,int b);
}
