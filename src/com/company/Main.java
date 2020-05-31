package com.company;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("My first GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(new Okienko().getPanel());
        frame.setPreferredSize(new Dimension(600,340));
        frame.pack();
        frame.setVisible(true);
    }
}
