package Design_Pattern.Prototype_Registry;

public class Student {
    private int age;
    private String name;
    private String university;


    public Student(int age, String name, String university) {
        this.age = age;
        this.name = name;
        this.university = university;
    }

    public Student(Student original){
        this.age=original.age;
        this.name=original.name;
        this.university=original.university;
    }

    @Override
    protected Student clone() {
        return new Student(this);
    }
}
