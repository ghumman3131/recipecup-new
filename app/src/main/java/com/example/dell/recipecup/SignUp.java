package com.example.dell.recipecup;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.dell.AppController;

import org.json.JSONException;
import org.json.JSONObject;


public class
SignUp extends AppCompatActivity {

    private EditText uname_et ,dateofbirth,  mobileno_et , emailId_et , passwordd_et , confirmpass_et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_sign_up);



            uname_et = (EditText) findViewById(R.id.username_et);
            dateofbirth= (EditText) findViewById(R.id.dob);
            mobileno_et = (EditText) findViewById(R.id.mobile_et);
            emailId_et = (EditText) findViewById(R.id.email_et);
            passwordd_et = (EditText) findViewById(R.id.password_et);
            confirmpass_et = (EditText) findViewById(R.id.confirm_et);


        }

    public void signup(View v)
    {
        String name = uname_et.getText().toString();
        String dob = dateofbirth.getText().toString();
        String mobile = mobileno_et.getText().toString();
        String email = emailId_et.getText().toString();
        String password = passwordd_et.getText().toString();
        String confirm = confirmpass_et.getText().toString();
        String pattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[!@#$%^&*+=?-]).{8,15}$";


        if(name.length() < 4 || !name.matches("[a-zA-Z ]+"))
        {

            Toast.makeText(SignUp.this, "name must be 4 character long and not contain any digits", Toast.LENGTH_SHORT).show();
            return;
        }
        if(dob.equals(""))
        {


            Toast.makeText(SignUp.this , "Enter Your Date Of Birth" , Toast.LENGTH_SHORT).show();



            return;
        }
        if(mobile.length() < 10)
        {
            Toast.makeText(SignUp.this , "Mobile Number Must Be 10 digits" , Toast.LENGTH_SHORT).show();
            return;
        }



        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches() || email.contains("_"))
        {
            Toast.makeText(SignUp.this , "please enter valid email type" , Toast.LENGTH_SHORT).show();
            return;
        }

        if(!password.matches(pattern) || password.length() < 8)
        {
            Toast.makeText(SignUp.this, "password must contain atleast one alphabet , digit , special character and length must be 8 character", Toast.LENGTH_SHORT).show();
            return;
        }

        if(confirm.equals(""))
        {


            Toast.makeText(SignUp.this , "Re-Enter Password" , Toast.LENGTH_SHORT).show();



            return;
        }



        if ( !password.equals(confirm))
        {
            Toast.makeText(SignUp.this , "Passwords Do Not Match" , Toast.LENGTH_SHORT).show();
        }



        JSONObject jobj = new JSONObject();

        try {
            jobj.put("name_key" , name);
            jobj.put("dob_key" , dob);
            jobj.put("mobile_key" , mobile);
            jobj.put("email_key" , email);
            jobj.put("password_key" , password);
            }
        catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jobjreq = new JsonObjectRequest("http://"+Ipaddress.ip+"/signup.php",
                jobj, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    if(response.getString("key").equals("0"))
                    {
                        Toast.makeText(SignUp.this ,"Email Already Registered" , Toast.LENGTH_SHORT).show();

                    }
                    else if(response.getString("key").equals("1")) {
                        Toast.makeText(SignUp.this ,"Done" , Toast.LENGTH_SHORT).show();

                    }

                    else
                    {
                        Toast.makeText(SignUp.this ,"Error" , Toast.LENGTH_SHORT).show();

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                System.out.println();
            }
        });

        jobjreq.setRetryPolicy(new DefaultRetryPolicy(20000, 3 , 2));

        AppController app = new AppController(SignUp.this);

        app.addToRequestQueue(jobjreq);

    }

}
