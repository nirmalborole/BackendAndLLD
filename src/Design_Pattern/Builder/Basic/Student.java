package Design_Pattern.Builder.Basic;

public class Student {
    String name;
    String email;
    int age;
    String phone;

    public Student (Builder builder) throws Exception {
        if(builder.age < 18){
            throw new Exception("age is not valid");
        }
        this.age=builder.age;
        this.email=builder.email;
        this.name=builder.name;
        this.phone=builder.phone;
    }

}
