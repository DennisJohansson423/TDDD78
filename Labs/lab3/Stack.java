package se.liu.denjo163.lab3;

import se.liu.denjo163.lab1.Person;

public class Stack extends Listmanipulator
{
    public void push(Person person) {
	add(person);
    }

    public Person pop() {
	return remove(size()-1);
    }
}
