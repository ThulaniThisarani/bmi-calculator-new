package com.example.bmicalculator;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SimpleActivity extends AppCompatActivity {
    android.widget.Button mrecalculatebmi;

    TextView mbmidisplay,mbmicategory,mgender;
    Intent intent;
    ImageView mimageview;
    String mbmi;
    float intbmi;

    String height;
    String weight;

    float intheight,intweight;

    RelativeLayout mbackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_simple);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        if (getSupportActionBar() != null) {
            getSupportActionBar().setElevation(0);
            ColorDrawable colorDrawable = new ColorDrawable(Color.parseColor("#1E1D1D"));
            getSupportActionBar().setBackgroundDrawable(colorDrawable);
            getSupportActionBar().setTitle(Html.fromHtml("<font color=\"white\">Result</font>"));
        }


        intent=getIntent();
        mbmidisplay=findViewById(R.id.bmidisplay);
        //    magedisplay=findViewById(R.id.agedisplay);
        //    mweightdisplay=findViewById(R.id.weightdisplay);
        mbmicategory = findViewById(R.id.bmicategory);
//        mgotomain=findViewById(R.id.gotomain);

        mimageview=findViewById(R.id.imageview);

        //   mheightdisplay=findViewById(R.id.heightdisplay);
        mgender=findViewById(R.id.genderdisplay);
        mbackground=findViewById(R.id.contentlayout);
        mrecalculatebmi=findViewById(R.id.recalculatebmi);


        height=intent.getStringExtra("height");
        weight=intent.getStringExtra("weight");


        intheight=Float.parseFloat(height);
        intweight=Float.parseFloat(weight);

        intheight=intheight/100;
        intbmi=intweight/(intheight*intheight);


        mbmi=Float.toString(intbmi);
//        System.out.println(mbmi);

        if(intbmi<16)
        {
            mbmicategory.setText("Severe Thinness");
            //   mbackground.setBackgroundColor(Color.GRAY);
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.cancel);
            //  mimageview.setBackground(colorDrawable2);

        }
        else if(intbmi<16.9 && intbmi>16)
        {
            mbmicategory.setText("Moderate Thinness");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.warning);
            //   mimageview.setBackground(colorDrawable2);

        }
        else if(intbmi<18.4 && intbmi>17)
        {
            mbmicategory.setText("Mild Thinness");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.warning);
            //   mimageview.setBackground(colorDrawable2);
        }
        else if(intbmi<24.9 && intbmi>18.5 )
        {
            mbmicategory.setText("Normal");
            mimageview.setImageResource(R.drawable.check);
            mbackground.setBackgroundColor(Color.YELLOW);
            //  mimageview.setBackground(colorDrawable2);
        }
        else if(intbmi <29.9 && intbmi>25)
        {
            mbmicategory.setText("Overweight");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.warning);
            //mimageview.setBackground(colorDrawable2);
        }
        else if(intbmi<34.9 && intbmi>30)
        {
            mbmicategory.setText("Obese Class I");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.warning);
            //  mimageview.setBackground(colorDrawable2);
        }
        else
        {
            mbmicategory.setText("Obese Class II");
            mbackground.setBackgroundColor(Color.RED);
            mimageview.setImageResource(R.drawable.cancel);
            //  mimageview.setBackground(colorDrawable2);
        }

        //magedisplay.setText("your age is"+intent.getStringExtra("age"));
        //mheightdisplay.setText("Your Height is "+intent.getStringExtra("height"));
        //mweightdisplay.setText("Your Weight is "+intent.getStringExtra("weight"));
        mgender.setText(intent.getStringExtra("gender"));
        mbmidisplay.setText(mbmi);







        Button navigateButton=findViewById(R.id.food);


        navigateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SimpleActivity.this, Food.class);

                startActivity(intent);

            }
        });

        Button exerciseButton = findViewById(R.id.recalculatebmi);
        exerciseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SimpleActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        Button eButton = findViewById(R.id.details);
        eButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SimpleActivity.this, Details.class);
                startActivity(intent);
            }
        });


    }



}