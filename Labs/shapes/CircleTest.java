package se.liu.denjo163.shapes;

import java.awt.*;
import java.util.ArrayList;

public class CircleTest
{
    public static void main(String[] args) {
	final ArrayList<Circle> circles = new ArrayList<>();
	Circle circle1 = new Circle(2, 5, 3, Color.RED);
	Circle circle2 = new Circle(4, 2, 5, Color.BLUE);
	circles.add(circle1);
    	circles.add(circle2);
	for (Circle Circle : circles) {
	    System.out.println(Circle.getX() + " " + Circle.getY());
	}
    }
}

