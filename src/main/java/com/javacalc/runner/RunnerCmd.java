package main.java.com.javacalc.runner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import main.java.com.javacalc.core.CoreCalc;
import main.java.com.javacalc.core.TokensList;

public class RunnerCmd {
    public static void main(String[] args) {
        String in = "2+2+2";
        String s= "12/43*(44-14/24)";
        System.out.println(Arrays.toString(s.split("(\\*|-|\\+|/)")));
        System.out.println(Arrays.toString(s.split("(\\(?\\d+\\.?\\d+\\)?)|\\d")));
        System.out.println(Arrays.toString(CoreCalc.arrayTokens(s)));

        List<String> list = new TokensList<>(Arrays.asList(new String[]{"2","+","2","*","2"}));
        System.out.println(list.toString());
        ;
        System.out.println(s);
    }

}
