package org.openjfx.enums;

//Reference for what card numbers the Face Cards are
public enum CardNumber {
    ACE(1),
    JACK(11),
    QUEEN(12),
    KING(13);

    public int number;

    CardNumber(int number) {
        this.number = number;
    }
}
