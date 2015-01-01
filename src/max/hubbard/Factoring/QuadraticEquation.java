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
public class QuadraticEquation {

    public static JPanel panel = new JPanel(new BorderLayout(3, 225));

    public static String solveByQuad(int a, int b, int c) {
        boolean nan = false;
        Main.addToLabel("");

        Main.addToLabel("ax^2 + bx + c = 0");
        Main.addToLabel("");

        try {
            int dis = ((b * b) - 4 * (a * c));

            if (dis < 0) {
                Main.addToLabel("There will be an Unreal Answer!!");
            }

            Main.addToLabel("How To Find Discriminant:");

            Main.addToLabel("");
            Main.addToLabel("(b^2) - 4ac = Discriminant");

            Main.addToLabel("b * b = " + (b * b));
            Main.addToLabel("a * c = " + (a * c));
            Main.addToLabel("4 * " + (a * c) + " = " + (4 * (a * c)));

            Main.addToLabel("");

            Main.addToLabel((b * b) + " - " + (4 * (a * c)) + " = " + dis);

            Main.addToLabel("");
            Main.addToLabel("Discriminant = " + dis);

            if (dis < 0) {
                dis = -dis;
                nan = true;
            }

            double x = (-b - Math.sqrt(dis)) / (2 * a);

            double y = (-b + Math.sqrt(dis)) / (2 * a);

            Main.addToLabel("");

            Main.addToLabel("Find first answer for x: ");
            Main.addToLabel("");
            Main.addToLabel("x = (-b - √(discriminant)) / (2a)");

            Main.addToLabel("");
            if (!nan) {
                Main.addToLabel("Square Root of discriminant = " + Math.sqrt(dis));
            } else {
                Main.addToLabel("Square Root of discriminant = " + Math.sqrt(dis) + "i");
            }

            if (!nan) {
                Main.addToLabel(-b + " - " + Math.sqrt(dis) + " = " + (-b - Math.sqrt(dis)));
            } else {
                Main.addToLabel(-b + " - " + Math.sqrt(dis) + "i = " + (-b - Math.sqrt(dis)) + "i");
            }

            Main.addToLabel("2 * " + a + " = " + (2 * a));
            Main.addToLabel("");
            if (!nan) {
                Main.addToLabel((-b - Math.sqrt(dis)) + " / " + (2 * a) + " = " + x);
            } else {
                Main.addToLabel((-b - Math.sqrt(dis)) + "i / " + (2 * a) + " = " + x + "i");
            }

            Main.addToLabel("");
            Main.addToLabel("");

            Main.addToLabel("Find second answer for x: ");
            Main.addToLabel("");
            Main.addToLabel("x = (-b + √(discriminant)) / (2a)");

            Main.addToLabel("");
            if (!nan) {
                Main.addToLabel("Square Root of discriminant = " + Math.sqrt(dis));
            } else {
                Main.addToLabel("Square Root of discriminant = " + Math.sqrt(dis) + "i");
            }

            if (!nan) {
                Main.addToLabel(-b + " + " + Math.sqrt(dis) + " = " + (-b + Math.sqrt(dis)));
            } else {
                Main.addToLabel(-b + " + " + Math.sqrt(dis) + "i = " + (-b + Math.sqrt(dis)) + "i");
            }

            Main.addToLabel("2 * " + a + " = " + (2 * a));
            Main.addToLabel("");
            if (!nan) {
                Main.addToLabel((-b + Math.sqrt(dis)) + " / " + (2 * a) + " = " + y);
            } else {
                Main.addToLabel((-b + Math.sqrt(dis)) + "i / " + (2 * a) + " = " + y + "i");
            }
            Main.addToLabel("");

            if (!nan) {
                return "x = " + x + " OR x = " + y;
            } else {
                return "x = " + x + "i OR x = " + y + "i";
            }


        } catch (Exception ignored) {
        }
        return "Do you even Quadratic?";
    }

    public static void makeQuadraticEquationInterface() {

        Interface.mainInterface();

        panel = new JPanel(new BorderLayout(0, 225));

        JPanel pan = new JPanel();
        JLabel are = new JLabel("Quadratic Equation: ax² + bx + c = 0");
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
                    String fac = solveByQuad(Integer.parseInt(area.getText()), Integer.parseInt(field.getText()), Integer.parseInt(ar.getText()));
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

    public static void removeQuadraticEquationInterface() {
        panel.removeAll();
        Main.getFrame().remove(panel);
        Main.getFrame().pack();
    }
}
