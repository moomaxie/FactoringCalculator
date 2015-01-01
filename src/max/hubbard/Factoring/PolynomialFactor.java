package max.hubbard.Factoring;

import max.hubbard.Factoring.Utils.Separate;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

/**
 * ***********************************************************************
 * Copyright Max Hubbard (c) 2014. All Rights Reserved.
 * Any code contained within this document, and any associated documents with similar branding
 * are the sole property of Max. Distribution, reproduction, taking snippets, or
 * claiming any contents as your own will break the terms of the license, and void any
 * agreements with you, the third party.
 * ************************************************************************
 */
public class PolynomialFactor {

    public static JPanel panel = new JPanel(new BorderLayout(3, 225));

    public static String doPolynomialFactor(String equation) {
        LinkedList<LinkedHashMap<Float, Integer>> list = Separate.separate(equation);

        int degree = Separate.getDegree(list);
        String finalEquation = equation;
        if (degree > 2) {

            List<Float> fac = new ArrayList<Float>();

            Main.addToLabel("Unfactorable Factorable!");

            for (int i = degree; i > 2; i--) {
                Main.addToLabel("q/p");
                float p = list.get(0).keySet().iterator().next();
                float q = list.get(list.size() - 1).keySet().iterator().next();
                Main.addToLabel("q = " + q);
                Main.addToLabel("p = " + p);

                Main.addToLabel("Factors of p (" + p + "):");
                Map<Integer, Integer> pFactors = Factor.getFactors((int) p);
                List<Integer> pList = new ArrayList<Integer>();
                for (int in : pFactors.keySet()) {
                    int x = pFactors.get(in);

                    if (in * x == Math.abs(p)) {
                        Main.addToLabel(in + " & " + x);
                        pList.add(in);
                        pList.add(x);
                    }
                }

                Main.addToLabel("");
                Main.addToLabel("Factors of q (" + q + "):");
                Map<Integer, Integer> qFactors = Factor.getFactors((int) q);
                List<Integer> qList = new ArrayList<Integer>();
                for (int in : qFactors.keySet()) {
                    int x = qFactors.get(in);

                    if (in * x == Math.abs(q)) {
                        Main.addToLabel(in + " & " + x);
                        qList.add(in);
                        qList.add(x);
                    }
                }
                Main.addToLabel("");
                Main.addToLabel("All Qs over all Ps");

                List<Float> divideByList = new ArrayList<Float>();

                for (float pNum : pList) {
                    for (float qNum : qList) {

                        Main.addToLabel(qNum + " / " + pNum + " = " + qNum / pNum);

                        divideByList.add(qNum / pNum);
                    }
                }

                boolean can = false;
                String newEquation = "";
                float working = 0;

                Main.addToLabel("");
                Main.addToLabel("Do Synthetic Division: ");

                for (float f : divideByList) {
                    if (SyntheticDivision.getRemainder(finalEquation.replaceAll("²", "^2").replaceAll("³", "^3"), f) == 0) {
                        can = true;
                        working = f;
                        newEquation = SyntheticDivision.doSyntheticDivisionWithoutTutorial(finalEquation.replaceAll("²", "^2").replaceAll("³", "^3"), f);
                        break;
                    } else if (SyntheticDivision.getRemainder(finalEquation.replaceAll("²", "^2").replaceAll("³", "^3"), -f) == 0) {
                        can = true;
                        working = -f;
                        newEquation = SyntheticDivision.doSyntheticDivisionWithoutTutorial(finalEquation.replaceAll("²", "^2").replaceAll("³", "^3"), -f);
                        break;
                    }
                }

                if (can) {
                    Main.addToLabel("Working q/p is: " + -working);
                    Main.addToLabel("");
                    Main.addToLabel("New Equation is: " + newEquation);
                    Main.addToLabel("");

                    fac.add(working);
                    finalEquation = newEquation.split(" Remainder")[0];

                    list = Separate.separate(finalEquation.replaceAll("²", "^2").replaceAll("³", "^3").split(" Remainder")[0]);
                } else {
                    return "None of these work... This is awkward...";
                }
            }

            String finals = "";

            for (float f : fac) {
                finals = finals + "(x+" + f + ")";
            }

            finals = finals + "(" + finalEquation + ")";

            return finals.split(" Remainder")[0];

        } else if (degree == 2) {
            try {
                return Factor.factorForThree(list.get(0).keySet().iterator().next() + "x^2", list.get(1).keySet().iterator().next() + "x", String.valueOf(list.get(2).keySet().iterator().next()));
            } catch (Exception ignored) {
                return "Could not Factor...";
            }
        }


        return "Could not Factor...";
    }

    public static void makePolynomialFactoringInterface() {

        Interface.mainInterface();

        panel = new JPanel(new BorderLayout(3, 225));

        JPanel pan = new JPanel();
        JLabel area = new JLabel("Factoring Polynomials");
        area.setBackground(Color.lightGray);
        area.setFont(new Font("Times New Roman", Font.BOLD, 20));
        pan.add(area, BorderLayout.CENTER);

        panel.add(pan, BorderLayout.NORTH);

        final JTextField field = new JTextField();
        panel.add(field, BorderLayout.CENTER);
        field.setFont(new Font("Times New Roman", Font.BOLD, 25));
        field.setText("x^4-2x^2-8");

        JButton start = new JButton("GO!");
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.updateUI();
                Main.label.setText("");
                Main.addToLabel("Answer: " + doPolynomialFactor(field.getText()));
            }
        });

        panel.add(start, BorderLayout.SOUTH);

        Main.getFrame().add(panel, BorderLayout.EAST);

        Main.getFrame().pack();

    }

    public static void removePolynomialFactoringInterface() {
        panel.removeAll();
        Main.getFrame().remove(panel);
        Main.getFrame().pack();
    }
}
