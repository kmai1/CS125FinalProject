package com.example.kmai.cs125finalproject;

public class Food {
    private int calories;
    private double carbs, fat, protein;
    public Food(int setCalories, double setCarbs, double setFat, double setProtein) {
        calories = setCalories;
        carbs = setCarbs;
        fat = setFat;
        protein = setProtein;
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
