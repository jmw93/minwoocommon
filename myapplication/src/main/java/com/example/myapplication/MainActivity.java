package com.example.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView= findViewById(R.id.recyclerView);
        PersonAdapter adapter = new PersonAdapter();

        recyclerView.setAdapter(adapter);

        List<Person> people = new ArrayList<>();
        people.add(new Person("김길동","10"));
        people.add(new Person("김길동","10"));
        people.add(new Person("김길동","10"));
        people.add(new Person("김길동","10"));
        adapter.setItems(people);
    }
   private static class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {

       

       
       private List<Person> mItems = new ArrayList<>();
   
       public PersonAdapter() {}
   

   
       public void setItems(List<Person> items) {
           this.mItems = items;
           notifyDataSetChanged();
       }
   
       @NonNull
       @Override
       public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
           View view = LayoutInflater.from(parent.getContext())
                   .inflate(R.layout.item_person, parent, false);
           final PersonViewHolder viewHolder = new PersonViewHolder(view);
           return viewHolder;
       }
   
       @Override
       public void onBindViewHolder(@NonNull PersonViewHolder holder, int position) {
           Person item = mItems.get(position);

           holder.name.setText(item.getName());
           holder.age.setText(item.getAge());
           // TODO : 데이터를 뷰홀더에 표시하시오
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
               // TODO : 뷰홀더 완성하시오
            name = (TextView)itemView.findViewById(R.id.name_text);
               age = (TextView)itemView.findViewById(R.id.name_age);

           }
       }
   }
}
