package com.example.dell.recipecup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.dell.SearchByRecipe;
import com.example.dell.veg_list_adapter;

import java.util.ArrayList;

public class Select_veg_ingredient extends AppCompatActivity {

    RecyclerView recycle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_ingredient);

        HomeActivity.sel_list = "";

        recycle = (RecyclerView) findViewById(R.id.recycler_id);

        recycle.setLayoutManager(new LinearLayoutManager(Select_veg_ingredient.this, LinearLayoutManager.VERTICAL, false));


        ArrayList<String> list = new ArrayList<>();

        list.add("Cheese");
        list.add("Cauliflower");
        list.add("Brinjal");
        list.add("Carrots");
        list.add("Grams");
        list.add("Rajma");
        list.add("Soyabeans");
        list.add("Ladyfinger");


        veg_list_adapter ad = new veg_list_adapter(list, Select_veg_ingredient.this);

        recycle.setAdapter(ad);
    }

    public void done(View view)

    {

        if(getIntent().getStringExtra("from").equals("select")) {
            finish();
        }
        else{
            Intent i = new Intent(Select_veg_ingredient.this, RecipeResult.class);
            i.putExtra("key", HomeActivity.sel_list);
            i.putExtra("search_by" , "by_ingredients");

            startActivity(i);
        }

    }
}
