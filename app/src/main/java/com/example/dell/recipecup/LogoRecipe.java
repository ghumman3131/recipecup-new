package com.example.dell.recipecup;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LogoRecipe extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logo);
        Handler h = new Handler();

         h.postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent(LogoRecipe.this, MainActivity.class);
                startActivity(i);
                finish();
            }
        }, 3000);
    }
}
