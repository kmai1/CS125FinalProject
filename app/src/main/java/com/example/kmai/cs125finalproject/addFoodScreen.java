package com.example.kmai.cs125finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class addFoodScreen extends AppCompatActivity {
    private Button customFood;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_screen);

        customFood = findViewById(R.id.customFood);
        customFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCustomFoodScreen();
            }
        });

    }
    public void openCustomFoodScreen() {
        Intent intent = new Intent(this, customFoodScreen.class);
        startActivity(intent);
    }
}
