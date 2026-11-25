package com.example.lab6;

import com.example.lab6.geometry2d.Circle;
import com.example.lab6.geometry2d.Figure;
import com.example.lab6.geometry2d.Rectangle;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class PaintController {

    @FXML private Canvas canvas;

    private FigureModel model;

    @FXML public void initialize() {
        model = new FigureModel(canvas.getWidth(), canvas.getHeight());
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
