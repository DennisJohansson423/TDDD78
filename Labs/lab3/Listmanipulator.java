package se.liu.denjo163.lab3;

import se.liu.denjo163.lab1.Person;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Listmanipulator
{
    protected List<Person> elements = new ArrayList<>();

    public int size() {
	return elements.size();
    }

    public boolean add(final Person person) {
	return elements.add(person);
    }

    public boolean isEmpty() {
	return elements.isEmpty();
    }

    public void clear() {
	elements.clear();
    }

    public Person remove(final int index) {
	return elements.remove(index);
    }

    public boolean contains(final Object o) {
	return elements.contains(o);
    }

    public Iterator<Person> iterator() {
	return elements.iterator();
    }
}
