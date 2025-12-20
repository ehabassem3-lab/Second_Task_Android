package com.example.myapplication;
import android.widget.Button;

import android.os.Bundle;
import android.view.View;
import android.content.Intent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class Hotels  extends AppCompatActivity {
    String[] names = {"Dahab","Sharm","Sahel","Gadha","Gouna","Ras Shetan","Nebaw","Matroh"};
    int[]  Images={ R.drawable.first, R.drawable.second , R.drawable.third ,
                         R.drawable.fourth, R.drawable.fifth , R.drawable.six,
                        R.drawable.seven, R.drawable.eight ,


    };
    ArrayList<City> citylist;
    RecyclerView recyclerView;
    CityAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hotels);
        recyclerView = findViewById(R.id.recycle);
        citylist = new ArrayList<>();
       for (int i = 0 ; i < names.length ; i++){
           citylist.add(new City(names[i],Images[i]));

       }
        adapter = new CityAdapter(citylist);

        // 4. نحدد طريقة العرض (شبكة مربعات)
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        // 5. نربط الشيف بالمطعم
        recyclerView.setAdapter(adapter);






    }
}
