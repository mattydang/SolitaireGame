package solitaire;

import javax.swing.*;
import java.awt.*;

public class BackPanel extends JPanel {

    protected static int XShift = 80;
    public static Point DECK_POS = new Point(500, 20);
    public static Point TAB_POS = new Point(20, 150);
    private static int TAB_OFFSET = 80;
    private static Deck deck;
    private static Waste waste;
    private static Foundation[] foundPiles;
    private static Tableau[] tableau;

    public BackPanel() {
        super.setLayout(null);
        pileCreation();

        GMoves g = new GMoves();
        addMouseListener(g);
        addMouseMotionListener(g);
    }
    private void pileCreation(){
        deck = new Deck(DECK_POS.x, DECK_POS.y);
        add(deck);
        waste = new Waste(DECK_POS.x - XShift, DECK_POS.y);
        add(waste);
        foundPiles = new Foundation[4];
        for(int i = 0; i < foundPiles.length; ++i) {
            foundPiles[i] = new Foundation(20 + XShift * i, 20, i + 1);
            add(foundPiles[i]);
        }
        tableau = new Tableau[7];
        for(int tabIndex = 1; tabIndex <= tableau.length; ++tabIndex) {
            tableau[tabIndex - 1] = new Tableau(TAB_POS.x + TAB_OFFSET * (tabIndex - 1), TAB_POS.y, tabIndex + 1);
            add(tableau[tabIndex - 1]);
        }
    }

    public static Foundation[] getFoundPiles() {return foundPiles;}
    public static Waste getWaste() {return waste;}
    public static Deck getDeck() {
        return deck;
    }

    @Override
    protected void paintComponent(Graphics back) {
        super.paintComponent(back);
        back.setColor(new Color(34, 157, 34, 255));
        back.fillRect(0, 0, this.getWidth(), this.getHeight());
    }
}
