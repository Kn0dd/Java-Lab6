package com.example.lab6;

import com.example.lab6.exceptions.InvalidCircleException;
import com.example.lab6.exceptions.InvalidRectangleException;
import com.example.lab6.geometry2d.Circle;
import com.example.lab6.geometry2d.Figure;
import com.example.lab6.geometry2d.Rectangle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FigureModel {
    private final List<Figure> figures = new ArrayList<>();
    private final Random random = new Random();
    private final double canvasWidth;
    private final double canvasHeight;

    public FigureModel(double canvasWidth, double canvasHeight) {
        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;
    }

    public List<Figure> getFigures() {
        return figures;
    }

    public void addRandomCircle() {
        double radius = 10 + random.nextDouble() * 70;
        double diameter = radius * 2;
        double x = random.nextDouble() * (canvasWidth - diameter);
        double y = random.nextDouble() * (canvasHeight - diameter);
        try {
            figures.add(new Circle(radius, x, y, generateRandomColorHex()));
        } catch (InvalidCircleException ignored) {}
    }

    public void addRandomRectangle() {
        double length = 15 + random.nextDouble() * 135;
        double width = 15 + random.nextDouble() * 135;
        double x = random.nextDouble() * (canvasWidth - length);
        double y = random.nextDouble() * (canvasHeight - width);
        try {
            figures.add(new Rectangle(length, width, x, y, generateRandomColorHex()));
        } catch (InvalidRectangleException ignored) {}
    }

    private String generateRandomColorHex() {
        return String.format("#%02X%02X%02X",
                random.nextInt(256),
                random.nextInt(256),
                random.nextInt(256));
    }

    public Figure findTopFigureAt(double x, double y) {
        for (int i = figures.size() - 1; i >= 0; i--) {
            Figure figure = figures.get(i);
            if (figure.contains(x, y)) {
                return figure;
            }
        }
        return null;
    }

    public void bringToFront(Figure figure) {
        if (figure != null && figures.remove(figure)) {
            figures.add(figure);
        }
    }

    public void moveFigure(Figure figure, double dx, double dy) {
        if (figure != null) {
            figure.moveBy(dx, dy);
        }
    }

    public boolean changeTopFigureColorAt(double x, double y) {
        Figure top = findTopFigureAt(x, y);
        if (top != null) {
            top.setColorHex(generateRandomColorHex());
            return true;
        }
        return false;
    }
}
