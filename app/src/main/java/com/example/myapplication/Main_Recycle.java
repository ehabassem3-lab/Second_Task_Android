package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Main_Recycle extends AppCompatActivity {
    ArrayList<Recycler_Model> AminoAcidsArrayList = new ArrayList<>();
    int[] Images = {
            R.drawable.image_1, R.drawable.image_2, R.drawable.image_3,
            R.drawable.image_4, R.drawable.image_5, R.drawable.image_6,
            R.drawable.image_7, R.drawable.image_8, R.drawable.image_9,
            R.drawable.image_10, R.drawable.image_11, R.drawable.image_12,
            R.drawable.image_13, R.drawable.image_14, R.drawable.image_15,
            R.drawable.image_16, R.drawable.image_17, R.drawable.image_18,
            R.drawable.image_19, R.drawable.image_20,
            R.drawable.image_1, R.drawable.image_2, R.drawable.image_3,
            R.drawable.image_4, R.drawable.image_5, R.drawable.image_6,
            R.drawable.image_7, R.drawable.image_8, R.drawable.image_9,
            R.drawable.image_10, R.drawable.image_11, R.drawable.image_12,
            R.drawable.image_13, R.drawable.image_14, R.drawable.image_15,
            R.drawable.image_16, R.drawable.image_17, R.drawable.image_18,
            R.drawable.image_19, R.drawable.image_20,


    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_recycle);
        RecyclerView recyclerView = findViewById(R.id.MyrecyclerView);
        CreatingModels();
        Adabter_Amino adabterAmino = new Adabter_Amino(AminoAcidsArrayList,this);
        adabterAmino.setAminoClick(new Amino_Click() {
            @Override
            public void SetClickAmino(Recycler_Model recyclerModel, int postion) {
                Intent intent = new Intent(Main_Recycle.this,FaceBook_Recycler.class);
                startActivity(intent);
            }
        });

        recyclerView.setAdapter(adabterAmino);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public void CreatingModels() {
       String[] FullName = getResources().getStringArray(R.array.TxT_Dummy);
        String[] _2abberr = getResources().getStringArray(R.array.compound_abbr_2);
        String[] _3abberr = getResources().getStringArray(R.array.compound_abbr_3);
        for (int i = 0  ; i < Images.length ; i++ ){
            AminoAcidsArrayList.add( new Recycler_Model(
                    FullName[i],
                    _2abberr[i],
                    _3abberr[i],
                    Images[i]


            ));
        }

    }
}
