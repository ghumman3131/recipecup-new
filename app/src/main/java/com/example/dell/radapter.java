package com.example.dell;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.dell.recipecup.R;
import com.example.dell.recipecup.recipe_details;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by admin on 06-05-2017.
 */

public class radapter extends RecyclerView.Adapter<rviewholder> {

    JSONArray jarr;
    Activity a;

    public radapter(JSONArray jarr , Activity a) {

        this.jarr = jarr;
        this.a = a;

    }

    @Override
    public rviewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        rviewholder v = new rviewholder(LayoutInflater.from(a).inflate(R.layout.rcell , parent, false));

        return v;
    }

    @Override
    public void onBindViewHolder(rviewholder holder, int position) {

        try {
            final JSONObject job = jarr.getJSONObject(position);
            holder.t.setText(job.getString("R_Name"));

            holder.t.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(a,recipe_details.class);
                    try {
                        i.putExtra("recipe_id" , job.getString("R_Id"));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    a.startActivity(i);

                }
            });

        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount()
    {

        return  jarr.length();
    }
}
