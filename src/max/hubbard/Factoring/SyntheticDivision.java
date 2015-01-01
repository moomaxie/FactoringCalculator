package max.hubbard.Factoring;

import max.hubbard.Factoring.Utils.Separate;
import max.hubbard.Factoring.Utils.SuperScripts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.TimerTask;

/**
 * ***********************************************************************
 * Copyright Max Hubbard (c) 2014. All Rights Reserved.
 * Any code contained within this document, and any associated documents with similar branding
 * are the sole property of Max. Distribution, reproduction, taking snippets, or
 * claiming any contents as your own will break the terms of the license, and void any
 * agreements with you, the third party.
 * ************************************************************************
 */
public class SyntheticDivision {

    public static JPanel panel = new JPanel(new BorderLayout(3, 225));
    //1x^2+5x+6 1x-1
    //2x^3-5x^2+3x+7 1x-2

    public static String doSyntheticDivision(String original, String binomial) {

        LinkedList<LinkedHashMap<Float, Integer>> values = Separate.separate(original);
        int degree = Separate.getDegree(values);

        LinkedList<LinkedHashMap<Float, Integer>> binomialValues = Separate.separate(binomial);
        int binomialDegree = Separate.getDegree(binomialValues);

        float bime1 = Separate.getFirstKey(binomialValues.get(0));
        float bime1Exp = Separate.getFirstValue(binomialValues.get(0));
        float bime2 = Separate.getLastKey(binomialValues.get(1));
        float bime2Exp = Separate.getLastValue(binomialValues.get(1));
        if (bime2Exp == 0 && bime1Exp == 1) {
            float toDivideBy = -bime2 / bime1;

            float starting = Separate.getFirstKey(values.get(0));
            float moving;
            int movingDegree = degree;

            float remainder = 0;

            LinkedList<Float> end = new LinkedList<Float>();

            LinkedList<Float> tp = new LinkedList<Float>();
            LinkedList<Float> mid = new LinkedList<Float>();
            LinkedList<Float> bot = new LinkedList<Float>();

            Main.addToLabel(toDivideBy + ")");

            boolean doneOne = false;

            int testDegree = degree;

            int until = 0;

            for (int in = 0; in < testDegree + 1; in++) {
                float top;
                int i = in;

                if (i != 0 && Separate.getValue(values, i) != movingDegree) {
                    top = 0;
                    in--;
                    testDegree--;

                } else {
                    top = Separate.getKey(values, i);
                }

                if (i == 0 && !doneOne) {
                    starting = 0;
                    doneOne = true;
                }
                moving = top + starting;

                if (until < degree) {
                    end.add(moving);
                    bot.add(moving);
                } else {
                    remainder = moving;
                }

                tp.add(top);
                mid.add(starting);



                starting = moving * toDivideBy;


                movingDegree--;

                until++;

                if (movingDegree < 0) {
                    movingDegree = 0;
                }
            }

            String toop = "";
            String miid = "";
            String boot = "";
            String line = "--";

            for (float f : tp) {
                toop = toop + "  " + f;
                line = line + "------";
            }

            for (float f : mid) {
                miid = miid + "  " + f;
            }

            for (float f : bot) {
                boot = boot + "  " + f;
            }

            Main.addToLabel(toop);
            Main.addToLabel(miid);
            Main.addToLabel(line + "----");
            Main.addToLabel(boot + "  " + remainder);

            String fin = "";

            for (Float f : bot) {

                if (degree > 1) {
                    degree--;
                }

                if (f > 0) {
                    if (degree > 1) {
                        fin = fin + "+" + f + "x" + SuperScripts.getScriptForNumber(degree);
                    } else {
                        if (fin.length() > 3 && !fin.substring(fin.length() - 3, fin.length()).contains("^") &&
                                !fin.substring(fin.length() - 2, fin.length()).contains("x")
                                ) {
                            fin = fin + "x+" + f;
                        } else {
                            fin = fin + "+" + f;

                        }
                    }
                } else {
                    if (degree > 1) {
                        fin = fin + f + "x" + SuperScripts.getScriptForNumber(degree);
                    } else {
                        if (fin.length() > 3 && !fin.substring(fin.length() - 3, fin.length()).contains("^") &&
                                !fin.substring(fin.length() - 2, fin.length()).contains("x")
                                ) {
                            fin = fin + "x" + f;
                        } else {
                            fin = fin + "+" + f;

                        }
                    }
                }
            }

            fin = fin + " Remainder: " + remainder;

            if (fin.substring(0, 1).equals("+")) {
                fin = fin.substring(1);
            }

            Main.addToLabel("");

            return fin;
        } else {
            return "I'm not advanced enough for this...";
        }
    }

