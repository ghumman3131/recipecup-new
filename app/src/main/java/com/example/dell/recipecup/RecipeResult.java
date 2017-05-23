package com.example.dell.recipecup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.dell.AppController;
import com.example.dell.radapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class RecipeResult extends AppCompatActivity {

    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_result);

        rv = (RecyclerView) findViewById(R.id.rview);
        rv.setLayoutManager(new LinearLayoutManager(RecipeResult.this, LinearLayoutManager.VERTICAL, false));

        if (getIntent().getStringExtra("search_by").equals("by_name")) {
            get_data();
        } else {
            get_data2();
        }


    }

    public void get_data() {
        JSONObject job = new JSONObject();

        String result = getIntent().getStringExtra("key");

        try {
            job.put("key_id", result);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        System.out.println(job);

        JsonObjectRequest jreq = new JsonObjectRequest("http://" + Ipaddress.ip + "/resultrecipe.php", job, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                System.out.println(response);
                JSONArray jarr = null;
                try {
                    jarr = response.getJSONArray("result");
                    radapter ra = new radapter(jarr, RecipeResult.this);
                    rv.setAdapter(ra);
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
        jreq.setRetryPolicy(new DefaultRetryPolicy(2000, 2, 2));
        AppController app = new AppController(RecipeResult.this);
        app.addToRequestQueue(jreq);


    }

    public void get_data2() {
        JSONObject job = new JSONObject();

        String result = getIntent().getStringExtra("key");

        try {
            job.put("key_id", result);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        System.out.println(job);
        JsonObjectRequest jreq = new JsonObjectRequest("http://" + Ipaddress.ip + "/resultrecipe2.php", job, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                System.out.println(response);
                JSONArray jarr = null;
                try {
                    jarr = response.getJSONArray("result");
                    radapter ra = new radapter(jarr, RecipeResult.this);
                    rv.setAdapter(ra);
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
        jreq.setRetryPolicy(new DefaultRetryPolicy(2000, 2, 2));
        AppController app = new AppController(RecipeResult.this);
        app.addToRequestQueue(jreq);


    }


}
