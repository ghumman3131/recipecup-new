package com.example.dell;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.dell.recipecup.R;

/**
 * Created by admin on 11-05-2017.
 */

public class tips_viewholder extends RecyclerView.ViewHolder{

    TextView tvt;


    public tips_viewholder(View itemView)
        {
        super(itemView);


        tvt = (TextView) itemView.findViewById(R.id.tipscell);
    }
}
