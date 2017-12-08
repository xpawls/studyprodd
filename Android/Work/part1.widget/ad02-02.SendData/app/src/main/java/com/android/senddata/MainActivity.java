package com.android.senddata;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    // 1. 위젯 선언
    private EditText edtName = null;
    private Button   btnSend = null;
    private TextView txtMsg  = null;
    private Button btnToast  = null;
    private Button btnGoogle = null;
    private Button btnCall = null;
    private Button btnMy = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // 2. 위젯 찾기
        edtName = findViewById(R.id.editName);
        btnSend = findViewById(R.id.btnSend);
        txtMsg = findViewById(R.id.textMsg);
        btnToast = findViewById(R.id.btnToast);
        btnGoogle = findViewById(R.id.btnGoogle);
        btnCall = findViewById(R.id.btnCall);
        btnMy = findViewById(R.id.btnMy);

        // 3. 위젯 설정정
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // 1. edtName에서 값 가져오기
                String tmp = edtName.getText().toString();

                // 2. txtMsg 에 값을 설정하기.
                txtMsg.setText(tmp);

            }
        });

        btnToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Toast", Toast.LENGTH_SHORT).show();
            }
        });

        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                startActivity(i);

            }
        });

        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Intent.ACTION_DIAL, Uri.parse("tell:"));
                startActivity(i);
            }
        });

        btnMy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
