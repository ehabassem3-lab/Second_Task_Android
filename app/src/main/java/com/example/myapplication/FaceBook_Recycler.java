package com.example.myapplication;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FaceBook_Recycler extends AppCompatActivity {
   ArrayList<FaceBook_Model> FaceBookModelArrayList = new ArrayList<>();
    int[] Profile_Image = {
            R.drawable.profile,R.drawable.profile2,R.drawable.profile3,
            R.drawable.profile4,R.drawable.profile5,R.drawable.profile6,
            R.drawable.profile7,R.drawable.profile8,R.drawable.profile9,
            R.drawable.profile10,
    };
    int[] Post_Image = {

    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.android_assighment_3);
        RecyclerView recyclerView = findViewById(R.id.FacebookPost);
        CreateModel();
        FaceBookAdapter adapter = new FaceBookAdapter(this,FaceBookModelArrayList);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



    }
    public  void CreateModel(){
        String [] Profilename = getResources().getStringArray(R.array.Profile_Name);
        for (int i = 0 ; i < Profilename.length ; i ++ ){
            FaceBookModelArrayList.add(new FaceBook_Model(
                    Profile_Image[i],
                    Profilename[i]
            ));
        }

    }


}
