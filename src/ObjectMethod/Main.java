package ObjectMethod;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        AnimalA a= new AnimalA("axc",24);
        System.out.println(a.toString());
        AnimalA b= new AnimalA("axc",289);

        AnimalA c= new AnimalA("cvb",26);
        AnimalA d= new AnimalA("cvb",26);

        Set<AnimalA> set= new HashSet<>();
        set.add(a);
        set.add(b);
        set.add(c);
        set.add(d);
        System.out.println(set.size());

    }
}

class AnimalA{
    String name;
    int age;

    public AnimalA(String name, int age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public String toString(){
        return "name:"+ name +", age:"+age;
    }
    public boolean equals(Object obj){
        if(obj instanceof AnimalA){
            AnimalA newAnimal=(AnimalA)obj;
            return newAnimal.name.equals(this.name) && newAnimal.age==this.age;
        }
        return false;
    }

    public int hashCode(){
        return this.name.hashCode() + this.age;
    }
}
