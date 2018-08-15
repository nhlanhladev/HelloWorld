package com.geekhouze.qwikbuy;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.geekhouze.qwikbuy.cardview.Album;
import com.geekhouze.qwikbuy.item.ItemsActivity;

import java.util.List;

class DailyAdapter extends RecyclerView.Adapter<DailyAdapter.ViewHolder>{

    private List<Album> mDataset;

    public DailyAdapter(List<Album> mDataset) {
        this.mDataset = mDataset;
    }

    @Override
    public DailyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_pager, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(DailyAdapter.ViewHolder holder, int position) {

        holder.price.setText("R"+Integer.toString(mDataset.get(position).getThumbnail()));
        holder.oldPrice.setText("R"+Integer.toString(mDataset.get(position).getNumOfSongs()) );
        holder.date.setText(mDataset.get(position).getName());
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView price;
        public TextView oldPrice;
        public TextView date;


        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            price = (TextView) itemView.findViewById(R.id.mprice);
            oldPrice = (TextView) itemView.findViewById(R.id.moldPrice);
            date = (TextView) itemView.findViewById(R.id.mdate);
        }

        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(), "position = " + getLayoutPosition(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(v.getContext(), ItemsActivity.class);
            v.getContext().startActivity(intent);
        }
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }




}
