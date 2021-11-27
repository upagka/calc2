package vip.daur.calc2.ui;

import static java.lang.Math.pow;
import static java.lang.Math.round;

import vip.daur.calc2.domain.Calculator;
import vip.daur.calc2.domain.Operation;

public class CalculatorPresenter {
    private static CalculatorView view;
    private Calculator calculator;

    private static int afterEquals = 0;
    private final int MAX_LENGTH = 20;
    private static Double argOne = 0.0;
    private static Double argTwo = null;
    private static String inputNumber = "0";
    private static String currentNumber = "0";
    private static Operation previousOperation = null;


    public CalculatorPresenter(CalculatorView view, Calculator calculator) {
        this.view = view;
        this.calculator = calculator;
    }
    public CalculatorPresenter(CalculatorView view, Calculator calculator, State state) {
        this.view = view;
        this.calculator = calculator;
        argOne = state.getArgOne();
        inputNumber = state.getInputNumber();
        previousOperation = state.getPreviousOperation();
        afterEquals = state.afterEquals;
        currentNumber = state.getCurrentNumber();
        view.showResult(currentNumber);
    }

    public void onDotPressed() {
        afterEquals = 0;
        if (inputNumber.indexOf('.') == -1) {
            inputNumber += ".";
            view.showResult(inputNumber);
        }
    }

    public void onDigitPressed(String digit) {
        afterEquals = 0;
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
            if (afterEquals == 0) {
                argOne = Double.parseDouble(inputNumber);
            }
            argTwo = 0.0;
        } else if (inputNumber != "0") {
            argTwo = Double.parseDouble(inputNumber);
            double result = calculator.performOperation(argOne, argTwo, previousOperation);
            currentNumber = Double.toString(result);
            view.showResult(currentNumber);
            argOne = result;
        }
        inputNumber = "0";
        previousOperation = operation;
    }

    public void onClearPressed() {
        afterEquals = 0;
        argTwo = null;
        previousOperation = null;
        inputNumber = "0";
        view.showResult(inputNumber);
    }

    public void onEqualsPressed() {
        onOperandPressed(Operation.SUM);
        argTwo = null;
        previousOperation = null;
        afterEquals = 1;
    }

    public void onBackspacePressed() {
        afterEquals = 0;
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

    public static State getState() {
        State currentState = new State(0);
        currentState.setArgOne(argOne);
        currentState.setAfterEquals(afterEquals);
        currentState.setInputNumber(inputNumber);
        currentState.setPreviousOperation(previousOperation);
        currentState.setCurrentNumber(currentNumber);
        return currentState;
    }

}
