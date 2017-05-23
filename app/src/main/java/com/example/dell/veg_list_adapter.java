package com.example.dell;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.example.dell.recipecup.HomeActivity;
import com.example.dell.recipecup.R;
import com.example.dell.recipecup.Select_veg_ingredient;

import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by admin on 29-04-2017.
 */

public class veg_list_adapter extends RecyclerView.Adapter<veg_list_view_holder> {


    ArrayList<String> list;

    Activity a;

    public veg_list_adapter(ArrayList<String> list , Activity a)
    {
        this.list = list ;
         this.a = a ;
    }


    @Override
    public veg_list_view_holder onCreateViewHolder(ViewGroup parent, int viewType) {

        veg_list_view_holder v = new veg_list_view_holder(LayoutInflater.from(a).inflate(R.layout.veg_list_cell,parent , false));

        return  v ;
    }

    @Override
    public void onBindViewHolder(final veg_list_view_holder holder, int position) {

        holder.checkBox.setText(list.get(position));

        holder.checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {

                   HomeActivity.sel_list +=","+holder.checkBox.getText().toString();

                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
