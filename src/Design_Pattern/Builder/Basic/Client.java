package Design_Pattern.Builder.Basic;

public class Client {
    public static void main(String[] args) throws Exception {
        Builder builder= new Builder();
        builder.setAge(30);
        builder.setEmail("ABC@gmail.com");
        builder.setName("Nirmal");
        builder.setPhone("3747589933");

        Student student= new Student(builder);
        System.out.println("DEBUG");

    }
}
