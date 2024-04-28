package Design_Pattern.Builder.Prod;

public class Client {
    public static void main(String[] args) throws Exception {
        Student s=Student.getBuilder()
                .setAge(23)
                .setPhone("35748993")
                .setEmail("dget@gdh")
                .setName("Nirmal")
                .build();

    }
}
