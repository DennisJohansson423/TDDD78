package se.liu.denjo163.lab3;

import se.liu.denjo163.lab1.Person;

public class Queue extends Listmanipulator
{
    public void enqueue(Person person) {
	elements.add(person);
    }

    public Person dequeue() {
	return remove(0);
    }
}
