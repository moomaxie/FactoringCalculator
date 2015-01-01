package max.hubbard.Factoring;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * ***********************************************************************
 * Copyright Max Hubbard (c) 2014. All Rights Reserved.
 * Any code contained within this document, and any associated documents with similar branding
 * are the sole property of Max. Distribution, reproduction, taking snippets, or
 * claiming any contents as your own will break the terms of the license, and void any
 * agreements with you, the third party.
 * ************************************************************************
 */
public class CompleteTheSquare {

    public static JPanel panel = new JPanel(new BorderLayout(3, 225));

    public static String completeTheSquare(float a, float b, float c) {
        float newA = 1;
        float newB = b / a;
        float newC = c / a;
        if (a != 1) {
            Main.addToLabel("Divide By a (" + a + ")");

            Main.addToLabel("New Equation: " + newA + "x^2+" + newB + "x+" + newC + "=0");
        }
        Main.addToLabel("");
        Main.addToLabel("Move C");
        Main.addToLabel("New Equation: " + newA + "x^2+" + newB + "x=" + -newC);
        Main.addToLabel("");
        Main.addToLabel("Divide B by 2");
        float secondb = newB / 2;

        Main.addToLabel("(" + newA + "x+" + secondb + ")");
        Main.addToLabel("");

        Main.addToLabel("Multiply the new B by 2 (" + secondb + "*" + secondb + "=" + secondb * secondb + ")");

        float bTimesTwo = secondb * secondb;

        Main.addToLabel("Add to the C Side");
        Main.addToLabel("New Equation: " + "(" + newA + "x+" + secondb + ")^2" + "=" + (-newC + bTimesTwo));
        Main.addToLabel("");
        Main.addToLabel("Take Square root of both sides");

        float newnewC = -newC + bTimesTwo;

        if (newnewC < 0) {
            newnewC = -newnewC;

            Main.addToLabel("New Equation: " + newA + "x+" + secondb + "=±" + Math.sqrt(newnewC) + "i");
            Main.addToLabel("");
            Main.addToLabel("Solve for X");

            Main.addToLabel("");
            return "x = " + (-secondb + Math.sqrt(newnewC)) + "i OR x = " + (-secondb - Math.sqrt(newnewC) + "i");
        } else {

            Main.addToLabel("New Equation: " + newA + "x+" + secondb + "=±" + Math.sqrt(newnewC));
            Main.addToLabel("");
            Main.addToLabel("Solve for X");

            Main.addToLabel("");
            return "x = " + (-secondb + Math.sqrt(newnewC)) + " OR x = " + (-secondb - Math.sqrt(newnewC));
        }

    }


    public static void makeCompleteTheSquareInterface() {

        Interface.mainInterface();

        panel = new JPanel(new BorderLayout(0, 225));

        JPanel pan = new JPanel();
        JLabel are = new JLabel("Completing The Square");
        are.setBackground(Color.lightGray);
        are.setFont(new Font("Times New Roman", Font.BOLD, 20));
        pan.add(are, BorderLayout.CENTER);

        panel.add(pan, BorderLayout.NORTH);

        JPanel aPanel = new JPanel();
        JPanel bPanel = new JPanel();
        JPanel cPanel = new JPanel();

        final JTextArea field = new JTextArea();
        bPanel.add(field, BorderLayout.LINE_START);
        field.setFont(new Font("Times New Roman", Font.BOLD, 22));
        field.setText("24");

        final JTextArea area = new JTextArea();
        aPanel.add(area, BorderLayout.BEFORE_LINE_BEGINS);
        area.setFont(new Font("Times New Roman", Font.BOLD, 22));
        area.setText("6");

        final JTextArea ar = new JTextArea();
        cPanel.add(ar, BorderLayout.AFTER_LINE_ENDS);
        ar.setFont(new Font("Times New Roman", Font.BOLD, 22));
        ar.setText("-270");

        JButton start = new JButton("GO!");
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.updateUI();
                Main.label.setText("");
                try {
                    String fac = completeTheSquare(Integer.parseInt(area.getText()), Integer.parseInt(field.getText()), Integer.parseInt(ar.getText()));
                    Main.addToLabel("Answer: " + fac);
                } catch (Exception ignored) {
                    Main.addToLabel("Make sure there are only numbers in each box");
                }

            }
        });


        panel.add(bPanel, BorderLayout.CENTER);
        panel.add(aPanel, BorderLayout.BEFORE_LINE_BEGINS);
        panel.add(cPanel, BorderLayout.AFTER_LINE_ENDS);

        panel.add(start, BorderLayout.SOUTH);

        Main.getFrame().add(panel, BorderLayout.EAST);


        Main.getFrame().pack();

    }

    public static void removeCompleteTheSquareInterface() {
        panel.removeAll();
        Main.getFrame().remove(panel);
        Main.getFrame().pack();
    }
}
