package com.example.kmai.cs125finalproject;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.github.tbouron.shakedetector.library.ShakeDetector;

import java.util.ArrayList;
import java.util.List;

public class mainScreen extends AppCompatActivity {
    private static int totalCalories;
    private static double totalFats, totalCarbs, totalProtein;
    private static List<Food> listOfFoods = new ArrayList<Food>();
    public static List<String> foodNames = new ArrayList<String>();
    public Button addFood, reset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);
        //Shaking Software Library credits to tbouron
        ShakeDetector.create(this, new ShakeDetector.OnShakeListener() {

            @Override
            public void OnShake() {
                ShakeDetector.updateConfiguration(1f,1);
                openFoodName();
            }

        });
        reset = findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listOfFoods = new ArrayList<Food>();
                foodNames = new ArrayList<String>();
            }
        });

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
                updateCalories();
                updateFat();
                updateCarbs();
                updateProtein();
                TextView totalCaloriesText = findViewById(R.id.totalCalories);
                totalCaloriesText.setText("Total Calories:    " + Integer.toString(totalCalories));

                TextView totalCarbsText = findViewById(R.id.totalCarbs);
                totalCarbsText.setText("Total Carbs:    " + Double.toString(totalCarbs) + "g");

                TextView totalFatsText = findViewById(R.id.totalFats);
                totalFatsText.setText("Total Fat:    " + Double.toString(totalFats) + "g");

                TextView totalProteinText = findViewById(R.id.totalProtein);
                totalProteinText.setText("Total Protein:     " + Double.toString(totalProtein) + "g");

                handler.postDelayed(this, 100);
            }
        };
        handler.postDelayed(runnable, 100);
    }
    public void openFoodScreen() {
        Intent intent = new Intent(this, addFoodScreen.class);
        startActivity(intent);
    }
    public void openFoodName() {
        Intent intent = new Intent(this, ListOfFoods.class);
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



    public static List<Food> getListOfFoods() {
        return listOfFoods;
    }

    public static void addListOfFoods(Food insertFood) {
        listOfFoods.add(insertFood);
    }

}

