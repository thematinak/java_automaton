package org.example.anoita;

import com.almasb.fxgl.app.GameApplication;
import com.almasb.fxgl.app.GameSettings;
import com.almasb.fxgl.dsl.FXGL;
import javafx.fxml.FXMLLoader;
import org.example.anoita.controler.Controller;

import java.io.IOException;

public class HelloApplication extends GameApplication {

    @Override
    protected void initSettings(GameSettings gameSettings) {
        gameSettings.setWidth(502);
        gameSettings.setHeight(665);
    }

    @Override
    protected void initUI() {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Controller.setInstance(fxmlLoader.getController());
        try {
            FXGL.addUINode(fxmlLoader.load(), 0, 0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Controller.getInstance().start();
    }

    public static void main(String[] args) {
        launch(args);
    }


}