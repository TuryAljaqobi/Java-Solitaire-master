package org.openjfx.layouts;

import javafx.scene.layout.GridPane;
import org.openjfx.enums.ColumnWidth;

public class Pane extends GridPane {

    private Pane() {
        super();
    }

    public static Pane setup(Grids grids) {
        Pane pane = new Pane();

        pane.setMinSize(ColumnWidth.BOTH.width, 768d);
        pane.setStyle("-fx-background-color: #6B8CFE; -fx-padding: 35px");
        pane.setVgap(50d);
        pane.add(grids.getGrid("attempt"), 0, 0);
        pane.add(grids.getGrid("deck"), 0, 1);
        pane.add(grids.getGrid("sideDeck"), 1, 1);
        pane.add(grids.getGrid("type"), 2, 1);
        pane.add(grids.getGrid("stack"), 0, 2, 3, 1);

        return pane;
    }
}
