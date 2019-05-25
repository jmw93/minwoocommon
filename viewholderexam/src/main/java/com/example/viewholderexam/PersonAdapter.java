package com.example.viewholderexam;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

    public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {
    interface OnPersonClickListener {
        void onPersonClicked(Person model);
    }

    private OnPersonClickListener mListener;

    private List<Person> mItems = new ArrayList<>();

    public PersonAdapter() {
    }

    public PersonAdapter(OnPersonClickListener listener) {
        mListener = listener;
    }

    public void setItems(List<Person> items) {
        this.mItems = items;
        
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_person, parent, false);
        final PersonViewHolder viewHolder = new PersonViewHolder(view);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    final Person item = mItems.get(viewHolder.getAdapterPosition());
                    mListener.onPersonClicked(item);
                }
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
        Person item = mItems.get(position);

        holder.age.setText(item.getAge());
        holder.name.setText(item.getName());

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        TextView age;

        public PersonViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name_text);
            age = itemView.findViewById(R.id.age_text);
        }
    }
}
