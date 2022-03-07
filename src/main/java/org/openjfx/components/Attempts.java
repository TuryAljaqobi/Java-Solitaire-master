package org.openjfx.components;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import org.openjfx.enums.ColumnWidth;
import org.openjfx.enums.Dir;

import java.io.File;

import static org.openjfx.utils.Path.getFilePath;
import static org.openjfx.utils.Path.loadFont;

public class Attempts {
    /*
    Attempts class is the number of times
    a player can go through all the cards in the
    pile before it results in a game over.
    Currently not implimented
    */

    private static Attempts instance;

    //Set lives to 5. Can reduce for more of a challenge or increase to ease difficulty
    private int life = 5;

    private Attempts() {}

    public static void tookDamage() {
        if(instance.life > 0) --instance.life;
    }

    public static Text attemptText() {
        if(instance == null) instance = new Attempts();

        Font font = loadFont(40);
        Text text = new Text("try " + instance.life);

        text.setFont(font);
        text.setFill(Color.WHITE);
        text.setWrappingWidth(ColumnWidth.FIRST.width);

        return text;
    }

    //User must have at least 1 life to continue
    public static boolean isAlive() {
        return instance.life >= 1;
    }

    //Game over text for when user has no more lives
    public static Text gameOverText() {
        Font font = loadFont(40);
        Text text = new Text("Game Over");

        text.setFont(font);
        text.setFill(Color.WHITE);
        text.setWrappingWidth(ColumnWidth.MIDDLE.width);

        return text;
    }

    //Winner text for when user completes game
    public static Text winnerText(Color color) {

        Font font = loadFont(74);
        Text text = new Text("You Win");

        text.setFont(font);
        text.setFill(color);


        return text;
    }
}
