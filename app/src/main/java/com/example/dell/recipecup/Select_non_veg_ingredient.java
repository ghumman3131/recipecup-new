package com.example.dell.recipecup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.dell.nonveg_list_adapter;
import com.example.dell.veg_list_adapter;

import java.util.ArrayList;


public class Select_non_veg_ingredient extends AppCompatActivity {

    RecyclerView recycle_nv ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_non_veg_ingredient);

        HomeActivity.sel_list = "";

        recycle_nv = (RecyclerView) findViewById(R.id.recycler_nv);

        recycle_nv.setLayoutManager(new LinearLayoutManager(Select_non_veg_ingredient.this , LinearLayoutManager.VERTICAL , false));

        ArrayList<String> list = new ArrayList<>();

        list.add("Red Meat");
        list.add("Chicken");
        list.add("Beef");
        list.add("Duck");
        list.add("Eggs");
        list.add("Salami");
        list.add("Fish");
        list.add("Pork");





        nonveg_list_adapter ad = new nonveg_list_adapter(list , Select_non_veg_ingredient.this);

        recycle_nv.setAdapter(ad);
    }

    public void done(View view)

    {

        if(getIntent().getStringExtra("from").equals("select")) {
            finish();
        }
        else{
            Intent i = new Intent(Select_non_veg_ingredient.this, RecipeResult.class);
            i.putExtra("key", HomeActivity.sel_list);
            i.putExtra("search_by" , "by_ingredients");

            startActivity(i);
        }

    }
}
