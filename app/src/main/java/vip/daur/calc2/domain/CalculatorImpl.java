package vip.daur.calc2.domain;

public class CalculatorImpl implements Calculator {

    @Override
    public double performOperation(double argOne, double argTwo, Operation operation) {
        if (operation == Operation.SUM) {
            return argOne + argTwo;
        }

        if (operation == Operation.SUB) {
            return argOne - argTwo;
        }

        if (operation == Operation.MULTI) {
            return argOne * argTwo;
        }

        if (operation == Operation.DIV) {
            return argOne / argTwo;
        }
        return 0;
    }
}
