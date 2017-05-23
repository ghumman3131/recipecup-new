package com.example.dell;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.example.dell.recipecup.R;
import com.example.dell.recipecup.RecipeResult;



public class SearchByRecipe extends AppCompatActivity {

    EditText search;
    LinearLayout ln ;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_by_recipe);

        ln = (LinearLayout) findViewById(R.id.result_recipe);
        search = (EditText) findViewById(R.id.rsrch);

    }

    public void recipe_srch (View V)
    {

        Intent i = new Intent(SearchByRecipe.this, RecipeResult.class);
        i.putExtra("key", search.getText().toString());
        i.putExtra("search_by" , "by_name");

        startActivity(i);
    }

    public void home(View view) {

        finish();
    }
}
