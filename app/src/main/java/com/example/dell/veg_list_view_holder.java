package com.example.dell;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;

import com.example.dell.recipecup.R;

/**
 * Created by admin on 29-04-2017.
 */

public class veg_list_view_holder extends RecyclerView.ViewHolder {

    public CheckBox checkBox;

    public veg_list_view_holder(View itemView) {
        super(itemView);

        checkBox = (CheckBox) itemView.findViewById(R.id.checkbox_id);
    }
}
