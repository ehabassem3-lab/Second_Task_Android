package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class XO extends AppCompatActivity {


    ConstraintLayout constraintLayout ;
    public static int  Score_X  = 0;
   public static TextView X_SCORE ;
    public static TextView O_SCORE;

    public   static  int  Score_O = 0 ;
    TextView textView ;
// new
    TextView  textViewPlayersTurn;
    private Context context;

    int seconds = 0 ;
    int minutes =0;

    String[]Board = {"","","","","","","","",""};

   public static int counter = 0;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.xo);
        WelcomePage.Score_Table();
        textView = findViewById(R.id.TimerTv);


        Log.e("The Counter",counter+"");
        textViewPlayersTurn = findViewById(R.id.playersTurn);
        textView.setText("00"+":"+"00");
        // to Check the Score and serttle it
         WelcomePage.Score_Table();


        startTimer();






    }



    private void startTimer() {

            Handler handler = new Handler();
            Runnable runnable = new Runnable() {


                @Override
                public void run() {
                    seconds++;
                    minutes = seconds / 60;

                    int remainingSecons = seconds - minutes * 60;
                    String    formatedMinutes = minutes < 10 ? "0" + minutes : minutes +"";
                    String    formatedSeconds = remainingSecons < 10 ? "0" + remainingSecons : remainingSecons +"";
                        String Timer = formatedMinutes + ":" + formatedSeconds;
                    handler.postDelayed(this, 1000);
                        if (minutes == 3 ){
                            textView.setText("00"+":"+"00");
                            seconds = 0;
                            minutes = 0;
                            resetBoard();
                            return;
                        }

                        textView.setText(Timer);




                }


            };


            handler.postDelayed(runnable, 1000);



    }
    public void OnPlayerClick(View v) {


        String Symbol = "";

        if (v instanceof ImageView) {

            ImageView I = (ImageView) v;
            int index = Integer.parseInt(I.getTag().toString());
            Symbol = counter % 2 == 0 ? "x" : "o";
            Board[index] = Symbol;


            if (I.getDrawable() != null) {
                return;
            }


            if (counter % 2 == 0) {
                I.setImageResource(R.drawable.x);
                textViewPlayersTurn.setText(" PLayer 1st turn ");

            }


            if (counter % 2 != 0) {
                I.setImageResource(R.drawable.o);
                textViewPlayersTurn.setText(" PLayer 2nd turn ");

            }
            if (!checkWinner() && counter == 8) {
                Toast.makeText(this, "Its a Draw", Toast.LENGTH_SHORT).show();
                resetBoard();


            }
            if (checkWinner()) {
                Log.e("CounerAfter", counter + "");

                if (counter % 2 == 0 ) {

                    Score_X++;


                } else {

                    Score_O++;


                }


                Log.e("Score", Score_X + "");
                Log.e("Score", Score_O + "");


                String playerNumber = counter % 2 == 0 ? "First player" : "Second player";
                Toast.makeText(this, playerNumber + "" + "have won the Game", Toast.LENGTH_LONG).show();
                resetBoard();


            }


            counter++;


        }
    }


    private void resetBoard() {
      Board = new String[] {"","","","","","","","",""};

        constraintLayout = findViewById(R.id.Grid);
        for ( int i = 0 ;  i < constraintLayout.getChildCount() ; i++){
            View v =  constraintLayout.getChildAt(i);
            if (v instanceof ImageView){
               ImageView button = (ImageView) v;
               button.setImageResource(0);
               counter = 0;
                Intent intent = new Intent(XO.this,WelcomePage.class);
                startActivity(intent);







            }




        }

    }

    public boolean checkWinner(){
    String Symbol = counter % 2 == 0 ? "x" : "o" ;



        if (
                Board[0].equals(Symbol) &&
                 Board[1].equals(Symbol) &&
                  Board[2].equals(Symbol)
        ) {return true;}
        if (
                Board[3].equals(Symbol) &&
                        Board[4].equals(Symbol) &&
                        Board[5].equals(Symbol)
        ) {return true;}
        if (
                Board[6].equals(Symbol) &&
                        Board[7].equals(Symbol) &&
                        Board[8].equals(Symbol)
        ) {return true;}
        if (
                Board[0].equals(Symbol) &&
                        Board[3].equals(Symbol) &&
                        Board[6].equals(Symbol)
        ) {return true;}
        if (
                Board[1].equals(Symbol) &&
                        Board[4].equals(Symbol) &&
                        Board[7].equals(Symbol)
        ) {return true;}
        if (
                Board[2].equals(Symbol) &&
                        Board[5].equals(Symbol) &&
                        Board[8].equals(Symbol)
        ) {return true;}
        if (
                Board[0].equals(Symbol) &&
                        Board[4].equals(Symbol) &&
                        Board[8].equals(Symbol)
        ) {return true;}
        if (
                Board[2].equals(Symbol) &&
                        Board[4].equals(Symbol) &&
                        Board[6].equals(Symbol)
        ) {return true;}

        return false;



    }







    }



