package Exceptions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args)  {
//        System.out.println("I am stating to read the file");
//        readFile("Scaler.txt");
//        System.out.println("I am not able to read");
//
//        getInt("1");
//        System.out.println(getInt("Nirmal"));
//        try {
//            readFile2("Scaler.txt");
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        System.out.println("I am not able to read");

        int age=-19;
        try {
            validateage(age);
        }catch (NegativeException ne){
            System.out.println(ne.getMessage());
            return;
        }
//        validateage(age);
        System.out.println("age verify");
    }

    public static void validateage(int age) throws NegativeException {
        if(age<0){
            throw new NegativeException("age not valid");
        }
    }
    public static void readFile(String Filepath){
        try {
            FileReader fileReader = new FileReader(Filepath);
        }catch(FileNotFoundException fnfe){
            System.out.println("error occured");
            System.out.println("error message:"+ fnfe.getMessage());
        }finally {
            System.out.println("I am still be well");
        }
    }
    public static int getInt(String name){
        try {
            return Integer.parseInt(name);
        }catch (NumberFormatException nfe){
            nfe.printStackTrace();
        }finally {
            System.out.println("all done");
        }
        return -1;
    }
    public static void readFile2(String Filepath) throws FileNotFoundException {
        FileReader fileReader = new FileReader(Filepath);

    }
}
