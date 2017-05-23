package com.example.dell;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.dell.recipecup.HomeActivity;
import com.example.dell.recipecup.R;
import com.example.dell.recipecup.Select_non_veg_ingredient;
import com.example.dell.recipecup.Select_veg_ingredient;

public class ByIngredients extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_by_ingredients);

    }




    public void home (View v)
    {
        finish();
    }

    public void veg(View view) {

        Intent i = new Intent(ByIngredients.this , Select_veg_ingredient.class);
        i.putExtra("from" , "search");
        startActivity(i);
        finish();
    }

    public void nonveg(View view) {

        Intent i = new Intent(ByIngredients.this , Select_non_veg_ingredient.class);
        i.putExtra("from" , "search");
        startActivity(i);
        finish();
    }
}
