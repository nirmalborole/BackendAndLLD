package Generics.Solution;

public class Printer<T> {
    T thingtoprint;
    public Printer(T thingtoprint){
        this.thingtoprint=thingtoprint;
    }
    public void print(){
        System.out.println(thingtoprint);
    }
    public T get(){
        return thingtoprint;
    }
}
