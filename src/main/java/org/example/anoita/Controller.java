package org.example.anoita;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;
import org.example.anoita.materials.liquids.Oil;
import org.example.anoita.materials.particles.Fire;
import org.example.anoita.materials.particles.GunPowder;
import org.example.anoita.materials.particles.Snow;
import org.example.anoita.materials.solid.Rock;
import org.example.anoita.materials.abst.Material;
import org.example.anoita.materials.particles.Sand;
import org.example.anoita.materials.liquids.Water;
import org.example.anoita.materials.solid.Wood;

public class Controller {

    public static final int SIZE = 5;
    private static Controller instance;
    @FXML
    public Canvas canvas;
    private final Model model;
    private final Timeline timeline;
    private Class<? extends Material> materialToPut;


    public Controller() {
        instance = this;
        timeline = new Timeline(new KeyFrame(Duration.millis(25), this::onTick));
        timeline.setCycleCount(Timeline.INDEFINITE);
        materialToPut = Water.class;
        model = new Model();
    }

    public void onTick(ActionEvent event) {
        model.makeMove();
        GraphicsContext ctx = canvas.getGraphicsContext2D();
        for (int row = 0; row < Model.SIZE.getFirst(); row++) {
            for (int col = 0; col < Model.SIZE.getSecond(); col++) {
                model.getFromBord(row, col).render(ctx, row, col, SIZE);
            }
        }

    }

    public void onMouseClicked(MouseEvent event) throws Exception {
        timeline.pause();

        int rowIdx = (int) (event.getY() / SIZE);
        int colIdx = (int) (event.getX() / SIZE);
        if (Material.isInBound(0, rowIdx, Model.SIZE.getFirst()) &&
                Material.isInBound(0, colIdx, Model.SIZE.getSecond())) {
            model.putToBord(rowIdx, colIdx, materialToPut.getConstructor().newInstance());
        }

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

    public void onWaterClick(ActionEvent e) {
        materialToPut = Water.class;
    }

    public void onSandClick(ActionEvent e) {
        materialToPut = Sand.class;
    }

    public void onRockClick(ActionEvent e) {
        materialToPut = Rock.class;
    }

    public void onOilClick(ActionEvent e) {
        materialToPut = Oil.class;
    }

    public void onWoodClick(ActionEvent e) {
        materialToPut = Wood.class;
    }

    public void onFireClick(ActionEvent e) {
        materialToPut = Fire.class;
    }

    public void onSnowClick(ActionEvent e) {
        materialToPut = Snow.class;
    }

    public void onGunPowderClick(ActionEvent e) {
        materialToPut = GunPowder.class;
    }

}