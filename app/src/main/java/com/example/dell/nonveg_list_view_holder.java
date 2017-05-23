package com.example.dell;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;

import com.example.dell.recipecup.R;

/**
 * Created by admin on 30-04-2017.
 */

public class nonveg_list_view_holder extends RecyclerView.ViewHolder
{

    public CheckBox checkBoxn;

    public nonveg_list_view_holder(View itemView) {
        super(itemView);

        checkBoxn = (CheckBox) itemView.findViewById(R.id.checkbox_nv);
    }
}
