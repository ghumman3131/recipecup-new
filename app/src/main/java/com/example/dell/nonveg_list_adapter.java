
package com.example.dell;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.CompoundButton;

import com.example.dell.recipecup.HomeActivity;
import com.example.dell.recipecup.R;

import java.util.ArrayList;

/**
 * Created by admin on 30-04-2017.
 */

public class nonveg_list_adapter extends RecyclerView.Adapter<nonveg_list_view_holder> {


    ArrayList<String> list;

    Activity a;

    public nonveg_list_adapter(ArrayList<String> list , Activity a)
    {
        this.list = list ;
        this.a = a ;
    }


    @Override
    public nonveg_list_view_holder onCreateViewHolder(ViewGroup parent, int viewType) {

        nonveg_list_view_holder v = new nonveg_list_view_holder(LayoutInflater.from(a).inflate(R.layout.nonveg_list_cell,parent , false));

        return  v ;
    }

    @Override
    public void onBindViewHolder(final nonveg_list_view_holder holder, int position) {

        holder.checkBoxn.setText(list.get(position));
        holder.checkBoxn.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked)
                {

                    HomeActivity.sel_list +=","+holder.checkBoxn.getText().toString();

                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
