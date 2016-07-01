package com.warriorminds.recyclerviewbug;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.common.collect.Lists;

import java.util.List;

/**
 * Created by rodrigo.guerrero on 7/1/2016.
 */
public class MyAdapter extends RecyclerView.Adapter<MyHolder> {

    private List<MyObject> objectList, items;

    public MyAdapter() {
        objectList = Lists.newArrayList();
        items = Lists.newArrayList();
        MyObject existingObject = new MyObject("Always here", "This item is always in the list");
        items.add(existingObject);
    }

    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        MyObject myObject = items.get(position);
        holder.description.setText(myObject.getDescription());
        holder.title.setText(myObject.getTitle());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addObjects(List<MyObject> objects) {
        this.objectList.addAll(objects);
    }

    public void addItems(List<MyObject> items) {
        this.items.addAll(items);
    }

    public void clearList() {
        if (objectList.size() > 0) {
            items.removeAll(objectList);
            notifyItemRangeRemoved(getItemCount(), objectList.size());
            objectList.clear();
        }
    }

    public void refreshList() {
        int firstElement = getItemCount();
        addItems(objectList);
        notifyItemRangeInserted(firstElement, objectList.size());
        //notifyDataSetChanged(); // this one works.
    }
}