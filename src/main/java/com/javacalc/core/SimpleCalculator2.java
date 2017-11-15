package main.java.com.javacalc.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SimpleCalculator2 {

    public static void main(String[] args) {

        boolean again = true;
        double answer = 0.0;
        double results = 0.0;
        String delims = "[ ]+";
        //String input = "1000/67+(9484-4948)";
       // System.out.println("This is the user's input:\n" + input);

        //Parses string into array list
       //System.out.println(Arrays.toString(input.split(delims)));
       //List<String> list = new ArrayList<String>(Arrays.asList(CoreCalc.arrayTokens(input)));
        //List<String> list = new ArrayList<String>(Arrays.asList(new String[]{"323","*","(","3234","-","(","3","+","3",")","*","6",")"}));
        List<String> list = new ArrayList<String>(Arrays.asList(new String[]{"3","+","sqr","(","2","+","1",")","*","3"}));
        System.out.println("list: " + list + new SimpleCalculator2().getCurrentOp(list)+"  "+ new SimpleCalculator2().getLastOp(list));

       results =  new SimpleCalculator2().doMath(list);
        //List<String> sublistWithInput = new SimpleCalculator2().getSublistWithInput(list);
        //System.out.println(sublistWithInput);
        System.out.println(list);


        getResults(results);


    }

    public void math(List<String> list){

    }

    private int getPriorityOp(String op) {
        int res;
        switch (op) {
            case "+":
                res = 0;
                break;
            case "-":
                res = 0;
                break;
            case "*":
                res = 1;
                break;
            case "/":
                res = 1;
                break;
            case "sqr":
                res = 2;
                break;
            default:
                /*if (op.matches("(\\(\\-?\\d+\\.?\\d+)|\\(\\d")) {
                    return 2;
                }*/
                return -1;
        }
        return res;
    }


    public double doMath(List<String> list) {
        double number1 = 0.0;
        double number2 = 0.0;
        double answer = 0.0;
        for (int i = 0; i < list.size(); i++) {
            //for
            if (list.get(i).matches("\\(")) {
                doMath(getSublistWithInput(list));
            }
        }


             System.out.println(list);
            while (list.size() > 1) {
                int currentOp = getCurrentOp(list);
                //while
                System.out.println(currentOp + " index op\n");
                switch (list.get(currentOp)) {
                    case "*":
                        number1 = Double.parseDouble(list.get(currentOp - 1));
                        number2 = Double.parseDouble(list.get(currentOp + 1));
                        answer = number1 * number2;
                        list.add(currentOp - 1, Double.toString(answer));
                        list.subList(currentOp, currentOp + 3).clear();
                        System.out.println(list);
                        break;
                    case "/":
                        number1 = Double.parseDouble(list.get(currentOp - 1));
                        number2 = Double.parseDouble(list.get(currentOp + 1));
                        answer = number1 / number2;
                        list.add(currentOp - 1, Double.toString(answer));
                        list.subList(currentOp, currentOp + 3).clear();
                        System.out.println(list);
                        break;
                    case "+":
                        number1 = Double.parseDouble(list.get(currentOp - 1));
                        number2 = Double.parseDouble(list.get(currentOp + 1));
                        answer = number1 + number2;
                        list.add(currentOp - 1, Double.toString(answer));
                        list.subList(currentOp, currentOp + 3).clear();
                        System.out.println(list);
                        break;
                    case "-":
                        number1 = Double.parseDouble(list.get(currentOp - 1));
                        number2 = Double.parseDouble(list.get(currentOp + 1));
                        answer = number1 - number2;
                        list.add(currentOp - 1, Double.toString(answer));
                        list.subList(currentOp, currentOp + 3).clear();
                        System.out.println(list);
                        break;
                    case "sqr":
                        answer = Math.pow(Double.parseDouble(list.get(currentOp+1)),2);
                        list.add(currentOp , Double.toString(answer));
                        list.subList(currentOp+1,currentOp+3).clear();
                        System.out.println("");
                        break;
                }

            }
        return answer;
    }

    public int getCurrentOp(List <String> list){
        int currentOp = 0;
        for (int i = 0; i < list.size(); i++) {
            //for
            /*if (list.get(i).matches("(\\-?\\d+\\.?\\d+\\))|\\d")) {
                System.err.println(list.get(i));
            }*/
            if (getPriorityOp(list.get(currentOp)) < getPriorityOp(list.get(i))) {
                currentOp = i;
            }
        }
        return currentOp;
    }

    public int getLastOp(List<String> list) {
        int lastOp = getCurrentOp(list);
        int currentOp = lastOp;

        if (list.get(currentOp).matches("(\\(\\-?\\d+\\.?\\d+)|\\d")) {
            for (int i = list.size() - 1; i > currentOp; i--) {
                if (list.get(i).matches("(\\-?\\d+\\.?\\d+\\))|\\d")) {
                    lastOp = i;
                    return lastOp;
                }
            }
        }
        return lastOp;
    }

    public List<String> getSublistWithInput(List<String> listInput){
        int  firstBracket = 0;
        int lastBracket = listInput.size()-1;
        for (int i = 0; i < listInput.size(); i++) {
            //for
            if (listInput.get(i).matches("\\(")) {
                firstBracket = i;
                listInput.remove(firstBracket);
                break;


            }
        }

        for (int i = listInput.size() - 1; i > firstBracket; i--) {
            if (listInput.get(i).matches("\\)")) {
                lastBracket = i;
                listInput.remove(lastBracket);
                break;

            }
        }


        return listInput.subList(firstBracket,lastBracket);
    }

    public static void getResults(double results) {
        System.out.println("Results are: " + results);
    }
}