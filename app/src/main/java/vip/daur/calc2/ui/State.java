package vip.daur.calc2.ui;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.RequiresApi;

import vip.daur.calc2.domain.Operation;

public class State implements Parcelable {


    private double argOne;
    private String inputNumber;
    public int afterEquals;
    private Operation previousOperation;

    public String getCurrentNumber() {
        return currentNumber;
    }

    public void setCurrentNumber(String currentNumber) {
        this.currentNumber = currentNumber;
    }

    private String currentNumber;


    public double getArgOne() {
        return argOne;
    }

    public String getInputNumber() {
        return inputNumber;
    }

    public Operation getPreviousOperation() {
        return previousOperation;
    }

    public void setArgOne(double argOne) {
        this.argOne = argOne;
    }

    public void setInputNumber(String inputNumber) {
        this.inputNumber = inputNumber;
    }

    public void setAfterEquals(int afterEquals) {
        this.afterEquals = afterEquals;
    }

    public void setPreviousOperation(Operation previousOperation) {
        this.previousOperation = previousOperation;
    }


    public State(int value) {
        this.argOne = value;
//        this.inputNumber = inputNumber;
//        this.afterEquals = afterEquals;
//        this.previousOperation = previousOperation;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    protected State(Parcel in) {
        argOne = in.readDouble();
        inputNumber = in.readString();
        afterEquals = in.readInt();
        previousOperation = (Operation) in.readSerializable();
        currentNumber = in.readString();
    }

    public static final Creator<State> CREATOR = new Creator<State>() {
        @RequiresApi(api = Build.VERSION_CODES.Q)
        @Override
        public State createFromParcel(Parcel in) {
            return new State(in);
        }

        @Override
        public State[] newArray(int size) {
            return new State[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeDouble(argOne);
        dest.writeString(inputNumber);
        dest.writeInt(afterEquals);
        dest.writeSerializable(previousOperation);
        dest.writeSerializable(currentNumber);
    }
}
