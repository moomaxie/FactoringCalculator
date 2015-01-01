package max.hubbard.Factoring.Utils;

import java.util.*;
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
public class Separate {

    public static LinkedList<LinkedHashMap<Float, Integer>> separate(String equation) {
        LinkedList<LinkedHashMap<Float, Integer>> finals = new LinkedList<LinkedHashMap<Float, Integer>>();
        equation = equation.replaceAll(" ", "");
        equation = equation.replaceAll("-", "+-");

        String[] arr = equation.split(Pattern.quote("+"));

        String neweq = "";

        List<String> exp = new ArrayList<String>();

        for (String s : arr) {
            if (s.contains("^")) {
                if (s.split(Pattern.quote("^")).length > 1) {
                    exp.add(s.split(Pattern.quote("^"))[1]);
                }

                if (s.length() == 1 && s.contains("x")) {
                    s = 1 + s.split(Pattern.quote("^"))[0];
                } else {
                    s = s.split(Pattern.quote("^"))[0];
                }
            } else {
                if (s.contains("x")) {
                    exp.add("1");
                } else {
                    exp.add("0");
                }
            }

            if (s.equals("x")) {
                s = 1 + "x";
            }

            if (s.equals("-x")) {
                s = -1 + "x";
            }

            neweq = neweq + s;

        }

        String[] parts = neweq.split("([^\\d\\.\\+\\-])+");

        int amt = 0;


        for (String part : parts) {
            if (exp.size() > amt) {
                LinkedHashMap<Float, Integer> map = new LinkedHashMap<Float, Integer>();
                map.put(Float.parseFloat(part), Integer.parseInt(exp.get(amt)));
                finals.add(map);
                amt++;
            } else {
                LinkedHashMap<Float, Integer> map = new LinkedHashMap<Float, Integer>();
                map.put(Float.parseFloat(part), 1);
                finals.add(map);
            }
        }

        return finals;
    }

    public static int getDegree(LinkedList<LinkedHashMap<Float, Integer>> list) {
        int high = 1;
        for (LinkedHashMap<Float, Integer> map : list) {
            for (int i : map.values()) {
                if (i > high) {
                    high = i;
                }
            }
        }
        return high;
    }

    public static float getFirstKey(LinkedHashMap<Float, Integer> map) {
        final Set<Map.Entry<Float, Integer>> mapValues = map.entrySet();
        final int maplength = mapValues.size();
        final Map.Entry<Float, Integer>[] test = new Map.Entry[maplength];
        mapValues.toArray(test);

        return test[0].getKey();
    }

    public static float getFirstValue(LinkedHashMap<Float, Integer> map) {
        final Set<Map.Entry<Float, Integer>> mapValues = map.entrySet();
        final int maplength = mapValues.size();
        final Map.Entry<Float, Integer>[] test = new Map.Entry[maplength];
        mapValues.toArray(test);

        return test[0].getValue();
    }

    public static float getLastKey(LinkedHashMap<Float, Integer> map) {
        final Set<Map.Entry<Float, Integer>> mapValues = map.entrySet();
        final int maplength = mapValues.size();
        final Map.Entry<Float, Integer>[] test = new Map.Entry[maplength];
        mapValues.toArray(test);

        return test[maplength - 1].getKey();
    }

    public static float getLastValue(LinkedHashMap<Float, Integer> map) {
        final Set<Map.Entry<Float, Integer>> mapValues = map.entrySet();
        final int maplength = mapValues.size();
        final Map.Entry<Float, Integer>[] test = new Map.Entry[maplength];
        mapValues.toArray(test);

        return test[maplength - 1].getValue();
    }

    public static float getKey(LinkedList<LinkedHashMap<Float, Integer>> map, int num) {
        try {
            final Set<Map.Entry<Float, Integer>> mapValues = map.get(num).entrySet();
            final int maplength = mapValues.size();
            final Map.Entry<Float, Integer>[] test = new Map.Entry[maplength];
            mapValues.toArray(test);

            return test[0].getKey();
        } catch (Exception ignored) {
            return 0;
        }
    }

    public static float getValue(LinkedList<LinkedHashMap<Float, Integer>> map, int num) {
        try {
            final Set<Map.Entry<Float, Integer>> mapValues = map.get(num).entrySet();
            final int maplength = mapValues.size();
            final Map.Entry<Float, Integer>[] test = new Map.Entry[maplength];
            mapValues.toArray(test);

            return test[0].getValue();
        } catch (Exception ignored) {
            return 0;
        }
    }

}
