package max.hubbard.Factoring;

import javax.swing.*;
import java.util.regex.Pattern;

/**
 * ***********************************************************************
 * Copyright Max Hubbard (c) 2014. All Rights Reserved.
 * Any code contained within this document, and any associated documents with similar branding
 * are the sole property of Max. Distribution, reproduction, taking snippets, or
 * claiming any contents as your own will break the terms of the license, and void any
 * agreements with you, the third party.
 * ************************************************************************
 */
public class Main {

    public static JTextArea label;
    private static JFrame f;
    private static JPanel p;


    public static void main(String[] args) {
        Main main = new Main();

        main.init();
    }

    public void init() {

        JFrame frame = new JFrame();
        JPanel panel = new JPanel();

        f = frame;
        p = panel;

        frame.setTitle("Factoring Calculator");

        Interface.mainInterface();

        frame.setEnabled(true);
        frame.setSize(600, 400);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);


        addToLabel("Choose an action on the right to perform");
    }

    public static void addToLabel(String str) {
        String t = label.getText();
        label.setText("");
        label.append(t + "\n" + str.replaceAll(Pattern.quote("+") + "-", "-").replaceAll("--", "+").replaceAll(Pattern.quote("+ ") + "-", "- ").replaceAll("- -", "+ ").replaceAll(Pattern.quote("^2"), "\u00B2").replaceAll(Pattern.quote("^3"), "\u00B3"));
    }

    public static JFrame getFrame() {
        return f;
    }

    public static JPanel getPanel() {
        return p;
    }
}
