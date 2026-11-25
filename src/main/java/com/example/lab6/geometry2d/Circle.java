package com.example.lab6.geometry2d;

import com.example.lab6.exceptions.InvalidCircleException;

public class Circle implements Figure {
    private final double radius;
    private double x;
    private double y;
    private String colorHex;

    public Circle(double radius, double x, double y, String colorHex) throws InvalidCircleException {
        if (radius <= 0) throw new InvalidCircleException("Radius must be > 0");
        this.radius = radius;
        this.x = x;
        this.y = y;
        this.colorHex = colorHex;
    }

    public double getRadius() { return radius; }

    @Override public double area() {
        return Math.PI * radius * radius;
    }
    @Override public double perimeter() {
        return 2 * Math.PI * radius;
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
        double centerX = x + radius;
        double centerY = y + radius;
        double dx = px - centerX;
        double dy = py - centerY;
        return dx * dx + dy * dy <= radius * radius;
    }
}
