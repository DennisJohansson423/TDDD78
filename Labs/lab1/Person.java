package se.liu.denjo163.lab1;

import java.time.LocalDate;

public class Person
{
    private String name;
    private LocalDate birthDay;
    private int getAge() {
        LocalDate today = LocalDate.now();
        int age = today.getYear() - birthDay.getYear();
        if (birthDay.getDayOfYear() > today.getDayOfYear()) {
            age--;
        }
        return age;
    }

    public Person(String name, LocalDate birthDay) {
        this.name = name;
        this.birthDay = birthDay;
    }

    public static void main(String[] args) {
        Person p1 = new Person("Dennis", LocalDate.of(2002, 2, 5));
        Person p2 = new Person("Person2", LocalDate.of(2001, 1, 16));
        Person p3 = new Person("Person3", LocalDate.of(2000, 8, 27));
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }
    @Override public String toString() {
        return name + " is " + getAge() + " years old";
    }
}
