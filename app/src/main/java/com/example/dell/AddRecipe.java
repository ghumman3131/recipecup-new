package com.example.dell;

import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.dell.recipecup.HomeActivity;
import com.example.dell.recipecup.Ipaddress;
import com.example.dell.recipecup.R;
import com.example.dell.recipecup.Select_non_veg_ingredient;
import com.example.dell.recipecup.Select_veg_ingredient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class AddRecipe extends AppCompatActivity {

    private EditText rname , steps_et , ingredients_et ;

    RadioButton veg_radio , non_veg_radio ;

    public static String ingredients = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);

        HomeActivity.sel_list = "";


        ingredients_et = (EditText) findViewById(R.id.sel_ingredient);

        veg_radio = (RadioButton) findViewById(R.id.veg_radio);

        non_veg_radio = (RadioButton) findViewById(R.id.non_veg_radio);

        rname = (EditText) findViewById(R.id.recipe_id);

        steps_et = (EditText) findViewById(R.id.steps_id);

    }

    public void select_ingredient(View view)
    {



        if(veg_radio.isChecked())
        {
            Intent i = new Intent(AddRecipe.this , Select_veg_ingredient.class);
            i.putExtra("from" , "select");

            startActivity(i);

        }
       else   if(non_veg_radio.isChecked())
        {
            Intent i = new Intent(AddRecipe.this , Select_non_veg_ingredient.class);

            i.putExtra("from" , "select");

            startActivity(i);
        }

        else {
            Toast.makeText(AddRecipe.this , "Please Select Recipe Type" , Toast.LENGTH_SHORT).show();
        }


    }

    public void add_recipe(View view) {

        String recipename = rname.getText().toString();
        final String steps = steps_et.getText().toString();


        if(recipename.equals(""))
        {


            Toast.makeText(AddRecipe.this , "Enter The Name Of Recipe" , Toast.LENGTH_SHORT).show();



            return;
        }


        if(!veg_radio.isChecked() && ! non_veg_radio.isChecked()) {
            Toast.makeText(AddRecipe.this , "Please Select Recipe Type" , Toast.LENGTH_SHORT).show();
        }
        if(steps.equals(""))
        {


            Toast.makeText(AddRecipe.this , "Enter The Procedure To Make Recipe" , Toast.LENGTH_SHORT).show();



            return;
        }

        JSONObject jobj = new JSONObject();

        SharedPreferences sp = getSharedPreferences("user_info", MODE_PRIVATE);
        sp.getString("user_email", "");

        try {

            jobj.put("name_k" , recipename);
            jobj.put("stepss_k" , steps);
            jobj.put("ingredient" , HomeActivity.sel_list);
            jobj.put("recipe_by" , sp.getString("user_email", ""));
            if(veg_radio.isChecked()) {
                jobj.put("type" , "veg");
            }

            if(non_veg_radio.isChecked())
            {
                jobj.put("type" , " non veg");
            }

        }
        catch (JSONException e)
        {
            e.printStackTrace();
        }

        System.out.println(jobj);

        JsonObjectRequest jobjreq = new JsonObjectRequest("http://"+ Ipaddress.ip+"/addrecipe.php", jobj, new Response.Listener<JSONObject>() {


            @Override
            public void onResponse(JSONObject response) {

                System.out.println(response);

                try {
                    if(response.getString("key").equals("0 "))
                    {
                        Toast.makeText(AddRecipe.this ,"Recipe Already Exists" , Toast.LENGTH_SHORT).show();

                    }
                    else if(response.getString("key").equals("1")) {
                        Toast.makeText(AddRecipe.this ,"Done" , Toast.LENGTH_SHORT).show();
                        rname.getText().clear();
                        HomeActivity.sel_list = "";
                        ingredients_et.getText().clear();

                        steps_et.getText().clear();

                    }

                    else
                    {
                        Toast.makeText(AddRecipe.this ,"Error" , Toast.LENGTH_SHORT).show();

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

        jobjreq.setRetryPolicy(new DefaultRetryPolicy(20000, 3 , 2));

        AppController app = new AppController(AddRecipe.this);

        app.addToRequestQueue(jobjreq);

    }

    @Override
    protected void onResume() {
        super.onResume();
        ingredients_et.setText(HomeActivity.sel_list);
        System.out.println(HomeActivity.sel_list);
    }
    public void home (View v)
    {
        Intent j= new Intent(AddRecipe.this, HomeActivity.class);
        startActivity(j);
    }

}
