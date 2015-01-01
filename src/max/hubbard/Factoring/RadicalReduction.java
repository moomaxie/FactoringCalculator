package max.hubbard.Factoring;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;

/**
 * ***********************************************************************
 * Copyright moomaxie (c) 2014. All Rights Reserved.
 * Any code contained within this document, and any associated documents with similar branding
 * are the sole property of moomaxie. Distribution, reproduction, taking snippets, or
 * claiming any contents as your own will break the terms of the license, and void any
 * agreements with you, the third party.
 * ************************************************************************
 */
public class RadicalReduction {

    public static JPanel panel = new JPanel(new BorderLayout(3, 225));

    //inside = 0, outside = 1
    public static int[] ReduceRadical(int insideArg) {

        int[] perfectSquares = GetPerfectSquares(insideArg + 1);
        int[] toReturn = {insideArg, 1};

        if (Math.sqrt(insideArg) == Math.round(Math.sqrt(insideArg))) {
            toReturn[0] = 1;
            toReturn[1] = (int) Math.sqrt(insideArg);
        }


        for (int i = 1; i <= perfectSquares.length; i++) {
            if (insideArg % perfectSquares[perfectSquares.length - i] == 0) {
                toReturn[0] = insideArg / perfectSquares[perfectSquares.length - i];
                toReturn[1] = (int) Math.sqrt(perfectSquares[perfectSquares.length - i]);
                break;
            }
        }
        return toReturn;
    }

    public static int[] GetPerfectSquares(int max) {
        List<Integer> toReturn = new LinkedList<Integer>();
        toReturn.add(4);
        for (int i = 1; ; i++) {
            toReturn.add(toReturn.get(i - 1) + ((i - 1) * 2) + 5);
            if (toReturn.get(i) >= max) {
                toReturn.remove(i);
                return intListToArray(toReturn);
            }
        }
    }

    static int[] intListToArray(List<Integer> list) {
        int[] ints = new int[list.size()];
        for (int i = 0; i < ints.length; i++)
            ints[i] = list.get(i);
        return ints;
    }

    public static void makeRadicalReductionInterface() {

        Interface.mainInterface();

        panel = new JPanel(new BorderLayout(0, 225));

        JPanel pan = new JPanel();
        JLabel are = new JLabel("Radical Reduction");
        are.setBackground(Color.lightGray);
        are.setFont(new Font("Times New Roman", Font.BOLD, 20));
        pan.add(are,BorderLayout.CENTER);

        panel.add(pan, BorderLayout.NORTH);



        final JTextField field = new JTextField();
        panel.add(field, BorderLayout.CENTER);
        field.setFont(new Font("Times New Roman", Font.BOLD, 22));
        field.setText("12");

        final JLabel area = new JLabel();
        panel.add(area, BorderLayout.BEFORE_LINE_BEGINS);
        area.setFont(new Font("Times New Roman", Font.BOLD, 30));
        area.setText("√");

        JButton start = new JButton("GO!");
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.updateUI();
                Main.label.setText("");
                String fac;
                int[] nums = RadicalReduction.ReduceRadical(Integer.parseInt(field.getText()));

                if (nums[1] != 1) {
                    fac = nums[1] + "√" + nums[0];
                } else {
                    fac = "√" + nums[0];
                }

                if (nums[0] != 1) {
                    fac = nums[1] + "√" + nums[0];
                } else {
                    fac = nums[1] + "";
                }
                Main.addToLabel("Answer: " + fac);
            }
        });

        panel.add(start, BorderLayout.SOUTH);

        Main.getFrame().add(panel, BorderLayout.EAST);


        Main.getFrame().pack();

    }

    public static void removeRadicalReductionInterface(){
        panel.removeAll();
        Main.getFrame().remove(panel);
        Main.getFrame().pack();
    }
}
