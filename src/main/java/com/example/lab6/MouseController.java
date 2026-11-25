package com.example.lab6;

import com.example.lab6.geometry2d.Circle;
import com.example.lab6.geometry2d.Figure;
import com.example.lab6.geometry2d.Rectangle;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class MouseController {

    @FXML private Canvas canvas;

    private FigureModel model;
    private Figure draggedFigure = null;
    private double lastMouseX;
    private double lastMouseY;

    @FXML public void initialize() {
        model = new FigureModel(canvas.getWidth(), canvas.getHeight());

        canvas.setOnMousePressed(this::onMousePressed);
        canvas.setOnMouseDragged(this::onMouseDragged);
        canvas.setOnMouseReleased(this::onMouseReleased);

        render();
    }

    @FXML protected void onAddCircleClick() {
        model.addRandomCircle();
        render();
    }

    @FXML protected void onAddRectangleClick() {
        model.addRandomRectangle();
        render();
    }

    private void onMousePressed(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();

        if (event.getButton() == MouseButton.PRIMARY) {
            draggedFigure = model.findTopFigureAt(x, y);
            if (draggedFigure != null) {
                model.bringToFront(draggedFigure);
                lastMouseX = x;
                lastMouseY = y;
                render();
            }
        } else if (event.getButton() == MouseButton.SECONDARY) {
            if (model.changeTopFigureColorAt(x, y)) {
                render();
            }
        }
    }

    private void onMouseDragged(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY && draggedFigure != null) {
            double dx = event.getX() - lastMouseX;
            double dy = event.getY() - lastMouseY;

            model.moveFigure(draggedFigure, dx, dy);
            lastMouseX = event.getX();
            lastMouseY = event.getY();
            render();
        }
    }

    private void onMouseReleased(MouseEvent event) {
        if (event.getButton() == MouseButton.PRIMARY) {
            draggedFigure = null;
        }
    }

    private void render() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.setFill(Color.WHITESMOKE);
        gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());

        for (Figure figure : model.getFigures()) {
            gc.setFill(Color.web(figure.getColorHex()));
            if (figure instanceof Circle c) {
                double diameter = c.getRadius() * 2;
                gc.fillOval(c.getX(), c.getY(), diameter, diameter);
            } else if (figure instanceof Rectangle r) {
                gc.fillRect(r.getX(), r.getY(), r.getLength(), r.getWidth());
            }
        }
    }
}
