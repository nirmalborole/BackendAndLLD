package Generics.Solution;

public class Main {
    public static void main(String[] args) {
        Printer<Integer>ip= new Printer<>(10);
        ip.print();
        int i= ip.get();

        Printer<String>sp= new Printer<>("hello");
        sp.print();

        Printer<Double>dp= new Printer<>(10.6);
        dp.print();
        double d= dp.get();

        Pair<String ,Integer>si= new Pair<>("Hello",10);
        String first = si.getFirst();
        Integer second = si.getSecond();

        Pair<String ,Pair<String ,Integer>> pair=new Pair<>("hello",si);
        Pair<String, Integer> second1 = pair.getSecond();

        Pair<Integer,Student> pairstudent= new Pair<>(10,new Student("nirmal",24));
        pairstudent.getSecond();
    }
}
class Student{
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
