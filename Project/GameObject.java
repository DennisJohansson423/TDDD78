package se.liu.denjo163_anthu456;

import java.awt.*;

public abstract class GameObject {
    protected Point position;
    protected Color color;

    protected GameObject(int x, int y, Color color) {
	this.position = new Point(x, y);
	this.color = color;
    }

    public abstract void draw(Graphics g);
}
