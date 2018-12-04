package com.example.kmai.cs125finalproject;

public class Food {
    private String name;
    private int calories;
    private double carbs, fat, protein;
    public Food(String setName, int setCalories, double setCarbs, double setFat, double setProtein) {
        name = setName;
        calories = setCalories;
        carbs = setCarbs;
        fat = setFat;
        protein = setProtein;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public double getCarbs() {
        return carbs;
    }

    public void setCarbs(double carbs) {
        this.carbs = carbs;
    }

    public double getFat() {
        return fat;
    }

    public void setFat(double fat) {
        this.fat = fat;
    }

    public double getProtein() {
        return protein;
    }

    public void setProtein(double protein) {
        this.protein = protein;
    }



}
