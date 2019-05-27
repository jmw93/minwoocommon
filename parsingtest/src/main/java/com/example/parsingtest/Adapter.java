package com.example.parsingtest;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

 class Adapter extends RecyclerView.Adapter<Adapter.TourViewHolder> {



    private ArrayList<Tour> mItems = new ArrayList<Tour>();

    public void setItems(ArrayList<Tour> items) {
        this.mItems = items;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TourViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tour_item, parent, false);
        final TourViewHolder viewHolder = new TourViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull TourViewHolder holder, int position) {
        Tour item = mItems.get(position);
        if(item !=null) {
            holder.name.setText(item.getName());
            holder.address.setText(item.getAddress());
            holder.imageView.setImageBitmap(item.getBitmap());
        }
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public static class TourViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView address;
        ImageView imageView;
        public TourViewHolder(@NonNull View itemView) {
            super(itemView);

            name=itemView.findViewById(R.id.name);
            address=itemView.findViewById(R.id.address);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}