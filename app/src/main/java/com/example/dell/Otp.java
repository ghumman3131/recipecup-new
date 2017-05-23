package com.example.dell;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dell.recipecup.R;
import com.example.dell.recipecup.ResetPassword;

public class Otp extends AppCompatActivity {

   EditText otp1 , otp2 , otp3 , otp4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        final String mobile = getIntent().getStringExtra("mobile");

        final int pin = getIntent().getIntExtra("pin" , 0);


        Toast.makeText(Otp.this , String.valueOf(pin) ,Toast.LENGTH_SHORT ).show();


        otp1 = (EditText) findViewById(R.id.otp1);
        otp2 = (EditText) findViewById(R.id.otp2);
        otp3 = (EditText) findViewById(R.id.otp3);
        otp4 = (EditText) findViewById(R.id.otp4);

        otp1.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.length()==1)
                {

                    otp1.clearFocus();
                    otp2.requestFocus();
                    otp2.setCursorVisible(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
            otp2.addTextChangedListener(new TextWatcher()
            {
                @Override
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                }

                @Override
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                otp2.clearFocus();
                    otp3.requestFocus();
                    otp3.setCursorVisible(true);
                }

                @Override
                public void afterTextChanged(Editable s) {

                }
            });
        otp3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            otp3.clearFocus();
                otp4.requestFocus();
                otp4.setCursorVisible(true);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        otp4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() == 1)
                {
                    String value1 = otp1.getText().toString();
                    String value2 = otp2.getText().toString();
                    String value3 = otp3.getText().toString();
                    String value4 = otp4.getText().toString();

                    String final_pin = value1+value2+value3+value4;

                    int finl_pin = Integer.parseInt(final_pin);
                    if(finl_pin == pin)
                    {
                        Intent i = new Intent(Otp.this , ResetPassword.class);

                        i.putExtra("mobile" , mobile );
                        startActivity(i);
                        finish();
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        }


}
