package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Main_Recycle extends AppCompatActivity {
 int[] Images ={
            R.drawable.image_1,  R.drawable.image_2 ,   R.drawable.image_3,
            R.drawable.image_4,  R.drawable.image_5 ,   R.drawable.image_6,
            R.drawable.image_7,  R.drawable.image_8 ,   R.drawable.image_9,
            R.drawable.image_10,  R.drawable.image_11 ,   R.drawable.image_12,
            R.drawable.image_13,  R.drawable.image_14 ,   R.drawable.image_15,
            R.drawable.image_16,  R.drawable.image_17 ,   R.drawable.image_18,
            R.drawable.image_19,  R.drawable.image_20 ,


    };
    ArrayList<Recycler_Model> AminoModels = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_recycle);
        RecyclerView recyclerView = findViewById(R.id.MyrecyclerView);
        CreatingModels();
        Adabter_Amino adapter = new Adabter_Amino(this,AminoModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
    public void CreatingModels(){
        String[] AminoAcidsNames = getResources().getStringArray(R.array.TxT_Dummy);
        String[] AminoAcids3letters = getResources().getStringArray(R.array.compound_abbr_3);
        String[] AminoAcids2letters = getResources().getStringArray(R.array.compound_abbr_2);


        for (int i = 0 ; i < AminoAcidsNames.length ; i++){
            AminoModels.add(new Recycler_Model(
                    AminoAcidsNames[i],
                    AminoAcids3letters[i],
                    AminoAcids2letters[i],
                    Images[i]
            ));
        }

    }

}
