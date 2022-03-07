package org.openjfx.components;

import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import org.openjfx.containers.Stacks;
import org.openjfx.containers.Types;
import org.openjfx.decks.MainDeck;
import org.openjfx.decks.SideDeck;
import org.openjfx.layouts.Grids;
import org.openjfx.layouts.Pane;

import static org.openjfx.containers.Types.isAWin;
import static org.openjfx.extension.DeckExtension.populateDeck;
import static org.openjfx.extension.StackExtension.populateStacks;
import static org.openjfx.extension.TypesExtension.populateTypes;
import static org.openjfx.components.Attempts.*;

public class Game {
    private final SideDeck sideDeck = new SideDeck();
    private final MainDeck mainDeck = populateDeck();
    private final Types types = populateTypes();
    private final Stacks stacks = populateStacks(mainDeck);
    private final Grids grids = new Grids();
    private final Pane pane = Pane.setup(grids);
    private final Moves moves = new Moves();
    private final History history = new History(this, moves);

    //Creating the game on the the grid
    public Pane setup() {
        grids.addTo("deck", createDeckFace());
        grids.addTo("sideDeck", sideDeck.getNextCardFace(history));
        grids.addTo("attempt", attemptText());
        grids.addTo("type", types.createTypesFace(history));
        grids.addTo("stack", stacks.createDecks(history));
        return pane;
    }

    public void update() {
        types.verifyAllTypes();

        grids.setTo("deck", createDeckFace());
        grids.setTo("sideDeck", sideDeck.getNextCardFace(history));
        grids.setTo("attempt", attemptText());
        grids.setTo("type", types.createTypesFace(history));
        grids.setTo("stack", stacks.createDecks(history));

        //If user has not run out of lives and has placed all the cards on the top piles, they win
        if(isAlive() && isAWin()) {
            grids.getGrid("stack").setAlignment(Pos.CENTER);
            grids.getGrid("stack").getChildren().set(0, winnerText(Color.WHITE));
        }

        else if(!isAlive()) {
            grids.setTo("clock", gameOverText());
        }
    }

    public ImageView createDeckFace() {
        if(mainDeck.isDeckEmpty()) return mainDeck.createResetCardDeck(sideDeck, history);
        return mainDeck.createBackCardDeck(side -> {
            side.addCard(mainDeck.popCard());
            update();
        }, sideDeck, history);
    }
}