    public static String doSyntheticDivisionWithoutTutorial(String original, String binomial) {

        LinkedList<LinkedHashMap<Float, Integer>> values = Separate.separate(original);
        int degree = Separate.getDegree(values);

        LinkedList<LinkedHashMap<Float, Integer>> binomialValues = Separate.separate(binomial);
        int binomialDegree = Separate.getDegree(binomialValues);

        float bime1 = Separate.getFirstKey(binomialValues.get(0));
        float bime1Exp = Separate.getFirstValue(binomialValues.get(0));
        float bime2 = Separate.getLastKey(binomialValues.get(1));
        float bime2Exp = Separate.getLastValue(binomialValues.get(1));
        if (bime2Exp == 0 && bime1Exp == 1) {
            float toDivideBy = -bime2 / bime1;

            float starting = Separate.getFirstKey(values.get(0));
            float moving;
            int movingDegree = degree;

            float remainder = 0;

            LinkedList<Float> end = new LinkedList<Float>();

            LinkedList<Float> tp = new LinkedList<Float>();
            LinkedList<Float> mid = new LinkedList<Float>();
            LinkedList<Float> bot = new LinkedList<Float>();

            boolean doneOne = false;

            int testDegree = degree;

            int until = 0;

            for (int in = 0; in < testDegree + 1; in++) {
                float top;
                int i = in;

                if (i != 0 && Separate.getValue(values, i) != movingDegree) {
                    top = 0;
                    in--;
                    testDegree--;

                } else {
                    top = Separate.getKey(values, i);
                }

                if (i == 0 && !doneOne) {
                    starting = 0;
                    doneOne = true;
                }
                moving = top + starting;

                if (until < degree) {
                    end.add(moving);
                    bot.add(moving);
                } else {
                    remainder = moving;
                }

                tp.add(top);
                mid.add(starting);



                starting = moving * toDivideBy;


                movingDegree--;

                until++;

                if (movingDegree < 0) {
                    movingDegree = 0;
                }
            }

            String toop = "";
            String miid = "";
            String boot = "";
            String line = "--";

            for (float f : tp) {
                toop = toop + "  " + f;
                line = line + "------";
            }

            for (float f : mid) {
                miid = miid + "  " + f;
            }

            for (float f : bot) {
                boot = boot + "  " + f;
            }

            String fin = "";

            for (Float f : bot) {

                if (degree > 1) {
                    degree--;
                }

                if (f > 0) {
                    if (degree > 1) {
                        fin = fin + "+" + f + "x" + SuperScripts.getScriptForNumber(degree);
                    } else {
                        if (fin.length() > 3 && !fin.substring(fin.length() - 3, fin.length()).contains("^") &&
                                !fin.substring(fin.length() - 2, fin.length()).contains("x")
                                ) {
                            fin = fin + "x+" + f;
                        } else {
                            fin = fin + "+" + f;

                        }
                    }
                } else {
                    if (degree > 1) {
                        fin = fin + f + "x" + SuperScripts.getScriptForNumber(degree);
                    } else {
                        if (fin.length() > 3 && !fin.substring(fin.length() - 3, fin.length()).contains("^") &&
                                !fin.substring(fin.length() - 2, fin.length()).contains("x")
                                ) {
                            fin = fin + "x" + f;
                        } else {
                            fin = fin + "+" + f;

                        }
                    }
                }
            }

            fin = fin + " Remainder: " + remainder;

            if (fin.substring(0, 1).equals("+")) {
                fin = fin.substring(1);
            }

            return fin;
        } else {
            return "I'm not advanced enough for this...";
        }
    }

