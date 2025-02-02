package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class BMIActivity extends AppCompatActivity {

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

        setContentView(R.layout.activity_bmiacticity);

        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle(Html.fromHtml("<front color=\"white\"></front>"));
        getSupportActionBar().setTitle("Result");
        ColorDrawable colorDrawable=new ColorDrawable(Color.parseColor("#1E1D1D"));
        getSupportActionBar().setBackgroundDrawable(colorDrawable);


        intent=getIntent();
        mbmidisplay=findViewById(R.id.bmidisplay);
        mbmicategory = findViewById(R.id.bmicategory);
        mgender=findViewById(R.id.genderdisplay);
        mbackground=findViewById(R.id.contentlayout);
        mimageview=findViewById(R.id.imageview);
        mrecalculatebmi=findViewById(R.id.recalculatebmi);


        height=intent.getStringExtra("height");
        weight=intent.getStringExtra("weight");

        intheight=Float.parseFloat(height);
        intweight=Float.parseFloat(weight);

        intheight=intheight/100;
        intbmi=intweight/(intheight*intheight);

        mbmi=Float.toString(intbmi);
        System.out.println(mbmi);


        if(intbmi<16)
        {
            mbmicategory.setText("Severe Thinness");
//            mbackground.setBackgroundColor(Color.GRAY);
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
            // mbackground.setBackgroundColor(Color.YELLOW);
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


        mgender.setText(intent.getStringExtra("gender"));
        mbmidisplay.setText(mbmi);


//        getSupportActionBar().hide();
//        mrecalculatebmi=findViewById(R.id.recalculatebmi);


        mrecalculatebmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(BMIActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}