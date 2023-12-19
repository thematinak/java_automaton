package org.example.anoita.controler;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import org.example.anoita.model.Model;

public class Controller {

    private static Controller instance;
    @FXML
    public Canvas canvas;
    private final Model model;
    private final Timeline timeline;
    private final DrawBord drawBord;
    public final ButtonController buttonController;


    public Controller() {
        instance = this;
        timeline = new Timeline(new KeyFrame(Duration.millis(25), this::onTick));
        timeline.setCycleCount(Timeline.INDEFINITE);
        buttonController = new ButtonController();
        buttonController.onTypeClick("WATER");
        model = new Model();
        drawBord = new DrawBord(this);
    }

    public void onTick(ActionEvent event) {
        model.makeMove();
        drawBord.draw(model);
    }

    public void onMouseClicked(MouseEvent event) {
        timeline.pause();

        int rowIdx = drawBord.getRow((int) event.getY());
        int colIdx = drawBord.getCol((int) event.getX());
        model.putToBord(rowIdx, colIdx, buttonController.getMaterial());

        timeline.play();
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public static void setInstance(Controller instance) {
        Controller.instance = instance;
    }

    public void start() {
        timeline.play();
    }

    public void pause() {
        timeline.pause();
    }

    public void onTypeClick(ActionEvent e) {
        buttonController.onTypeClick(((Button)e.getSource()).getId());
    }

}