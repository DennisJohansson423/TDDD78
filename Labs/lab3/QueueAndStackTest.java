package se.liu.denjo163.lab3;

import se.liu.denjo163.lab1.Person;

import java.time.LocalDate;

public class QueueAndStackTest
{
    public static void main(String[] args) {
        Queue queue = new Queue();
        Stack stack = new Stack();
        Person person1 = new Person("Person1", LocalDate.of(2002, 3, 21));
        Person person2 = new Person("Person2", LocalDate.of(2012, 5, 27));
        Person person3 = new Person("Person3", LocalDate.of(2000, 1, 2));
        Person person4 = new Person("Person4", LocalDate.of(2009, 12, 1));
        Person person5 = new Person("Person5", LocalDate.of(2022, 7, 30));

        queue.enqueue(person1);
        queue.enqueue(person2);
        queue.enqueue(person3);
        queue.enqueue(person4);
        queue.enqueue(person5);
        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }
        System.out.println(" ");
        stack.push(person1);
        stack.push(person2);
        stack.push(person3);
        stack.push(person4);
        stack.push(person5);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}
