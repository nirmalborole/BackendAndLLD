package Streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(1,34,23,45,67,60,87,80);

        // print odd number
        list.stream()
                .filter(x -> x%2==1)
                .forEach(y -> System.out.println(y));

        // get the list of even number & print it.

        List<Integer> list1=list.stream()
                .filter(x->x%2==0)
                .collect(Collectors.toList());
        System.out.println("Even:"+list1);

        // need the count of even which is greater than 10

        long count = list.stream()
                .filter(num -> num % 2 == 0 && num > 10)
                .count();
        System.out.println(count);

        List<String> name= Arrays.asList("Nirmal","Bhavik","Ravalika","Sanjay","Anmol","Aakash");
        // Create a new list where each element is the size of the string in the original list
        List<Integer> namelength= name.stream()
                .map(nam -> nam.length())
                .collect(Collectors.toList());
        System.out.println("name Length:"+ namelength);

        // create list where first name contains first 2 char
        List<String> fisrt2Char = name.stream()
                .map(var -> var.substring(0, 2))
                .collect(Collectors.toList());
        System.out.println("First 2 Char:"+fisrt2Char);

        // Filter names starting with "B" and count the number of characters in them and
        // create a new list out of it
        List<Integer> Bname = name.stream()
                .filter(var -> var.charAt(0) == 'B')
                .map(var -> var.length())
                .collect(Collectors.toList());
        System.out.println("First B:"+Bname);

        // Sort the even elements in the list
        List<Integer> sortedlist = list.stream()
                .filter(n -> n % 2 == 0)
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sortedlist);

        List<Integer> oddsqure = list.stream()
                .filter(n -> n % 2 == 0)
                .map(m -> m * m)
                .collect(Collectors.toList());
        System.out.println(oddsqure);
        List<Student>stlist=Arrays.asList(new Student("Nirma",25),
                new Student("Bhavik",29),new Student("Ram",34));

        List<String> studentlist = stlist.stream()
                .map(student -> student.getName())
                .collect(Collectors.toList());
        System.out.println(studentlist);
        List<Integer> li= Arrays.asList(1,3,5,7,9);
        Optional<Integer> oi = li.stream()
                .filter(x -> {
                    System.out.println("I am in filet:" + x);
                    return x % 2 == 0;
                })
                .findFirst();
        if(oi.isPresent()){
            System.out.println(oi.get());
        }else{
            System.out.println("out");
        }

    }
}
class Student{
    String name;
    int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }
}
