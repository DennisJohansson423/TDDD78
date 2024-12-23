package se.liu.denjo163_anthu456;

import java.awt.*;

public class BallMaker extends GameObject {
    private int diameter;
    public Point velocity;

    public BallMaker(int x, int y, int vx, int vy, int diameter, Color color) {
	super(x, y, color);
	this.velocity = new Point(vx, vy);
	this.diameter = diameter;
    }

    public void move() {
	position.translate(velocity.x, velocity.y);
    }

    public void bounce(int upperBound, int lowerBound) {
	if (position.y <= upperBound || position.y >= lowerBound - diameter) {
	    velocity.y = -velocity.y;
	}
    }

    public void bounce(char axis) {
	if (axis == 'x') {
	    velocity.x = -velocity.x;
	} else if (axis == 'y') {
	    velocity.y = -velocity.y;
	}
    }

    @Override
    public void draw(Graphics g) {
	g.setColor(color);
	g.fillOval(position.x, position.y, diameter, diameter);
    }
}
