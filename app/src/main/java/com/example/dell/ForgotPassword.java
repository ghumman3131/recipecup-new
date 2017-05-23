package com.example.dell;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dell.recipecup.MainActivity;
import com.example.dell.recipecup.R;

public class ForgotPassword extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);
    }
    public void submitcontact(View v)
    {
        EditText mobile_et = (EditText) findViewById(R.id.mobile_et);
        String mobile =mobile_et.getText().toString();
        if (mobile.length()<10 ) {
            Toast.makeText(ForgotPassword.this, " Mobile Number Incorrect", Toast.LENGTH_SHORT).show();
            return;
        }

    int randomPIN = (int)(Math.random()*9000)+1000;



        Intent k = new Intent(ForgotPassword.this , Otp.class);

    k.putExtra("mobile", mobile);
    k.putExtra("pin" , randomPIN);

    startActivity(k);
    }
    public void home (View v)
    {
        Intent j= new Intent(ForgotPassword.this, MainActivity.class);
        startActivity(j);
    }


    public void cancelfp (View v)
    {
        Intent j= new Intent(ForgotPassword.this, MainActivity.class);
        startActivity(j);
    }


}
