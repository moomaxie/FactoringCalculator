package max.hubbard.Factoring;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

/**
 * ***********************************************************************
 * Copyright Max Hubbard (c) 2014. All Rights Reserved.
 * Any code contained within this document, and any associated documents with similar branding
 * are the sole property of Max. Distribution, reproduction, taking snippets, or
 * claiming any contents as your own will break the terms of the license, and void any
 * agreements with you, the third party.
 * ************************************************************************
 */
public class Interface {
    private static int start = 0;

    public static JComboBox box;

    public static void mainInterface() {

        Main.getFrame().remove(Main.getPanel());

        Main.getPanel().removeAll();

        SyntheticDivision.removeSyntheticDivisionInterface();
        RadicalReduction.removeRadicalReductionInterface();
        QuadraticEquation.removeQuadraticEquationInterface();
        BSOFA.removeBSOFAInterface();
        Factor.removeQuadraticFactorInterface();
        CompleteTheSquare.removeCompleteTheSquareInterface();
        PolynomialFactor.removePolynomialFactoringInterface();
        PolynomialSolving.removePolynomialSolvingInterface();
        Graphing.removeGraphingInterface();

        Main.getPanel().setBorder(new TitledBorder(new EtchedBorder(), "Calculations"));

        JMenuBar bar = new JMenuBar();
        bar.setEnabled(true);

        JButton info = new JButton("Info");
        info.setVisible(true);
        info.setFocusable(false);

        info.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.label.setText(" ");

                final java.util.Timer timer = new java.util.Timer("Info");

                final java.util.List<String> INFO = Arrays.asList("Factoring Calculator v2.0", " ",
                        "This calculator was created by Max Hubbard", " ",
                        "Copyright Max Hubbard (c) 2014. All Rights Reserved.",
                        "You may not distribute this calculator without the direct consent from Max Hubbard", " ",
                        "This calculator was designed specifically as a helping/teaching tool.",
                        "It is not suggested to be used for one's own personal gain.",
                        "This calculator and the creator are not responsible for anything that may happen while it is in use.");

                final int to = INFO.size();


                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        if (start < to) {
                            Main.addToLabel(INFO.get(start));
                            start++;
                        } else {
                            timer.cancel();
                            timer.purge();

                            start = 0;
                        }
                    }
                }, 0l, 40L);
            }
        });

        bar.add(info);

        Main.getFrame().add(bar, BorderLayout.NORTH);


        JTextArea area = new JTextArea(30, 80);
        area.setEditable(false);
        area.setBackground(Color.lightGray);
        area.setFont(new Font("Times New Roman", Font.BOLD, 14));
        Main.label = area;
        Main.getPanel().add(Main.label, BorderLayout.CENTER);

        JScrollPane scroll = new JScrollPane(area);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        Main.getPanel().add(scroll);

        Main.getFrame().add(Main.getPanel());


        box = new JComboBox();
        box.addItem("Choose an Item");
        box.addItem("Synthetic Division");
        box.addItem("Radical Reduction");
        box.addItem("Quadratic Equation");
        box.addItem("Quadratic Factoring");
        box.addItem("B-SOFA");
        box.addItem("Completing The Square");
        box.addItem("Polynomial Factoring");
        box.addItem("Polynomial Solving");
        box.addItem("Graphing");

        box.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (box.getSelectedItem().equals("Choose an Item")) {

                } else if (box.getSelectedItem().equals("Synthetic Division")) {
                    SyntheticDivision.makeSyntheticDivisionInterface();
                } else if (box.getSelectedItem().equals("Radical Reduction")) {
                    RadicalReduction.makeRadicalReductionInterface();
                } else if (box.getSelectedItem().equals("Quadratic Equation")){
                    QuadraticEquation.makeQuadraticEquationInterface();
                } else if (box.getSelectedItem().equals("B-SOFA")){
                    BSOFA.makeBSOFAInterface();
                } else if (box.getSelectedItem().equals("Quadratic Factoring")){
                    Factor.makeQuadraticFactorInterface();
                } else if (box.getSelectedItem().equals("Polynomial Factoring")){
                    PolynomialFactor.makePolynomialFactoringInterface();
                } else if (box.getSelectedItem().equals("Completing The Square")){
                    CompleteTheSquare.makeCompleteTheSquareInterface();
                } else if (box.getSelectedItem().equals("Polynomial Solving")){
                    PolynomialSolving.makePolynomialSolvingInterface();
                } else if (box.getSelectedItem().equals("Graphing")){
                    Graphing.makeGraphingInterface();
                }
                
                //TODO: Graphing

            }
        });

        Main.getPanel().add(box, BorderLayout.EAST);

    }
}
