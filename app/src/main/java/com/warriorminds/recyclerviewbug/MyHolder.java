package com.warriorminds.recyclerviewbug;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by rodrigo.guerrero on 7/1/2016.
 */
public class MyHolder extends RecyclerView.ViewHolder {
    public TextView title, description;

    public MyHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.title);
        description = (TextView) itemView.findViewById(R.id.description);
    }
}
