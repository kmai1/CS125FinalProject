package com.example.kmai.cs125finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class mainScreen extends AppCompatActivity {
    private int totalCalories;
    private Button addFood;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        addFood = findViewById(R.id.addFood);
        addFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFoodScreen();
            }
        });
    }

    public void openFoodScreen() {
        Intent intent = new Intent(this, addFoodScreen.class);
        startActivity(intent);
    }
}
