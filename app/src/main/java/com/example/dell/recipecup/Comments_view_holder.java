package com.example.dell.recipecup;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by admin on 19-05-2017.
 */

class Comments_view_holder extends RecyclerView.ViewHolder {

    public TextView user_name , comment ;

    public Comments_view_holder(View itemView) {
        super(itemView);

        user_name = (TextView) itemView.findViewById(R.id.user_name_id);
        comment = (TextView) itemView.findViewById(R.id.comment_id);

    }
}
