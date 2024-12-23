package se.liu.denjo163_anthu456;

import java.awt.*;

public class PaddleMaker extends GameObject {
    private int height;
    private int width;
    public int velocity;

    public PaddleMaker(int height, int x, int y, int velocity, Color color) {
	super(x, y, color);
	this.height = height;
	this.width = 5;
	this.velocity = velocity;
    }

    public void movePaddle(int movementY, int upperBound, int lowerBound) {
	int centerY = position.y + height / 2;

	if (Math.abs(centerY - movementY) > velocity) {
	    if (centerY > movementY && position.y > upperBound) {
		position.y -= velocity;
	    }

	    if (centerY < movementY && position.y + height < lowerBound) {
		position.y += velocity;
	    }
	}
    }

    @Override
    public void draw(Graphics g) {
	g.setColor(color);
	g.fillRect(position.x, position.y, width, height);
    }
}
