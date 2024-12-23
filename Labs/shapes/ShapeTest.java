package se.liu.denjo163.shapes;

import java.awt.*;
import java.util.ArrayList;

public class ShapeTest
{
    public static void main(String[] args) {
	final ArrayList<Shape> shapes = new ArrayList<>();
	Circle circle1 = new Circle(2, 5, 3, Color.RED);
	Circle circle2 = new Circle(4, 2, 5, Color.BLUE);
	Rectangle rectangle1 = new Rectangle(4, 6, 5, 7, Color.BLACK);
	Rectangle rectangle2 = new Rectangle(2, 8, 4, 4, Color.YELLOW);
	shapes.add(circle1);
    	shapes.add(circle2);
	shapes.add(rectangle1);
	shapes.add(rectangle2);
	shapes.add(new Text(7,4,2,Color.ORANGE, "Hi"));
	shapes.add(new Text(8,2,6, Color.RED, "Hii"));
	shapes.add(new Text(7,1,8,Color.GRAY, "Hello World"));
	//for (Shape shape : shapes) {
	    //shape.draw();
	//}
    }
}