    public static String doSyntheticDivision(String original, float binomial) {

        LinkedList<LinkedHashMap<Float, Integer>> values = Separate.separate(original);
        int degree = Separate.getDegree(values);

        float toDivideBy = -binomial;

        float starting = Separate.getFirstKey(values.get(0));
        float moving;
        int movingDegree = degree;

        float remainder = 0;

        LinkedList<Float> end = new LinkedList<Float>();

        LinkedList<Float> tp = new LinkedList<Float>();
        LinkedList<Float> mid = new LinkedList<Float>();
        LinkedList<Float> bot = new LinkedList<Float>();

        Main.addToLabel(toDivideBy + ")");

        boolean doneOne = false;

        int testDegree = degree;

        int until = 0;

        for (int in = 0; in < testDegree + 1; in++) {
            float top;
            int i = in;

            if (i != 0 && Separate.getValue(values, i) != movingDegree) {
                top = 0;
                in--;
                testDegree--;

            } else {
                top = Separate.getKey(values, i);
            }

            if (i == 0 && !doneOne) {
                starting = 0;
                doneOne = true;
            }
            moving = top + starting;

            if (until < degree) {
                end.add(moving);
                bot.add(moving);
            } else {
                remainder = moving;
            }

            tp.add(top);
            mid.add(starting);



            starting = moving * toDivideBy;


            movingDegree--;

            until++;

            if (movingDegree < 0) {
                movingDegree = 0;
            }
        }

        String toop = "";
        String miid = "";
        String boot = "";
        String line = "--";

        for (float f : tp) {
            toop = toop + "  " + f;
            line = line + "------";
        }

        for (float f : mid) {
            miid = miid + "  " + f;
        }

        for (float f : bot) {
            boot = boot + "  " + f;
        }

        Main.addToLabel(toop);
        Main.addToLabel(miid);
        Main.addToLabel(line + "----");
        Main.addToLabel(boot + "  " + remainder);

        String fin = "";

        for (Float f : bot) {

            if (degree > 1) {
                degree--;
            }

            if (f > 0) {
                if (degree > 1) {
                    fin = fin + "+" + f + "x" + SuperScripts.getScriptForNumber(degree);
                } else {
                    if (fin.length() > 3 && !fin.substring(fin.length() - 3, fin.length()).contains("^") &&
                            !fin.substring(fin.length() - 2, fin.length()).contains("x")
                            ) {
                        fin = fin + "x+" + f;
                    } else {
                        fin = fin + "+" + f;

                    }
                }
            } else {
                if (degree > 1) {
                    fin = fin + f + "x" + SuperScripts.getScriptForNumber(degree);
                } else {
                    if (fin.length() > 3 && !fin.substring(fin.length() - 3, fin.length()).contains("^") &&
                            !fin.substring(fin.length() - 2, fin.length()).contains("x")
                            ) {
                        fin = fin + "x" + f;
                    } else {
                        fin = fin + "+" + f;

                    }
                }
            }
        }

        fin = fin + " Remainder: " + remainder;

        if (fin.substring(0, 1).equals("+")) {
            fin = fin.substring(1);
        }

        Main.addToLabel("");

        return fin;

    }

    public static String doSyntheticDivisionWithoutTutorial(String original, float binomial) {

        LinkedList<LinkedHashMap<Float, Integer>> values = Separate.separate(original);
        int degree = Separate.getDegree(values);


        float toDivideBy = -binomial;

        float starting = Separate.getFirstKey(values.get(0));
        float moving;
        int movingDegree = degree;

        float remainder = 0;

        LinkedList<Float> end = new LinkedList<Float>();

        LinkedList<Float> tp = new LinkedList<Float>();
        LinkedList<Float> mid = new LinkedList<Float>();
        LinkedList<Float> bot = new LinkedList<Float>();

        boolean doneOne = false;

        int testDegree = degree;

        int until = 0;

        for (int in = 0; in < testDegree + 1; in++) {
            float top;
            int i = in;

            if (i != 0 && Separate.getValue(values, i) != movingDegree) {
                top = 0;
                in--;
                testDegree--;

            } else {
                top = Separate.getKey(values, i);
            }

            if (i == 0 && !doneOne) {
                starting = 0;
                doneOne = true;
            }
            moving = top + starting;

            if (until < degree) {
                end.add(moving);
                bot.add(moving);
            } else {
                remainder = moving;
            }

            tp.add(top);
            mid.add(starting);



            starting = moving * toDivideBy;


            movingDegree--;

            until++;

            if (movingDegree < 0) {
                movingDegree = 0;
            }
        }

        String toop = "";
        String miid = "";
        String boot = "";
        String line = "--";

        for (float f : tp) {
            toop = toop + "  " + f;
            line = line + "------";
        }

        for (float f : mid) {
            miid = miid + "  " + f;
        }

        for (float f : bot) {
            boot = boot + "  " + f;
        }

        String fin = "";

        for (Float f : bot) {

            if (degree > 1) {
                degree--;
            }

            if (f > 0) {
                if (degree > 1) {
                    fin = fin + "+" + f + "x" + SuperScripts.getScriptForNumber(degree);
                } else {
                    if (fin.length() > 3 && !fin.substring(fin.length() - 3, fin.length()).contains("^") &&
                            !fin.substring(fin.length() - 2, fin.length()).contains("x")
                            ) {
                        fin = fin + "x+" + f;
                    } else {
                        fin = fin + "+" + f;

                    }
                }
            } else {
                if (degree > 1) {
                    fin = fin + f + "x" + SuperScripts.getScriptForNumber(degree);
                } else {
                    if (fin.length() > 3 && !fin.substring(fin.length() - 3, fin.length()).contains("^") &&
                            !fin.substring(fin.length() - 2, fin.length()).contains("x")
                            ) {
                        fin = fin + "x" + f;
                    } else {
                        fin = fin + "+" + f;

                    }
                }
            }
        }

        fin = fin + " Remainder: " + remainder;

        if (fin.substring(0, 1).equals("+")) {
            fin = fin.substring(1);
        }

        return fin;

    }

