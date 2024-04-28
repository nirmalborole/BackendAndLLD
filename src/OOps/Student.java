package OOps;

public class Student {
    int age;
    String name;
    Address address;

    public Student(int age, String name, Address address){
        this.age=age;
        this.name=name;
        this.address=address;
    }
    public Student(Student org){
        this.age= org.age;
        this.name= org.name;
        this.address= org.address;
    }
}
