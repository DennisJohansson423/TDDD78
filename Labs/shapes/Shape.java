package se.liu.denjo163.shapes;

import java.awt.*;

interface Shape
{
    int getX();

    int getY();

    Color getColor();

    void draw(final Graphics g);

}
