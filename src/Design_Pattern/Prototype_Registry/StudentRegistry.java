package Design_Pattern.Prototype_Registry;

import java.util.HashMap;
import java.util.Map;

public class StudentRegistry {
    private Map<String,Student> registry;

    private StudentRegistry(){
        registry=new HashMap<>();
    }

    private static StudentRegistry INSTANCE=null;
    public static StudentRegistry getInstance(){
        if(INSTANCE==null){
            INSTANCE=new StudentRegistry();
        }
        return INSTANCE;
    }

    public  void Register(String key, Student student){
        registry.put(key,student);
    }
    public Student get(String key){
        return  registry.get(key);
    }
}
