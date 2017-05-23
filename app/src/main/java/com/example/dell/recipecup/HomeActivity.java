package com.example.dell.recipecup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.dell.AddRecipe;
import com.example.dell.SearchByRecipe;

import com.example.dell.ByIngredients;


public class HomeActivity extends AppCompatActivity {

    public static String sel_list = "" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }
    public void byingredients(View v)
    {
        Intent i = new Intent(HomeActivity.this, ByIngredients.class);
        startActivity(i);

    }
    public void tips(View v)
    {
        Intent j = new Intent(HomeActivity.this, CategoryTips.class);
        startActivity(j);

    }
    public void recipename(View v)
    {
        Intent k = new Intent(HomeActivity.this, SearchByRecipe.class);
        startActivity(k);
    }
    public void addrecipe(View v)
    {
        Intent l = new Intent(HomeActivity.this,AddRecipe.class);
        startActivity(l);
    }


    public void logout(View view) {
    }

    public void rate_app(View view) {
    }

    public void share_app(View view) {
    }

    public void search(View view) {
    }

    public void my_recipes(View view) {
    }

    public void open_profile(View view) {

        Intent i = new Intent(HomeActivity.this , Edit_profile.class);

        startActivity(i);
    }
}
