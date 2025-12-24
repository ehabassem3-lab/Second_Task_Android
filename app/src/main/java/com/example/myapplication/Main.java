package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Main  extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button first = findViewById(R.id.androidBtn);
        Button second = findViewById(R.id.iosBtn);
        Button third = findViewById(R.id.fullBtn);
        second.setOnClickListener(v -> {
            Intent intent  = new Intent(Main.this , Ios.class);
            startActivity(intent);
        });
        third.setOnClickListener(v -> {
            Intent intent  = new Intent(Main.this , FullStack.class);
            startActivity(intent);
        });
        first.setOnClickListener(v -> {
            Intent intent  = new Intent(Main.this , Android.class);
            startActivity(intent);
        });
    }
}
