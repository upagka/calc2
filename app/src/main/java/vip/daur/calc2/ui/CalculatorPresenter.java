package vip.daur.calc2.ui;

import vip.daur.calc2.domain.Calculator;
import vip.daur.calc2.domain.Operation;

public class CalculatorPresenter {
    private CalculatorView view;
    private Calculator calculator;

    public CalculatorPresenter(CalculatorView view, Calculator calculator) {
        this.view = view;
        this.calculator = calculator;
    }

    public void onDotPressed() {
    }

    public void onDigitPressed(int digit) {
    }

    public void onOperandPressed(Operation operation) {
    }

    public void onClearPressed() {
    }

    public void onEqualsPressed() {
    }

    public void onBackspacePressed() {
    }
}
