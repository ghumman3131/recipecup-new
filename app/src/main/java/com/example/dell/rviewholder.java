package com.example.dell;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.dell.recipecup.R;

/**
 * Created by admin on 06-05-2017.
 */

public class rviewholder extends RecyclerView.ViewHolder {

        TextView t;


    public rviewholder(View itemView) {
        super(itemView);


        t = (TextView) itemView.findViewById(R.id.textcell);
    }
}
