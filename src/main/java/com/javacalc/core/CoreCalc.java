package main.java.com.javacalc.core;

public class CoreCalc {
    public static String[] arrayTokens(String s){
        String[] numb  = s.split("[\\*\\+/-]");
        String[] symbol = s.split("(\\(?\\d+\\.?\\d+\\)?)|\\d");
        String[] res = new String[numb.length+symbol.length-1];
        for (int i =0,j = 0; i < numb.length;){
            res[j] = numb[i];
            i++;
            j++;
            if(i< symbol.length)res[j] = symbol[i];
            j++;
        }

        return res;
    }
}
