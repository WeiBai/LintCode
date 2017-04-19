package BasicJava;

import java.util.*;

/**
 * Created by Wei on 2017/4/20.
 */
public class StudentCompare implements Comparable<StudentCompare>, Comparator<StudentCompare> {

    String name;
    int age;

    public StudentCompare(){}

    public StudentCompare(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return name;
    }

    public int age(){
        return age;
    }

    public int compareTo(StudentCompare sc){
        return this.name.compareTo(sc.name);
    }

    public int compare(StudentCompare sc1, StudentCompare sc2){
            return sc1.age - sc2.age;
    }

    public static void main(String args[]){
        List<StudentCompare> list = new ArrayList<StudentCompare>();

        list.add(new StudentCompare("abc", 10));
        list.add(new StudentCompare("def",3));
        list.add(new StudentCompare("cde",5));
        Collections.sort(list);

        for (StudentCompare sc : list){
            System.out.print(sc.name + ", ");
        }
        System.out.println();

        Collections.sort(list, new StudentCompare());
        for (StudentCompare sc : list){
            System.out.print(sc.name + ": " + sc.age + ", ");
        }
    }

}
