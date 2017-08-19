package main.java.com.javacalc.runner;

import java.util.Arrays;

import main.java.com.javacalc.core.CoreCalc;

public class RunnerCmd {
    public static void main(String[] args) {
        String in = "2+2+2";
        String s= "12*3-4+342/2.54+(232-232*2323)";
        System.out.println(Arrays.toString(s.split("(\\*|-|\\+|/)")));
        System.out.println(Arrays.toString(s.split("[\\*\\+/-]")));
        System.out.println(Arrays.toString(CoreCalc.arrayTokens(s)));


        System.out.println(s);
    }

}
