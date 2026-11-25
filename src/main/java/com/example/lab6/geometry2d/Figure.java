package com.example.lab6.geometry2d;

public interface Figure {
    double area();
    double perimeter();
    double getX();
    double getY();
    String getColorHex();

    void moveBy(double dx, double dy);
    void setColorHex(String colorHex);
    boolean contains(double px, double py);
}
