package vip.daur.calc2.ui;

import static java.lang.Math.pow;
import static java.lang.Math.round;

import vip.daur.calc2.domain.Calculator;
import vip.daur.calc2.domain.Operation;

public class CalculatorPresenter {
    private CalculatorView view;
    private Calculator calculator;

    private boolean afterEquals = false;
    private final int MAX_LENGTH = 20;
    private Double argOne = 0.0;
    private Double argTwo = null;
    private String inputNumber = "0";
    private Operation previousOperation = null;


    public CalculatorPresenter(CalculatorView view, Calculator calculator) {
        this.view = view;
        this.calculator = calculator;
    }

    public void onDotPressed() {
        afterEquals = false;
        if (inputNumber.indexOf('.') == -1) {
            inputNumber += ".";
            view.showResult(inputNumber);
        }
    }

    public void onDigitPressed(String digit) {
        afterEquals = false;
        if (inputNumber.length() <= MAX_LENGTH) {
            if (inputNumber != "0") {
                inputNumber += digit;
            } else {
                inputNumber = digit;
            }
            view.showResult(inputNumber);
        }
    }

    public void onOperandPressed(Operation operation) {
        if (argTwo == null) {
            if (afterEquals == false) {
                argOne = Double.parseDouble(inputNumber);
            }
            argTwo = 0.0;
        } else if (inputNumber != "0") {
            argTwo = Double.parseDouble(inputNumber);
            double result = calculator.performOperation(argOne, argTwo, previousOperation);
            view.showResult(Double.toString(result));
            argOne = result;
        }
        inputNumber = "0";
        previousOperation = operation;
    }

    public void onClearPressed() {
        afterEquals = false;
        argTwo = null;
        previousOperation = null;
        inputNumber = "0";
        view.showResult(inputNumber);
    }

    public void onEqualsPressed() {
        onOperandPressed(Operation.SUM);
        argTwo = null;
        previousOperation = null;
        afterEquals = true;
    }

    public void onBackspacePressed() {
        afterEquals = false;
        if (inputNumber != "0") {
            if (inputNumber.length() > 1) {
                inputNumber = inputNumber.substring(0, inputNumber.length() - 1);
                view.showResult(inputNumber);
            } else {
                inputNumber = "0";
                view.showResult(inputNumber);
            }
        }
    }
}
