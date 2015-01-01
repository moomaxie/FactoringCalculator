package max.hubbard.Factoring.Utils;

/**
 * ***********************************************************************
 * Copyright Max Hubbard (c) 2014. All Rights Reserved.
 * Any code contained within this document, and any associated documents with similar branding
 * are the sole property of Max. Distribution, reproduction, taking snippets, or
 * claiming any contents as your own will break the terms of the license, and void any
 * agreements with you, the third party.
 * ************************************************************************
 */
public class SuperScripts {

    public static String getZero(){
        return "\u00B0";
    }

    public static String getOne(){
        return "\u00B9";
    }

    public static String getTwo(){
        return "\u00B2";
    }

    public static String getThree(){
        return "\u00B3";
    }

    public static String getFour(){
        return "^4";
    }

    public static String getFive(){
        return "^5";
    }

    public static String getSix(){
        return "^6";
    }

    public static String getSeven(){
        return "^7";
    }

    public static String getEight(){
        return "^8";
    }

    public static String getNine(){
        return "^9";
    }

    public static String getScriptForNumber(int num) {

        String re = "";
        String number = String.valueOf(num);

        String[] digits2 = number.split("(?<=.)");

        for (String s : digits2) {
            int n = Integer.parseInt(s);

            if (n == 0) {
                re = re +  getZero();
            }
            if (n == 1) {
                re = re +  getOne();
            }
            if (n == 2) {
                re = re +  getTwo();
            }
            if (n == 3) {
                re = re +  getThree();
            }
            if (n == 4) {
                re = re +  getFour();
            }
            if (n == 5) {
                re = re +  getFive();
            }
            if (n == 6) {
                re = re +  getSix();
            }
            if (n == 7) {
                re = re +  getSeven();
            }
            if (n == 8) {
                re = re +  getEight();
            }
            if (n == 9) {
                re = re +  getNine();
            }

        }
        return re;
    }
}
