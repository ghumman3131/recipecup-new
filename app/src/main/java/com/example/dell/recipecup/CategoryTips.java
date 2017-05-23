package com.example.dell.recipecup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.dell.tips;

public class CategoryTips extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_tips);

    }
    public void general (View v)
    {
        Intent i = new Intent (CategoryTips.this,tips.class);
        i.putExtra("tip" , "general");
        startActivity(i);
    }
    public void shopping (View v)
    {
        Intent i = new Intent (CategoryTips.this,tips.class);
        i.putExtra("tip" , "shopping");
        startActivity(i);
    }
    public void home (View v)
    {
        Intent j= new Intent(CategoryTips.this, HomeActivity.class);
        startActivity(j);
    }
    public void storage (View v)
    {
        Intent i = new Intent (CategoryTips.this,tips.class);
        startActivity(i);
    }
    public void frying (View v)
    {
        Intent i = new Intent (CategoryTips.this,tips.class);
        startActivity(i);
    }
    public void chopping (View v)
    {
        Intent i = new Intent (CategoryTips.this,tips.class);
        startActivity(i);
    }
    public void health (View v)
    {
        Intent i = new Intent (CategoryTips.this,tips.class);
        startActivity(i);
    }
    public void busy (View v)
    {
        Intent i = new Intent (CategoryTips.this,tips.class);
        startActivity(i);
    }
}
