package com.example.dell.recipecup;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.dell.AppController;
import com.example.dell.ForgotPassword;

import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity

{
    EditText userNameBox, passwordBox;

    TextView show_hide_pass ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userNameBox = (EditText) findViewById(R.id.un);

        passwordBox = (EditText) findViewById(R.id.pass);

        show_hide_pass = (TextView) findViewById(R.id.show_hide_pass);
        passwordBox.setTransformationMethod(new PasswordTransformationMethod());


        show_hide_pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(show_hide_pass.getText().toString().equals("SHOW"))
                {
                    passwordBox.setTransformationMethod(null);
                    show_hide_pass.setText("HIDE");
                    }
                else {
                    passwordBox.setTransformationMethod(new PasswordTransformationMethod());

                    show_hide_pass.setText("SHOW");
                }
            }
        });

    }


    public void fp(View v) {
        Intent j = new Intent(MainActivity.this, ForgotPassword.class);
        startActivity(j);
    }

    public void newuser(View v) {
        Intent k = new Intent(MainActivity.this, SignUp.class);
        startActivity(k);
    }

    public void logg(View v) {
        final String UserName = userNameBox.getText().toString();
        String Password = passwordBox.getText().toString();
        if (UserName.equals("")) {
            Toast.makeText(MainActivity.this, "Please Enter Your email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (Password.equals("")) {
            Toast.makeText(MainActivity.this, "Please Enter Your Password", Toast.LENGTH_SHORT).show();
            return;
        }


        JSONObject js = new JSONObject();
        try {
            js.put("name", UserName);
            js.put("pas", Password);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        JsonObjectRequest jobjreq = new JsonObjectRequest("http://" + Ipaddress.ip + "/recipeLogin.php", js, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                System.out.println(response);
                try {
                    if (response.getString("pass_key").equals("Password Matched")) {

                        SharedPreferences.Editor sp = getSharedPreferences("user_info", MODE_PRIVATE).edit();
                        sp.putString("user_email", UserName);
                        sp.putString("user_id" , response.getString("user_id"));
                        sp.commit();
                        Intent i = new Intent(MainActivity.this, HomeActivity.class);
                        startActivity(i);


                    } else if (response.get("pass_key").equals("Enter Correct Password")) {
                        Toast.makeText(MainActivity.this, "Please Enter Correct Password", Toast.LENGTH_SHORT).show();

                    } else {
                        Toast.makeText(MainActivity.this, "User Doesn't Exist", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error);

            }
        });

        jobjreq.setRetryPolicy(new DefaultRetryPolicy(20000, 3, 2));

        AppController ap = new AppController(MainActivity.this);
        ap.addToRequestQueue(jobjreq);


    }

}
