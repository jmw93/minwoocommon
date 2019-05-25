package com.example.xmlpullparsing;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.ViewHolder> {
    @NonNull
    ArrayList<Employee> items = new ArrayList<>();

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View itemView = inflater.inflate(R.layout.employeeadapter , viewGroup , false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Employee item = items.get(position);
        viewHolder.setItem(item);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void addItems (ArrayList<Employee> items) {
        this.items=items;
    }

    public void addItem(Employee item){
        items.add(item);
    }

    public Employee getItem(int position){
        return items.get(position);

    }

    public void setItem(int position, Employee item){
        items.set(position,item);
    }
    static class ViewHolder extends RecyclerView.ViewHolder{

            TextView textView_ID;
            TextView textView_Name;
            TextView textView_Salary;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
           textView_ID = itemView.findViewById(R.id.textView_ID);
            textView_Name = itemView.findViewById(R.id.textView_Name);
           textView_Salary = itemView.findViewById(R.id.textView_Salary);
        }


        public void setItem(Employee item){
            textView_ID.setText(item.getId());
            textView_Name.setText(item.getName());
            textView_Salary.setText(item.getSalary());
        }
    }
}
