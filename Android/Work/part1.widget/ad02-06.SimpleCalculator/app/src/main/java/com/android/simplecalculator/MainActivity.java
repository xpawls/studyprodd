package com.android.simplecalculator;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText TextX = null;
    private EditText TextY = null;
    private Button btnPlus = null;
    private Button btnMin = null;
    private Button btnMul = null;
    private Button btnDiv = null;
    private Button btnRem = null;
    private TextView TextResult = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextX = findViewById(R.id.TextX);
        TextY = findViewById(R.id.TextY);
        btnPlus = findViewById(R.id.btnPlus);
        btnMin = findViewById(R.id.btnMin);
        btnMul = findViewById(R.id.btnMul);
        btnDiv = findViewById(R.id.btnDiv);
        btnRem = findViewById(R.id.btnRem);
        TextResult = findViewById(R.id.textResult);

        ButtonClick handler = new ButtonClick();

        btnPlus.setOnClickListener(handler);

        btnMin.setOnClickListener(handler);

        btnMul.setOnClickListener(handler);

        btnDiv.setOnClickListener(handler);

        btnRem.setOnClickListener(handler);
    }

    private class ButtonClick implements View.OnClickListener{


        @Override
        public void onClick(View view) {
            int id = view.getId();
            int rs = 0;
            double rd = 0;
            String s = null;
            int x = 0, y = 0;

            if (TextX.getText().toString().equals("") || TextY.getText().toString().equals("") || TextX.getText().toString().equals(null) || TextY.getText().toString().equals(null) ) {
                Toast.makeText(getApplicationContext(), "올바른 값을 입력하세요.", Toast.LENGTH_SHORT).show();

            } else {

                x = Integer.valueOf(TextX.getText().toString());
                y = Integer.valueOf(TextY.getText().toString());

            }
            switch (id){
                case R.id.btnPlus: rs = x+y;
                    break;
                case R.id.btnMin: rs = x-y;
                    break;
                case R.id.btnMul: rs = x*y;
                    break;
                case R.id.btnDiv: if(y==0){
                    Toast.makeText(getApplicationContext(), "0으로는 나눌 수 없어.", Toast.LENGTH_SHORT).show();
                } else {
                    try
                    {
                        rd = (double)x/y;
                    }
                    catch(Exception e)
                    {
                        e.printStackTrace();
                    }
                }

                    break;
                case R.id.btnRem:  try
                {
                    rs = x%y;
                }
                catch(Exception e)
                {
                    e.printStackTrace();
                }
                    break;
            }
            if(rs == 0 && rd != 0){
                s = String.valueOf(rd);
            } else {
                s = String.valueOf(rs);
            }
            TextResult.setText("결과는 : "+ s);
            TextResult.setTextColor(Color.RED);
            TextResult.setTextSize(50);

        }
    }
}
