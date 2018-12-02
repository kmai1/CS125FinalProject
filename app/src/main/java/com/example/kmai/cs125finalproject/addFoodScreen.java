package com.example.kmai.cs125finalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class addFoodScreen extends AppCompatActivity {
    private Button customFood;
    private Button addFood;
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

        addFood = findViewById(R.id.addFood);
        addFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int inputtedCalories;
                double inputtedCarbs, inputtedFats, inputtedProtein;
                EditText calories = findViewById(R.id.inputCalories);
                EditText carbs = findViewById(R.id.inputCarbs);
                EditText fats = findViewById(R.id.inputFat);
                EditText protein = findViewById(R.id.inputProtein);
                if (TextUtils.isEmpty(calories.getText())) {
                    calories.setError("CALORIES REQUIRED");
                } else if (TextUtils.isEmpty(carbs.getText())) {
                    carbs.setError("CARBS REQUIRED");
                } else if (TextUtils.isEmpty(fats.getText())) {
                    fats.setError("FATS REQUIRED");
                } else if (TextUtils.isEmpty(protein.getText())) {
                    protein.setError("PROTEIN REQUIRED");
                } else {
                    inputtedCalories = Integer.parseInt(calories.getText().toString());
                    inputtedCarbs = Integer.parseInt(carbs.getText().toString());
                    inputtedFats = Double.parseDouble(fats.getText().toString());
                    inputtedProtein = Double.parseDouble(protein.getText().toString());
                    Food createdFood = new Food(inputtedCalories,inputtedCarbs,inputtedFats,inputtedProtein);
                    mainScreen.addListOfFoods(createdFood);
                    switchToMainScreen();
                }
            }
        });

    }
    public void openCustomFoodScreen() {
        Intent intent = new Intent(this, customFoodScreen.class);
        startActivity(intent);
    }
    public void switchToMainScreen() {
        Intent intent = new Intent(this, mainScreen.class);
        startActivity(intent);
    }
}
