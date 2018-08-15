package com.geekhouze.qwikbuy;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {

    private ArrayList<String> mDataset;

    public ItemsAdapter(ArrayList<String> mDataset) {
        this.mDataset = mDataset;

    }

    @Override
    public ItemsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_item, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        //public TextView mTitle;


        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
           // mTitle = (TextView) itemView.findViewById(R.id.title);

        }



        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(), "position = " + getLayoutPosition(), Toast.LENGTH_SHORT).show();
            //Intent intent = new Intent(v.getContext(), ItemsActivity.class);
            //v.getContext().startActivity(intent);


        }
    }

    @Override
    public void onBindViewHolder(ItemsAdapter.ViewHolder holder, int position) {
        //holder.mTitle.setText(mDataset.get(position));

    }




}
