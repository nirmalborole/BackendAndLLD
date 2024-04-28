package Design_Pattern.Prototype_Registry;

import java.util.Random;

public class Main {

    public static final String Student_Key="STUDENT";
    public static final String Inteligent_Student="Inteligent";

    public static void main(String[] args) {
        SetupRegistry();
        Student student=getStudent();
        Student clone= student.clone();

        InteligentStudent Inteli_Stuent = (InteligentStudent) StudentRegistry.getInstance().get(Inteligent_Student);
    }

    public static void SetupRegistry(){
        StudentRegistry studentRegistry=StudentRegistry.getInstance();

        Student studentregistry= new Student(23,"ABC","DFG");
        InteligentStudent inteligentStudentregistry= new InteligentStudent(23,"rty","TYU",100);
        studentRegistry.Register(Student_Key,studentregistry);
        studentRegistry.Register(Inteligent_Student,inteligentStudentregistry);
    }
    public static Student getStudent(){
        Random random= new Random();
        int n= random.nextInt();
        if(n%2==0){
            return new Student(20,"ABC","SFHH");
        }else{
            return new InteligentStudent(37,"gdgd","gdhd",100);
        }
    }
}