    public static float getRemainder(String original, String binomial) {

        LinkedList<LinkedHashMap<Float, Integer>> values = Separate.separate(original);
        int degree = Separate.getDegree(values);

        LinkedList<LinkedHashMap<Float, Integer>> binomialValues = Separate.separate(binomial);
        int binomialDegree = Separate.getDegree(binomialValues);


        float bime1 = Separate.getFirstKey(binomialValues.get(0));
        float bime1Exp = Separate.getFirstValue(binomialValues.get(0));
        float bime2 = Separate.getLastKey(binomialValues.get(1));
        float bime2Exp = Separate.getLastValue(binomialValues.get(1));
        if (bime2Exp == 0 && bime1Exp == 1) {
            float toDivideBy = -bime2 / bime1;

            float starting = Separate.getFirstKey(values.get(0));
            float moving;
            int movingDegree = degree;

            float remainder = 0;

            LinkedList<Float> end = new LinkedList<Float>();

            LinkedList<Float> tp = new LinkedList<Float>();
            LinkedList<Float> mid = new LinkedList<Float>();
            LinkedList<Float> bot = new LinkedList<Float>();

            Main.addToLabel(toDivideBy + ")");

            boolean doneOne = false;

            int testDegree = degree;

            int until = 0;

            for (int in = 0; in < testDegree + 1; in++) {
                float top;
                int i = in;

                if (i != 0 && Separate.getValue(values, i) != movingDegree) {
                    top = 0;
                    in--;
                    testDegree--;

                } else {
                    top = Separate.getKey(values, i);
                }

                if (i == 0 && !doneOne) {
                    starting = 0;
                    doneOne = true;
                }
                moving = top + starting;

                if (until < degree) {
                    end.add(moving);
                    bot.add(moving);
                } else {
                    remainder = moving;
                }

                tp.add(top);
                mid.add(starting);



                starting = moving * toDivideBy;


                movingDegree--;

                until++;

                if (movingDegree < 0) {
                    movingDegree = 0;
                }
            }

            String toop = "";
            String miid = "";
            String boot = "";
            String line = "--";

            for (float f : tp) {
                toop = toop + "  " + f;
                line = line + "------";
            }

            for (float f : mid) {
                miid = miid + "  " + f;
            }

            for (float f : bot) {
                boot = boot + "  " + f;
            }

            Main.addToLabel(toop);
            Main.addToLabel(miid);
            Main.addToLabel(line + "----");
            Main.addToLabel(boot + "  " + remainder);

            String fin = "";

            for (Float f : bot) {

                if (degree > 1) {
                    degree--;
                }

                if (f > 0) {
                    if (degree > 1) {
                        fin = fin + "+" + f + "x" + SuperScripts.getScriptForNumber(degree);
                    } else {
                        if (fin.length() > 3 && !fin.substring(fin.length() - 3, fin.length()).contains("^") &&
                                !fin.substring(fin.length() - 2, fin.length()).contains("x")
                                ) {
                            fin = fin + "x+" + f;
                        } else {
                            fin = fin + "+" + f;

                        }
                    }
                } else {
                    if (degree > 1) {
                        fin = fin + f + "x" + SuperScripts.getScriptForNumber(degree);
                    } else {
                        if (fin.length() > 3 && !fin.substring(fin.length() - 3, fin.length()).contains("^") &&
                                !fin.substring(fin.length() - 2, fin.length()).contains("x")
                                ) {
                            fin = fin + "x" + f;
                        } else {
                            fin = fin + "+" + f;

                        }
                    }
                }
            }

            fin = fin + " Remainder: " + remainder;

            if (fin.substring(0, 1).equals("+")) {
                fin = fin.substring(1);
            }

            Main.addToLabel("");

            return remainder;
        } else {
            return 1;
        }
    }

