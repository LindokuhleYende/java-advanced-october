package Tutorials;

import java.util.*;

class Student {
    String name;
    int age;
    Student(String name, int age) {
        this.name = name; this.age = age;
    }
    public String toString() {
        return name + " (" + age + ")";
    }
}

public class ComparatorExample {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 23));
        students.add(new Student("Bob", 20));
        students.add(new Student("Charlie", 22));

        // Sort by age using Comparator
        students.sort(new Comparator<Student>() {
            public int compare(Student s1, Student s2) {
                return Integer.compare(s1.age, s2.age);
            }
        });

        System.out.println(students); // [Bob (20), Charlie (22), Alice (23)]
    }
}

