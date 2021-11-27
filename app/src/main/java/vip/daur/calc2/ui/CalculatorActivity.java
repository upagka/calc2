package vip.daur.calc2.ui;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.HashMap;

import vip.daur.calc2.R;
import vip.daur.calc2.domain.*;


public class CalculatorActivity extends AppCompatActivity implements CalculatorView {

    private TextView txtResult;
    private CalculatorPresenter presenter;
    private State currentState = new State(0);

    private static final String ARG_STATE = "ARG_STATE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        txtResult = findViewById(R.id.result);


        if (savedInstanceState == null) {
            presenter = new CalculatorPresenter(this, new CalculatorImpl());
        } else {
            currentState = savedInstanceState.getParcelable(ARG_STATE);
            presenter = new CalculatorPresenter(this, new CalculatorImpl(), currentState);
        }



        createSelectThemeClickListener();
        createDigitClickListener();
        createDotClickListener();
        createOperandClickListener();
        createClearClickListener();
        createBackspaceClickListener();
        createEqualsClickListener();

    }

    private void createBackspaceClickListener() {
        findViewById(R.id.key_backspace).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onBackspacePressed();
            }
        });
    }

    private void createEqualsClickListener() {
        findViewById(R.id.key_equals).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onEqualsPressed();
            }
        });
    }

    private void createClearClickListener() {
        findViewById(R.id.key_clear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onClearPressed();
            }
        });
    }

    private void createSelectThemeClickListener() {
        findViewById(R.id.key_select_theme).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectTheme();
            }
        });
    }

    private void createDotClickListener() {
        findViewById(R.id.key_dot).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onDotPressed();
            }
        });
    }

    public void selectTheme() {
        Intent intent = new Intent(this, SelectThemeActivity.class);
        startActivity(intent);
    }

    private void createOperandClickListener() {
        HashMap<Integer, Operation> operands = new HashMap<>();
        operands.put(R.id.key_plus, Operation.SUM);
        operands.put(R.id.key_minus, Operation.SUB);
        operands.put(R.id.key_multi, Operation.MULTI);
        operands.put(R.id.key_div, Operation.DIV);

        View.OnClickListener operandClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onOperandPressed(operands.get(v.getId()));
            }
        };

        findViewById(R.id.key_plus).setOnClickListener(operandClickListener);
        findViewById(R.id.key_minus).setOnClickListener(operandClickListener);
        findViewById(R.id.key_multi).setOnClickListener(operandClickListener);
        findViewById(R.id.key_div).setOnClickListener(operandClickListener);
    }

    private void createDigitClickListener() {
        HashMap<Integer, String> digits = new HashMap<>();
        digits.put(R.id.key_0, "0");
        digits.put(R.id.key_1, "1");
        digits.put(R.id.key_2, "2");
        digits.put(R.id.key_3, "3");
        digits.put(R.id.key_4, "4");
        digits.put(R.id.key_5, "5");
        digits.put(R.id.key_6, "6");
        digits.put(R.id.key_7, "7");
        digits.put(R.id.key_8, "8");
        digits.put(R.id.key_9, "9");

        View.OnClickListener digitClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.onDigitPressed(digits.get(v.getId()));
            }
        };

        findViewById(R.id.key_0).setOnClickListener(digitClickListener);
        findViewById(R.id.key_1).setOnClickListener(digitClickListener);
        findViewById(R.id.key_2).setOnClickListener(digitClickListener);
        findViewById(R.id.key_3).setOnClickListener(digitClickListener);
        findViewById(R.id.key_4).setOnClickListener(digitClickListener);
        findViewById(R.id.key_5).setOnClickListener(digitClickListener);
        findViewById(R.id.key_6).setOnClickListener(digitClickListener);
        findViewById(R.id.key_7).setOnClickListener(digitClickListener);
        findViewById(R.id.key_8).setOnClickListener(digitClickListener);
        findViewById(R.id.key_9).setOnClickListener(digitClickListener);
    }

    @Override
    public void showResult(String value) {
        txtResult.setText(value);
    }
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        currentState = CalculatorPresenter.getState();
        outState.putParcelable(ARG_STATE, currentState);
    }
}