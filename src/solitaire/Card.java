package solitaire;

import javax.swing.*;
import java.awt.*;

public class Card {
    public static String backFaceName = "backface",
            cardOutName = "cardOutline",
            foundName = "f";
    public static String extension = ".png";
    private Image im;
    private int value;
    private String suit;
    private boolean faceUp;

    public Card (int value, Suit suit){
        this.value = value;
        switch (suit) {
            case Clubs:
                this.suit = "c";
                break;
            case Diamonds:
                this.suit = "d";
                break;
            case Spades:
                this.suit = "s";
                break;
            case Hearts:
                this.suit = "h";
        }
        faceUp = false;

        try {
            ImageIcon ii = new ImageIcon(getClass().getResource("../faceCards/" + cardFile(suit, value)));
            im = ii.getImage();
        }catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }
    }

    private String cardFile (Suit s, int value){
        char ch;
        if (value < 1 || value > 13)
            throw new IllegalArgumentException("Bad Card Number");
        if (s == Suit.Clubs) {
            ch = 'c';
        } else if (s == Suit.Hearts) {
            ch = 'h';
        } else if (s == Suit.Spades) {
            ch = 's';
        } else if (s == Suit.Diamonds) {
            ch = 'd';
        } else throw new IllegalArgumentException("Bad Card Suit");
        if (value < 10)
            return "/0" + value + ch + extension;
        else
            return "/" + value + ch + extension;
    }

    public Image getCardImage() {
        return im;
    }
    public boolean isFaceUp() {
        return faceUp;
    }

    @Override
    public String toString() {
        return value + " of " + suit;
    }

    public static Image getFoundBase(int suit){
        ImageIcon ii  = new ImageIcon(
                Card.class.getResource( "../faceCards/" + foundName + suit + extension));
        Image image = ii.getImage();
        return image;
    }
    public static Image getCardOutline(){
        ImageIcon ii  = new ImageIcon(
                Card.class.getResource( "../faceCards/" + cardOutName + extension));
        Image image = ii.getImage();
        return image;
    }

    public static Image getCardBack(){
        ImageIcon ii  = new ImageIcon(
                Card.class.getResource( "../faceCards/" + backFaceName + extension));
        Image image = ii.getImage();
        return image;
    }

    public int getValue() {
        return value;
    }

    public String getSuit() {
        return suit;
    }

    public void showFace(){
        faceUp = true;
    }
}