    public static float getRemainder(String original, float binomial) {

        LinkedList<LinkedHashMap<Float, Integer>> values = Separate.separate(original);
        int degree = Separate.getDegree(values);

        float toDivideBy = -binomial;

        float starting = Separate.getFirstKey(values.get(0));
        float moving;
        int movingDegree = degree;

        float remainder = 0;

        LinkedList<Float> end = new LinkedList<Float>();

        LinkedList<Float> tp = new LinkedList<Float>();
        LinkedList<Float> mid = new LinkedList<Float>();
        LinkedList<Float> bot = new LinkedList<Float>();

        Main.addToLabel(toDivideBy + ")");

        boolean doneOne = false;

        int testDegree = degree;

        int until = 0;

        for (int in = 0; in < testDegree + 1; in++) {
            float top;
            int i = in;

            if (i != 0 && Separate.getValue(values, i) != movingDegree) {
                top = 0;
                in--;
                testDegree--;

            } else {
                top = Separate.getKey(values, i);
            }

            if (i == 0 && !doneOne) {
                starting = 0;
                doneOne = true;
            }
            moving = top + starting;

            if (until < degree) {
                end.add(moving);
                bot.add(moving);
            } else {
                remainder = moving;
            }

            tp.add(top);
            mid.add(starting);



            starting = moving * toDivideBy;


            movingDegree--;

            until++;

            if (movingDegree < 0) {
                movingDegree = 0;
            }
        }

        String toop = "";
        String miid = "";
        String boot = "";
        String line = "--";

        for (float f : tp) {
            toop = toop + "  " + f;
            line = line + "------";
        }

        for (float f : mid) {
            miid = miid + "  " + f;
        }

        for (float f : bot) {
            boot = boot + "  " + f;
        }

        Main.addToLabel(toop);
        Main.addToLabel(miid);
        Main.addToLabel(line + "----");
        Main.addToLabel(boot + "  " + remainder);

        String fin = "";

        for (Float f : bot) {

            if (degree > 1) {
                degree--;
            }

            if (f > 0) {
                if (degree > 1) {
                    fin = fin + "+" + f + "x" + SuperScripts.getScriptForNumber(degree);
                } else {
                    if (fin.length() > 3 && !fin.substring(fin.length() - 3, fin.length()).contains("^") &&
                            !fin.substring(fin.length() - 2, fin.length()).contains("x")
                            ) {
                        fin = fin + "x+" + f;
                    } else {
                        fin = fin + "+" + f;

                    }
                }
            } else {
                if (degree > 1) {
                    fin = fin + f + "x" + SuperScripts.getScriptForNumber(degree);
                } else {
                    if (fin.length() > 3 && !fin.substring(fin.length() - 3, fin.length()).contains("^") &&
                            !fin.substring(fin.length() - 2, fin.length()).contains("x")
                            ) {
                        fin = fin + "x" + f;
                    } else {
                        fin = fin + "+" + f;

                    }
                }
            }
        }

        fin = fin + " Remainder: " + remainder;

        if (fin.substring(0, 1).equals("+")) {
            fin = fin.substring(1);
        }

        Main.addToLabel("");

        return remainder;

    }

    public static void makeSyntheticDivisionInterface() {

        Interface.mainInterface();

        panel = new JPanel(new BorderLayout(3, 225));

        JPanel pan = new JPanel();
        JLabel area = new JLabel("Synthetic Division");
        area.setBackground(Color.lightGray);
        area.setFont(new Font("Times New Roman", Font.BOLD, 20));
        pan.add(area, BorderLayout.CENTER);

        panel.add(pan, BorderLayout.NORTH);

        final JTextField field = new JTextField();
        panel.add(field, BorderLayout.CENTER);
        field.setFont(new Font("Times New Roman", Font.BOLD, 20));
        field.setText("3x^3-2x^2-7x+6");


        final JTextField bino = new JTextField();
        panel.add(bino, BorderLayout.AFTER_LINE_ENDS);
        bino.setFont(new Font("Times New Roman", Font.BOLD, 20));
        bino.setText("x+1");

        JButton start = new JButton("GO!");
        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.updateUI();
                Main.label.setText("");
                Main.addToLabel("Answer: " + doSyntheticDivision(field.getText(), bino.getText()));
            }
        });

        panel.add(start, BorderLayout.SOUTH);

        Main.getFrame().add(panel, BorderLayout.EAST);

        final Graphics g = panel.getGraphics().create();
        g.setFont(new Font("Times New Roman", Font.BOLD, 14));

        java.util.Timer timer = new java.util.Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                g.setColor(Color.black);
                g.drawString("Equation:", field.getX(), field.getY() - 5);
                g.drawString("Binomial:", bino.getX(), bino.getY() - 5);
            }
        }, 5L);
        Main.getFrame().pack();

    }

    public static void removeSyntheticDivisionInterface() {
        panel.removeAll();
        Main.getFrame().remove(panel);
        Main.getFrame().pack();
    }
}
