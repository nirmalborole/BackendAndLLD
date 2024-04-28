package Generics.Intro;

public class ObjectPrinter {
    Object objtoprint;
    public ObjectPrinter(Object objtoprint){
        this.objtoprint=objtoprint;
    }

    public void print(){
        System.out.println(objtoprint);
    }
    public Object get(){
        return objtoprint;
    }
}
