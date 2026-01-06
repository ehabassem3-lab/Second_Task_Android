package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Calc extends AppCompatActivity {
    TextView resultTextView ;
    String LH;
    String RH;
    String Ops =  "";

    boolean isEqualClicked =true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calc);
        resultTextView = findViewById(R.id.text);
        resultTextView.setText("");
        Button Equals = findViewById(R.id.btn_equals);
        Equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Ops.isEmpty() || resultTextView.toString().isEmpty())  return;
                String result;
              String  RH = resultTextView.getText().toString();
                result = Calc(LH,Ops,RH);
                resultTextView.setText(result);
                LH = result;
                Ops = "";
                isEqualClicked = true;

            }
        });
    }
    public void OneOperationClick(View view) {
        if (view instanceof  Button){
            Button buttonOp = ((Button) view);
            if (Ops.isEmpty()){
                if (!resultTextView.getText().toString().isEmpty()){
                    LH =resultTextView.getText().toString();
                    Ops = buttonOp.getText().toString();
                    resultTextView.setText(null);

                }

            }
            else {
                RH = resultTextView.getText().toString();
                if (!RH.isEmpty()) {
                    LH = Calc(LH, Ops, RH);
                    Ops = buttonOp.getText().toString();
                    resultTextView.setText(null);

                }
            }

        }


    }
    public String Calc(String lh , @NonNull String o , String rh){
        double LH = Double.parseDouble(lh);
        double RH = Double.parseDouble(rh);
        double res = 0.0;

       switch (o){
           case "+" : res = LH +RH ;
           break;
           case "-" : res = LH  -RH ;
               break;
           case "*" : res = LH *RH ;
               break;
           case "/" : res = LH /RH ;
               break;


       }
        return res +"";
    }



    public void OneDigitClick(View view) {
        if (view instanceof Button) {
            Button button = ((Button) view);
            if (resultTextView.getText().toString().isEmpty()){
                resultTextView.setText(button.getText());

            }
            else {
                resultTextView.append(button.getText());
            }
        }




    }
    public  void  Remove(View view){
        if (view instanceof  Button) {
            String Text = resultTextView.getText().toString();
            if (Text.isEmpty()) return;
            else {
                if (Text.length() > 1) {
                    String newText =Text.substring(0,Text.length() - 1 );
                    resultTextView.setText(newText);
                }
                else  resultTextView.setText("");
            }
        }

    }
    public void RemoveAll(View view){
        if (view instanceof  Button){
            Button button = ((Button) view);
            resultTextView.setText("");
            LH = "";
            RH  = "";
            Ops= "";
            isEqualClicked = false;
        }

    }

}
