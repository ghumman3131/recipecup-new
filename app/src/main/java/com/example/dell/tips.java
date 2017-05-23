package com.example.dell;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.dell.recipecup.Ipaddress;
import com.example.dell.recipecup.R;
import com.example.dell.recipecup.RecipeResult;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class tips extends AppCompatActivity {

    RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        rv = (RecyclerView) findViewById(R.id.tips_rv);
        rv.setLayoutManager(new LinearLayoutManager(tips.this, LinearLayoutManager.VERTICAL, false));
        get_data();
    }

    public void get_data() {


        JSONObject job = new JSONObject();


        try {
            job.put("tip_key", getIntent().getStringExtra("tip"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        JsonObjectRequest jreq = new JsonObjectRequest("http://" + Ipaddress.ip + "/get_tips.php", job, new Response.Listener<JSONObject>() {

            @Override
            public void onResponse(JSONObject response) {
                System.out.println(response);

                JSONArray jarr = null;
                try {
                    jarr = response.getJSONArray("result");
                    tips_adapter ra = new tips_adapter(jarr, tips.this);
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
        AppController app = new AppController(tips.this);
        app.addToRequestQueue(jreq);


    }
}

