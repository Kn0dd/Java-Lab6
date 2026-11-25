package com.example.lab6.geometry2d;

import com.example.lab6.exceptions.InvalidRectangleException;

public class Rectangle implements Figure {
    private final double length;
    private final double width;
    private double x;
    private double y;
    private String colorHex;

    public Rectangle(double length, double width, double x, double y, String colorHex) throws InvalidRectangleException {
        if (length <= 0 || width <= 0) throw new InvalidRectangleException("Length and width must be > 0");
        this.length = length;
        this.width = width;
        this.x = x;
        this.y = y;
        this.colorHex = colorHex;
    }

    public double getLength() { return length; }
    public double getWidth() { return width; }

    @Override public double area() {
        return length * width;
    }
    @Override public double perimeter() {
        return 2 * length + 2 * width;
    }

    @Override public double getX() { return x; }
    @Override public double getY() { return y; }
    @Override public String getColorHex() { return colorHex; }

    @Override public void moveBy(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    @Override public void setColorHex(String colorHex) { this.colorHex = colorHex; }

    @Override public boolean contains(double px, double py) {
        return px >= x && px <= x + length && py >= y && py <= y + width;
    }
}
