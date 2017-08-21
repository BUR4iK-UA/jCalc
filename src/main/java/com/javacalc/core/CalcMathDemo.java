/*
 * Copyright (c) 2017. All rights reserved.
 * Ivan Dmytryshyn PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package main.java.com.javacalc.core;

/**
 * The class {@code CalcMathDemo} contains methods for performing basic
 * numeric operations and to take a random expression for test the main
 * functionality of the project. ...
 *
 * @author  Ivan Dmytryshyn
 * @since   JDK8.0
 */

public final class CalcMathDemo {

    /**
     * ...
     *
     * @param arg1
     * @param arg2
     * @param op
     * @return
     */
    public static
    double getResult(double arg1, double arg2, char op) {
        double result = 0.0;
        switch (op) {
            case '+' :
                result = arg1 + arg2;
                break;
            case '-' :
                result = arg1 - arg2;
                break;
            case '*' :
                result = arg1 * arg2;
                break;
            case '/' :
                if (arg2 != 0) {
                    result = arg1 / arg2;
                    break;
                } else {
                    System.err.println("Cannot divide by zero");
                    return Double.NaN;
                }
            default:
                System.err.println("Wrong operation exception");
        }
        return result;
    }
}
