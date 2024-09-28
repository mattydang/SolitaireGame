package solitaire;

import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;

public class GMoves extends MouseInputAdapter {

    private Deck deck = BackPanel.getDeck();
    private Waste waste = null;
    private Card selectCard = null;

    @Override
    public void mousePressed(MouseEvent e){
        Component pressedC = e.getComponent().getComponentAt(e.getPoint());
        if(pressedC instanceof Foundation){
            
        } else if (pressedC instanceof Tableau) {
            
        } else if (pressedC instanceof Deck) {
            if (!deck.isEmpty()){
                Waste waste = BackPanel.getWaste();
                waste.push(deck.pop());
                waste.topCard().showFace();
            }
        } else if (pressedC instanceof Waste) {
            System.out.println("Waste is Clicked!");
            waste = BackPanel.getWaste();
            selectCard = waste.topCard();
            if (selectCard != null){
                for (Foundation foundation : BackPanel.getFoundPiles()){
                    foundation.moveFromWaste(waste, selectCard);
                }
            }
        }
        e.getComponent().repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
    }
}
