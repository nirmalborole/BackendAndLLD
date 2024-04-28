package Design_Pattern.Builder.Prod;

public class Student {
    String name;
    String email;
    int age;
    String phone;

    private Student(Builder b) {
        this.age=b.age;
        this.email=b.email;
        this.name=b.name;
        this.phone=b.phone;
    }
    public static Builder getBuilder(){
        return new Builder();
    }

    static class Builder{
        String name;
        String email;
        int age;
        String phone;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setPhone(String phone) {
            this.phone = phone;
            return this;
        }

        public Student build() throws Exception {
            if(this.age < 18){
                throw new Exception("age not valid");
            }
            return new Student(this);
        }
    }
}
