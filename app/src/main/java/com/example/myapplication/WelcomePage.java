package com.example.myapplication;

import static com.example.myapplication.XO.O_SCORE;
import static com.example.myapplication.XO.Score_O;
import static com.example.myapplication.XO.Score_X;
import static com.example.myapplication.XO.X_SCORE;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;

public class WelcomePage extends AppCompatActivity {
    public static AppCompatImageButton button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_page);
        X_SCORE = findViewById(R.id.FirstPlayer);
        O_SCORE = findViewById(R.id.SecondPlayer);
        Score_Table();

    }



    public   void  OnClick_Choice(View v){
        if (v instanceof  AppCompatImageButton) {
            AppCompatImageButton Choice = (AppCompatImageButton) v;
            if (Choice.getTag().equals("x")){
                XO.counter = 0;
                Intent intent = new Intent(WelcomePage.this, XO.class);
                startActivity(intent);
               Log.e("THE COUNTER",XO.counter+"");

            }
            else {

                XO.counter = 1 ;
                Log.e("THE COUNTER",XO.counter+"");
                Intent intent = new Intent(WelcomePage.this, XO.class);
                startActivity(intent);

            }


        }

        }
        public  static void Score_Table(){
        if(X_SCORE == null && O_SCORE == null ) return;
             X_SCORE.setText(String.valueOf(Score_X));
            O_SCORE.setText(String.valueOf(Score_O));
        }

    }


