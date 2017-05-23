package com.example.dell;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.toolbox.JsonObjectRequest;
import com.example.dell.recipecup.R;
import com.example.dell.rviewholder;
import com.example.dell.tips;
import com.example.dell.tips_viewholder;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static com.example.dell.recipecup.R.id.parent;

/**
 * Created by admin on 11-05-2017.
 */

public class tips_adapter extends RecyclerView.Adapter<tips_viewholder>
{
        JSONArray jarr;
        Activity a;



    public tips_adapter(JSONArray jarr ,Activity a )
    {
        this.jarr = jarr ;
        this.a = a;
    }

    @Override
    public tips_viewholder onCreateViewHolder(ViewGroup parent, int viewType) {


        tips_viewholder tvt = new tips_viewholder(LayoutInflater.from(a).inflate(R.layout.tips_cell , parent , false));
        return tvt;
    }

    @Override
    public void onBindViewHolder(tips_viewholder holder, int position) {

        try {
            JSONObject job = jarr.getJSONObject(position);

            holder.tvt.setText(job.getString("tips"));

        }
        catch (JSONException e)
        {

            e.printStackTrace();
        }


    }

    @Override
    public int getItemCount()

    {

        return jarr.length();
    }
}

