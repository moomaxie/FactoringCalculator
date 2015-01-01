package max.hubbard.Factoring;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

/**
 * ***********************************************************************
 * Copyright Max Hubbard (c) 2014. All Rights Reserved.
 * Any code contained within this document, and any associated documents with similar branding
 * are the sole property of Max. Distribution, reproduction, taking snippets, or
 * claiming any contents as your own will break the terms of the license, and void any
 * agreements with you, the third party.
 * ************************************************************************
 */
public class Factor {

    // x^2 + 6x - 27
    // 2x^2 - 18x - 72
    // 4x^2 + 5x + 1
    // 6x^2 + 24x - 270

    public static JPanel panel = new JPanel(new BorderLayout(0, 225));

    public static String factorForThree(String first, String second, String third) throws Exception {
        if (first.contains("^2")) {
            String firstInt = "1";
            String secondInt = "1";
            String thirdInt = "1";

            String variable = first.substring(0, first.length() - 2).replaceAll("\\d", "");

            if (containsDigit(first)) {

                if (!first.substring(0, first.length() - 2).replaceAll("\\D+", "").equals("")) {
                    if (!first.substring(0, first.length() - 2).replaceAll("\\D+", "").equals("-")) {
                        firstInt = first.substring(0, first.length() - 2).replaceAll("\\D+", "");
                    } else {
                        firstInt = "-1";
                    }
                }
            }


            if (containsDigit(second)) {
                if (second.contains("-")) {
                    secondInt = second.replaceAll("\\D+", "");
                    secondInt = "-" + secondInt;
                } else {
                    secondInt = second.replaceAll("\\D+", "");
                }
            }

            if (containsDigit(third)) {

                if (third.contains("-")) {
                    thirdInt = third.replaceAll("\\D+", "");
                    thirdInt = "-" + thirdInt;
                } else {
                    thirdInt = third.replaceAll("\\D+", "");
                }
            }

            int fNum = Integer.parseInt(firstInt);
            int addTo = Integer.parseInt(secondInt);
            int tNum = Integer.parseInt(thirdInt);


            int multiTo = tNum;


            if (fNum == 1) {

                Main.addToLabel(" ");
                Map<Integer, Integer> factors = getFactors(multiTo);

                Main.addToLabel("Multiply to: " + multiTo);
                Main.addToLabel("Add to: " + addTo);

                Main.addToLabel(" ");

                Main.addToLabel("Factors of " + multiTo + ":");

                int newI = 1;
                int newX = 1;

                for (int i : factors.keySet()) {
                    int x = factors.get(i);

                    Main.addToLabel(i + " & " + x);



                    if ((i + x) == addTo) {
                        if (i > 0) {
                            if (x > 0) {
                                newI = i;
                                newX = x;
                            } else {
                                newI = i;
                                newX = -x;
                            }
                        } else {
                            if (x > 0) {
                                newI = -i;
                                newX = x;
                            } else {
                                newI = -i;
                                newX = -x;
                            }
                        }
                    }

                    if ((-i + x) == addTo) {
                        if (-i > 0) {
                            if (x > 0) {
                                newI = i;
                                newX = x;
                            } else {
                                newI = i;
                                newX = -x;
                            }
                        } else {
                            if (x > 0) {
                                newI = -i;
                                newX = x;
                            } else {
                                newI = -i;
                                newX = -x;
                            }
                        }
                    }

                    if ((i - x) == addTo) {
                        if (i > 0) {
                            if (-x > 0) {
                                newI = i;
                                newX = x;
                            } else {
                                newI = i;
                                newX = -x;
                            }
                        } else {
                            if (-x > 0) {
                                newI = -i;
                                newX = x;
                            } else {
                                newI = -i;
                                newX = -x;
                            }
                        }
                    }

                    if ((-i - x) == addTo) {
                        if (-i > 0) {
                            if (-x > 0) {
                                newI = i;
                                newX = x;
                            } else {
                                newI = i;
                                newX = -x;
                            }
                        } else {
                            if (-x > 0) {
                                newI = -i;
                                newX = x;
                            } else {
                                newI = -i;
                                newX = -x;
                            }
                        }
                    }
                }

                if (newI + newX == addTo && newI * newX == multiTo) {


                    Main.addToLabel(" ");
                    Main.addToLabel("Add to " + addTo);
                    Main.addToLabel(newI + " + " + newX + " = " + (newI + newX));
                    Main.addToLabel(" ");
                    Main.addToLabel("Multiply to " + multiTo);
                    Main.addToLabel(newI + " x " + newX + " = " + (newI * newX));

                    Main.addToLabel(" ");

                    return "(" + variable + " + " + newI + ") (" + variable + " + " + newX + ")";
                } else {
                    Main.addToLabel("Cannot Factor. No two factors can work.");
                }
            } else {
                multiTo = fNum * tNum;

                Main.addToLabel(fNum + " x " + tNum + " = " + multiTo);

                Map<Integer, Integer> factors = getFactors(multiTo);

                int newI = 1;
                int newX = 1;

                Main.addToLabel(" ");

                Main.addToLabel("Factors of " + multiTo + ":");

                for (int i : factors.keySet()) {
                    int x = factors.get(i);

                    Main.addToLabel(i + " & " + x);

                    if ((i + x) == addTo) {

                        if (i > 0) {
                            if (x > 0) {
                                newI = i;
                                newX = x;
                            } else {
                                newI = i;
                                newX = -x;
                            }
                        } else {
                            if (x > 0) {
                                newI = -i;
                                newX = x;
                            } else {
                                newI = -i;
                                newX = -x;
                            }
                        }
                    }

                    if ((-i + x) == addTo) {
                        if (-i > 0) {
                            if (x > 0) {
                                newI = i;
                                newX = x;
                            } else {
                                newI = i;
                                newX = -x;
                            }
                        } else {
                            if (x > 0) {
                                newI = -i;
                                newX = x;
                            } else {
                                newI = -i;
                                newX = -x;
                            }
                        }
                    }

                    if ((i - x) == addTo) {
                        if (i > 0) {
                            if (-x > 0) {
                                newI = i;
                                newX = x;
                            } else {
                                newI = i;
                                newX = -x;
                            }
                        } else {
                            if (-x > 0) {
                                newI = -i;
                                newX = x;
                            } else {
                                newI = -i;
                                newX = -x;
                            }
                        }
                    }

                    if ((-i - x) == addTo) {
                        if (-i > 0) {
                            if (-x > 0) {
                                newI = i;
                                newX = x;
                            } else {
                                newI = i;
                                newX = -x;
                            }
                        } else {
                            if (-x > 0) {
                                newI = -i;
                                newX = x;
                            } else {
                                newI = -i;
                                newX = -x;
                            }
                        }
                    }
                }

                if (newI + newX == addTo && newI * newX == multiTo) {


                    Main.addToLabel(" ");
                    Main.addToLabel("Add to " + addTo);
                    Main.addToLabel(newI + " + " + newX + " = " + (newI + newX));
                    Main.addToLabel(" ");
                    Main.addToLabel("Multiply to " + multiTo);
                    Main.addToLabel(newI + " x " + newX + " = " + (newI * newX));

                    Main.addToLabel(" ");

                    String fullEquation = first + " + " + newI + variable + " + " + newX + variable + " + " + third;

                    Main.addToLabel("New Equation: " + fullEquation);

                    Main.addToLabel(" ");


                    String[] spl = fullEquation.split(" ");

                    String f = spl[0];
                    String s = spl[2];

                    String t = spl[4];
                    String fth = spl[6];

                    f = f.substring(0, f.length() - 2);
                    f = f.substring(0, f.length() - variable.length());

                    int fint = Integer.parseInt(f);

                    s = s.substring(0, s.length() - variable.length());

                    int sint = Integer.parseInt(s);

                    int gcf = gcf(fint, sint);

                    Main.addToLabel("GCF of " + first + " and " + s + variable + " is " + gcf + variable);

                    t = t.substring(0, t.length() - variable.length());

                    int tint = Integer.parseInt(t);
                    int fthint = Integer.parseInt(fth);

                    int gcf2 = gcf(tint, fthint);

                    Main.addToLabel(" ");

                    Main.addToLabel("GCF of " + t + variable + " and " + third + " is " + gcf2);

                    Main.addToLabel(" ");


                    int z = tint / gcf2;
                    int i = fthint / gcf2;

                    Main.addToLabel(gcf + variable + "(" + z + variable + " + " + i + ") " + gcf2 + "(" + z + variable + " + " + i + ")");

                    Main.addToLabel(" ");

                    int gcf3 = gcf(gcf,gcf2);

                    int d = gcf / gcf3;
                    int j = gcf2 / gcf3
;
                    if (gcf3 == 1) {
                        return "(" + d + variable + " + " + j + ") (" + z + variable + " + " + i + ")";
                    } else {

                        Main.addToLabel("(" + gcf + variable + " + " + gcf2 + ") (" + z + variable + " + " + i + ")");

                        Main.addToLabel(" ");
                        Main.addToLabel("Simplify:");

                        Main.addToLabel("The GCF of " + gcf + variable + " and " + gcf2 + " is " + gcf3);

                        Main.addToLabel(" ");
                        Main.addToLabel(gcf3+ "(" + d + variable + " + " + j + ")");

                        Main.addToLabel(" ");

                        return gcf3+ "(" + d + variable + " + " + j + ") (" + z + variable + " + " + i + ")";
                    }
                } else {
                    Main.addToLabel("Cannot Factor. No two factors can work.");
                }
            }

        }

        return "Do you even Factor?";

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

    public static Map<Integer, Integer> getFactors(int number) {
        int factorNumber = 1;

        number = Math.abs(number);

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        while (factorNumber <= number) {
            if (number % factorNumber == 0) {
                map.put(factorNumber, number / factorNumber);
            }
            factorNumber++;
        }
        return map;
    }


    private static int gcf(int i, int j) {
        return (j == 0) ? i : gcf(j, i % j);
    }

    public static void makeQuadraticFactorInterface() {

        Interface.mainInterface();

        panel = new JPanel(new BorderLayout(0, 225));

        JPanel pan = new JPanel();
        JLabel are = new JLabel("Quadratic Factoring: ax² + bx + c");
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
                    String fac = factorForThree(area.getText() + "x^2", field.getText() + "x", ar.getText());
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

    public static void removeQuadraticFactorInterface() {
        panel.removeAll();
        Main.getFrame().remove(panel);
        Main.getFrame().pack();
    }
}
