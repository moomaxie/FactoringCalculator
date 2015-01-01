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
public class BSOFA {

        public static JPanel panel = new JPanel(new BorderLayout(3, 225));

    public static String doBSOFAS(String first, String second) {

        Main.addToLabel("");

        if (first.contains("^3")) {

            Main.addToLabel("Using SOFAS");
            Main.addToLabel(" ");
            Main.addToLabel("Square the front");
            Main.addToLabel("Opposite sign");
            Main.addToLabel("Front times back");
            Main.addToLabel("Always positive");
            Main.addToLabel("Square the back");

            Main.addToLabel(" ");

            String fVar = first.substring(0, first.length() - 2).replaceAll("\\d", "");
            String sVar = second.replaceAll("\\d", "");

            String oppSign;

            boolean sVarCube = false;

            int f = 1;
            int s = 1;

            try {
                f = Integer.parseInt(first.substring(0, first.length() - 3));
            } catch (Exception e) {

            }

            boolean neg = false;

            if (containsDigit(second)) {
                if (second.contains("-")) {
                    s = Integer.parseInt(second.replaceAll("\\D+", ""));
                    s = -s;
                    neg = true;
                } else {
                    s = Integer.parseInt(second.replaceAll("\\D+", ""));
                    neg = false;
                }
            }

            if (neg){
                oppSign = "+";
            } else {
                oppSign = "-";
            }

            if (!sVar.equals("") && second.contains("^")) {
                if (second.substring(second.length() - 1).equals("3")) {
                    sVar = second.substring(0, second.length() - 2);
                    sVar = sVar.replaceAll("\\d", "");
                    sVarCube = true;
                } else {
                    return "This equation cannot lay down on a SOFA";
                }
            }

            double fCube = cubeRoot(f);
            double sCube = cubeRoot(s);

            if (sCube * sCube * sCube == s && fCube * fCube * fCube == f) {

                if (sVar.contains("-")) {
                    sVar = sVar.replaceAll("-", "");
                }

                Main.addToLabel("Find Binomial: ");

                Main.addToLabel("");
                Main.addToLabel("Cubed Root of First Variable: " + fCube + fVar);
                Main.addToLabel("Cubed Root of Second Variable: " + sCube + sVar);

                String binomial = "(" + (int)fCube + fVar + " + " + (int)sCube + sVar + ")";

                Main.addToLabel("");
                Main.addToLabel("Binomial: " + binomial);

                Main.addToLabel("");

                Main.addToLabel("Square the Front: " + (fCube * fCube) + fVar + "^2");
                Main.addToLabel("(" + (fCube * fCube) + fVar + "^2");
                Main.addToLabel("");

                Main.addToLabel("Opposite Sign: " + oppSign);
                Main.addToLabel("(" + (fCube * fCube) + fVar + "^2 " + oppSign);
                Main.addToLabel("");

                if ((fCube * sCube) > 0) {

                    Main.addToLabel("Front times back: " + (fCube * sCube) + fVar + sVar);
                    Main.addToLabel("(" + (fCube * fCube) + fVar + "^2 " + oppSign + " " + Math.abs((fCube * sCube)) + fVar + sVar);
                    Main.addToLabel("");
                } else {
                    Main.addToLabel("Front times back: " + (fCube * sCube) + fVar + sVar + " (Opposite sign is '+' so this becomes positive)");
                    Main.addToLabel("(" + (fCube * fCube) + fVar + "^2 " + oppSign + " " + Math.abs((fCube * sCube)) + fVar + sVar);
                    Main.addToLabel("");
                }
                Main.addToLabel("Always Positive: +");
                Main.addToLabel("(" + (fCube * fCube) + fVar + "^2 " + oppSign + " " + Math.abs((fCube * sCube)) + fVar + sVar + " + ");
                Main.addToLabel("");

                String equation;

                if (sVarCube) {
                    Main.addToLabel("Square the back: " + Math.abs((sCube * sCube)) + sVar + "^2");
                    Main.addToLabel("(" + (fCube * fCube) + fVar + "^2 " + oppSign + " " + Math.abs((fCube * sCube)) + fVar + sVar + " + " + Math.abs((sCube * sCube)) + sVar + "^2" + ")");
                    Main.addToLabel("");
                    equation = "(" + (int)(fCube * fCube) + fVar + "^2 " + oppSign + " " + (int)Math.abs((fCube * sCube)) + fVar + sVar + " + " + (int)Math.abs((sCube * sCube)) + sVar + "^2" + ")";
                } else {
                    Main.addToLabel("Square the back: " + (sCube * sCube));
                    Main.addToLabel("(" + (fCube * fCube) + fVar + "^2 " + oppSign + " " + Math.abs((fCube * sCube)) + fVar + sVar + " + " + Math.abs((sCube * sCube)) + ")");
                    Main.addToLabel("");
                    equation = "(" + (int)(fCube * fCube) + fVar + "^2 " + oppSign + " " + (int)Math.abs((fCube * sCube)) + fVar + sVar + " + " + (int)Math.abs((sCube * sCube)) + ")";
                }

                Main.addToLabel("Multiply The Equations");
                Main.addToLabel("");

                return binomial + " " + equation;
            } else {
                return "This equation cannot lay down on a SOFA";
            }
        }

        return "This equation cannot lay down on a SOFA";
    }

    public static boolean containsDigit(String s) {
        boolean containsDigit = false;

        if (s != null && !s.isEmpty()) {
            for (char c : s.toCharArray()) {
                if (containsDigit = Character.isDigit(c)) {
                    break;
                }
            }
        }

        return containsDigit;
    }

    public static double cubeRoot(double d) {
        return Math.cbrt(d);
    }

    public static void makeBSOFAInterface() {

        Interface.mainInterface();

        panel = new JPanel(new BorderLayout(3, 225));

        JPanel pan = new JPanel();
        JLabel area = new JLabel("B-SOFA");
        area.setBackground(Color.lightGray);
        area.setFont(new Font("Times New Roman", Font.BOLD, 20));
        pan.add(area,BorderLayout.CENTER);

        panel.add(pan, BorderLayout.NORTH);

        final JTextField field = new JTextField();
        panel.add(field, BorderLayout.CENTER);
        field.setFont(new Font("Times New Roman", Font.BOLD, 20));
        field.setText("1");


        final JTextField bino = new JTextField();
        panel.add(bino, BorderLayout.AFTER_LINE_ENDS);
        bino.setFont(new Font("Times New Roman", Font.BOLD, 20));
        bino.setText("27");

        JButton start = new JButton("GO!");
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.updateUI();
                Main.label.setText("");
                Main.addToLabel("Answer: " + doBSOFAS(field.getText() + "x^3",bino.getText()));
            }
        });

        panel.add(start, BorderLayout.SOUTH);

        Main.getFrame().add(panel, BorderLayout.EAST);

        final Graphics g = panel.getGraphics().create();
        g.setFont(new Font("Times New Roman", Font.BOLD, 14));

        Main.getFrame().pack();

    }

    public static void removeBSOFAInterface(){
        panel.removeAll();
        Main.getFrame().remove(panel);
        Main.getFrame().pack();
    }
}
