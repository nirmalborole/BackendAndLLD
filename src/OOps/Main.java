package OOps;

import OOps.Address;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Nirmal");
        Address address= new Address("xyz");
        Student s1= new Student(20,"Nirmal",address);
        Student copy= new Student(s1);
        s1.address.area="ABC";
        System.out.print(copy.address.area);
        System.out.print(s1.address.area);
        ArrayList<Integer>list=new ArrayList<>();
    }
}