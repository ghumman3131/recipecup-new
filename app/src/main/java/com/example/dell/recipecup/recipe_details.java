package com.example.dell.recipecup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.dell.AppController;
import com.example.dell.SearchByRecipe;

import org.json.JSONException;
import org.json.JSONObject;


public class recipe_details extends AppCompatActivity {


    TextView r_name , r_type, r_ingredients, r_steps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_details);

        r_name = (TextView) findViewById(R.id.name_rd);
        r_type = (TextView) findViewById(R.id.type_rd);
        r_ingredients = (TextView) findViewById(R.id.ingredients_rd);
        r_steps = (TextView) findViewById(R.id.steps_rdd);
        rdetails();
    }

    public void rdetails ()
    {
        JSONObject js = new JSONObject();
        try {
            js.put("recipe_id", getIntent().getStringExtra("recipe_id"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        System.out.print(js);
        JsonObjectRequest jobreq = new JsonObjectRequest("http://" +Ipaddress.ip +"/recipedetails.php", js, new Response.Listener<JSONObject>() {

            public void onResponse(JSONObject response) {

                System.out.println(response);
                try {
                        String recipename1 = response.getString("R_Name");
                        String recipetype1 = response.getString("Type");
                        String ingredients1 = response.getString("Ingredients");
                        String steps1 = response.getString("Steps");
                        r_name.setText(recipename1);
                        r_type.setText(recipetype1);
                        r_ingredients.setText(ingredients1);
                        r_steps.setText(steps1);


                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener()
        {
            public void onErrorResponse(VolleyError error) {

                System.out.println(error);
            }

        });
        jobreq.setRetryPolicy(new DefaultRetryPolicy(20000, 2, 2));
        AppController app =new AppController(recipe_details.this);
        app.addToRequestQueue(jobreq);

    }



    public void back(View v)
    {
        Intent j= new Intent(recipe_details.this, SearchByRecipe.class);
        startActivity(j);
    }

    public void reviews(View view) {
        Intent j= new Intent(recipe_details.this, Comments.class);
        j.putExtra("r_id" , getIntent().getStringExtra("recipe_id"));
        startActivity(j);

    }
}
