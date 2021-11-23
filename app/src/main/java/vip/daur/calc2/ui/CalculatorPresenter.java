package vip.daur.calc2.ui;

import static java.lang.Math.pow;
import static java.lang.Math.round;

import vip.daur.calc2.domain.Calculator;
import vip.daur.calc2.domain.Operation;

public class CalculatorPresenter {
    private CalculatorView view;
    private Calculator calculator;

    private Double argOne = 0.0;
    private Double argTwo = null;
    private Operation previousOperation = null;
    private int shift = 0;


    public CalculatorPresenter(CalculatorView view, Calculator calculator) {
        this.view = view;
        this.calculator = calculator;
    }

    public void onDotPressed() {
        if (shift == 0){
            shift = 1;
        }
    }

    public void onDigitPressed(int digit) {
        if (previousOperation != null) {
            argTwo = addDigit(argTwo, digit);
            view.showResult(String.valueOf(argTwo));
        } else {
            argOne = addDigit(argOne, digit);
            view.showResult(String.valueOf(argOne));
        }
    }

    private double addDigit(Double arg, int digit) {
        double newArg;
        if (shift == 0) {
            newArg = arg * 10 + digit;
        } else {
            newArg = arg + digit / (pow(10, shift));
            shift++;
        }
        return newArg;
    }


    public void onOperandPressed(Operation operation) {
        if (argTwo != null) {
            double result = calculator.performOperation(argOne, argTwo, previousOperation);
            view.showResult(String.valueOf(result));
            argOne = result;
        }
        shift = 0;
        argTwo = 0.0;
        previousOperation = operation;
    }

    public void onClearPressed() {
    }

    public void onEqualsPressed() {
    }

    public void onBackspacePressed() {
    }
}
