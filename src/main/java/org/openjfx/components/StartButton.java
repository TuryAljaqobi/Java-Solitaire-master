package org.openjfx.components;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.openjfx.layouts.Pane;

import java.io.File;

import static org.openjfx.utils.Path.getFilePath;
import static org.openjfx.enums.Dir.*;

public class StartButton {

    //Creating the start button on the home page to begin the game.
    private final Stage stage;

    public StartButton(Stage stage) {
        this.stage = stage;
    }

    public ImageView setup() {
        Image image = new Image(new File(getFilePath(ICONS.dir, "start_button.png")).toURI().toString());
        ImageView button = new ImageView(image);

        button.setOnMouseClicked(event -> {
            Pane pane = new Game().setup();
            Scene scene = new Scene(pane);

            button.setStyle("-fx-opacity: 0.8");
            stage.setScene(scene);
        });

        return button;
    }
}
