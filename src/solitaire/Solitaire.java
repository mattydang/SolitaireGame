package solitaire;

import javax.swing.*;
import java.awt.*;

public class Solitaire extends JFrame {

    static protected BackPanel backPanel;
    public static final int PANEL_HEIGHT = 500, PANEL_WIDTH = 640;
    public Solitaire() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        backPanel = new BackPanel();
        backPanel.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        add(backPanel);
        pack();

    }

    public static void main(String[] args) {
        new Solitaire().setVisible(true);
    }
}
