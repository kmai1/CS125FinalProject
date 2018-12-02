package com.example.kmai.cs125finalproject;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class mainScreen extends AppCompatActivity {
    private static int totalCalories;
    private static double totalFats, totalCarbs, totalProtein;
    private static List<Food> listOfFoods = new ArrayList<>();
    public Button addFood;
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

        final Handler handler = new Handler();

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                listOfFoods.add(new Food(100,1.0,1.0,1.0));
                updateCalories();
                updateCarbs();
                updateFat();
                updateProtein();
                TextView totalCaloriesText = findViewById(R.id.totalCalories);
                totalCaloriesText.setText("Total Calories:    " + Integer.toString(totalCalories));

                TextView totalCarbsText = findViewById(R.id.totalCarbs);
                totalCarbsText.setText("Total Carbs:    " + Double.toString(totalCarbs));

                TextView totalFatsText = findViewById(R.id.totalFats);
                totalFatsText.setText("Total Fat:    " + Double.toString(totalFats));

                TextView totalProteinText = findViewById(R.id.totalProtein);
                totalProteinText.setText("Total Protein:     " + Double.toString(totalProtein));

                handler.postDelayed(this, 100);
            }
        };
        handler.postDelayed(runnable, 100);
    }
    public void openFoodScreen() {
        Intent intent = new Intent(this, addFoodScreen.class);
        startActivity(intent);
    }
    public void updateCalories() {
        totalCalories = 0;
        for (int k = 0; k < listOfFoods.size(); k++) {
            totalCalories += listOfFoods.get(k).getCalories();
        }
    }

    public void updateCarbs() {
        totalCarbs = 0;
        for (int k = 0; k < listOfFoods.size(); k++) {
            totalCarbs += listOfFoods.get(k).getCarbs();
        }
    }
    public void updateFat() {
        totalFats = 0;
        for (int k = 0; k < listOfFoods.size(); k++) {
            totalFats += listOfFoods.get(k).getFat();
        }
    }
    public void updateProtein() {
        totalProtein = 0;
        for (int k = 0; k < listOfFoods.size(); k++) {
            totalProtein += listOfFoods.get(k).getProtein();
        }
    }

}
