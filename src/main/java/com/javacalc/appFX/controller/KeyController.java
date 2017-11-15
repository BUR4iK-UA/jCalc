package main.java.com.javacalc.appFX.controller;

import java.util.LinkedList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import main.java.com.javacalc.core.CoreCalc;
import main.java.com.javacalc.core.TokensList;
import main.java.com.javacalc.core.SimpleCalculator2;

public class KeyController {

    @FXML
    private TextArea areaExpression;

    @FXML
    private Label areaResult;


//util.isOprerator(expression.get(expression.size()-1))

    List<String> expression = new TokensList<>();
    //List<String> expression = new LinkedList<>();
    CoreCalc util = new CoreCalc();
    SimpleCalculator2 calculator = new SimpleCalculator2();

    @FXML
    private void onActionNumberKeys(ActionEvent actionEvent) {
        Button currentBtn = (Button) actionEvent.getSource();
        String currentNumber = currentBtn.getText();
        if (expression.isEmpty()) {
            expression.add(currentNumber);
        } else if (!util.isOprerator(expression.get(expression.size() - 1))) {
            expression.set(expression.size() - 1, expression.get(expression.size() - 1).concat(currentNumber));
        } else {
            expression.add(currentNumber);
        }
        areaExpression.setText(expression.toString());
        areaResult.setText(Double.toString(calculator.doMath(new LinkedList<>(expression))));
    }


    public void keyMultiply(ActionEvent actionEvent) {
        expression.add("*");
        areaExpression.setText(expression.toString());
    }

    public void keyDivide(ActionEvent actionEvent) {
        expression.add("/");
        areaExpression.setText(expression.toString());
    }

    public void keyPlus(ActionEvent actionEvent) {
        expression.add("+");
        areaExpression.setText(expression.toString());
    }

    public void keyMinus(ActionEvent actionEvent) {
        expression.add("-");
        areaExpression.setText(expression.toString());
    }


    public void clearExpression(ActionEvent actionEvent) {
        expression = new TokensList<>();
        areaExpression.setText("");
        areaResult.setText("");
    }

    public void delOneSimbol(ActionEvent actionEvent) {
    }
}
