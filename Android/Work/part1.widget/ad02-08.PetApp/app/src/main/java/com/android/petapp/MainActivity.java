package com.android.petapp;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.ToggleButton;


public class MainActivity extends AppCompatActivity {

    private Switch startSwitch = null;
    private LinearLayout innerLayout = null;
    private LinearLayout innerLayoutA = null;
    private RadioGroup petRadio = null;
    private Button btnPet = null;
    private ImageView imgPet = null;
    private RadioGroup andRadio = null;
    private ToggleButton toggleAnd = null;
    private Button btnAnd = null;
    private ImageView imgAnd = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        innerLayout = findViewById(R.id.innerLayout);
        petRadio = findViewById(R.id.petRadio);
        startSwitch = findViewById(R.id.startSwitch);
        btnPet = findViewById(R.id.btnPet);
        imgPet = findViewById(R.id.imgPet);



        startSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b == true){
                    innerLayout.setVisibility(View.VISIBLE);
                }
                else if(b == false) {
                    innerLayout.setVisibility(View.GONE);
                }
            }
        });


        btnPet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int ra = petRadio.getCheckedRadioButtonId();

                if(ra == R.id.radioDog){
                    imgPet.setImageResource(R.drawable.dog);
                }

                else if (ra == R.id.radioCat){
                    imgPet.setImageResource(R.drawable.cat);
                }
                else if (ra == R.id.radioRabbit){
                    imgPet.setImageResource(R.drawable.rabbit);
                }


            }
        });
        innerLayoutA = findViewById(R.id.innerLayoutA);
        andRadio = findViewById(R.id.andRadio);
        toggleAnd = findViewById(R.id.toggleAnd);
        btnAnd = findViewById(R.id.btnAnd);
        imgAnd = findViewById(R.id.imgAnd);

        toggleAnd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b == true){
                    innerLayoutA.setVisibility(View.VISIBLE);
                }
                else if(b == false) {
                    innerLayoutA.setVisibility(View.GONE);
                }
            }
        });

        btnAnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int ra = andRadio.getCheckedRadioButtonId();

                if(ra == R.id.andMash){
                    imgAnd.setImageResource(R.drawable.marshmallow);
                }

                else if (ra == R.id.andNou){
                    imgAnd.setImageResource(R.drawable.nougat);
                }
                else if (ra == R.id.andLolli){
                    imgAnd.setImageResource(R.drawable.lollipop);
                }
            }
        });

    }
}
