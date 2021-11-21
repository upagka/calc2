package vip.daur.calc2.ui;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import vip.daur.calc2.R;
import vip.daur.calc2.domain.*;


public class CalculatorActivity extends AppCompatActivity implements CalculatorView {

    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        txtResult = findViewById(R.id.result);
    }

    @Override
    public void showResult(String value) {
        txtResult.setText(value);

    }
}