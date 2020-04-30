package com.example.compute;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    EditText inputA;
    EditText inputB;
    EditText inputC;
    EditText inputD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        inputA = findViewById(R.id.input_a);
        inputB = findViewById(R.id.input_b);
        inputC = findViewById(R.id.input_c);
        inputD = findViewById(R.id.input_d);
    }

    public void compute(View view) throws ParseException {
        Date expireDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2020-04-30 20:18:00");
        if (expireDate.before(new Date())) {
            Toast.makeText(this, "体验版已经过期", Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, String.valueOf(getResult()), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
        intent.putExtra("result", getResult());
        startActivity(intent);

    }

    private String getResult() {
        double a = getDoubleValue(inputA.getText().toString());
        double b = getDoubleValue(inputB.getText().toString());
        double c = getDoubleValue(inputC.getText().toString());
        double d = getDoubleValue(inputD.getText().toString());
        double result = -0.0374 * a + 0.195 * b - 0.2881 * c - 0.6818 * d + 6.8951;
        return String.format("%.4f", result);
    }

    private double getDoubleValue(String number) {
        if (number == null || number.length() == 0) {
            return 0;
        }
        return Double.parseDouble(number);
    }


}
