package org.openjfx.interfaces;

import org.openjfx.decks.SideDeck;

@FunctionalInterface
public interface NextCard {
    public void flip(SideDeck deck);
}
