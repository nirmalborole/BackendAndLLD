package Design_Pattern.Prototype_Registry;

public class InteligentStudent extends Student{
    private int iq;

    public InteligentStudent(int age, String name, String university, int iq) {
        super(age, name, university);
        this.iq = iq;
    }

    public InteligentStudent(Student original, int iq) {
        super(original);
        this.iq = iq;
    }

    public InteligentStudent(InteligentStudent original){
        super(original);
        this.iq=original.iq;
    }

    public InteligentStudent clone(){
        return new InteligentStudent(this);
    }

}
