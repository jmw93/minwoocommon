package com.example.listview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listview = (ListView) findViewById(R.id.listView);
        singerAdapter singerAdapter = new singerAdapter();
        singerAdapter.addItem(new Singer("소녀시대","010-4505-9221"));
        singerAdapter.addItem(new Singer("소녀시대","010-4505-9221"));
        singerAdapter.addItem(new Singer("소녀시대","010-4505-9221"));
        singerAdapter.addItem(new Singer("소녀시대","010-4505-9221"));
        singerAdapter.addItem(new Singer("소녀시대","010-4505-9221"));
        singerAdapter.addItem(new Singer("소녀시대","010-4505-9221"));
        singerAdapter.addItem(new Singer("소녀시대","0103-4505-9221"));

        listview.setAdapter(singerAdapter);

    }




    class singerAdapter extends BaseAdapter{
        ArrayList<Singer> mdata = new ArrayList<Singer>();
        @Override
        public int getCount() {
            return mdata.size();
        }

        public void addItem(Singer item){
            mdata.add(item);
        }

        @Override
        public Object getItem(int position) {
            return mdata.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            SignerItemView view =new SignerItemView(getApplicationContext());

            Singer item = mdata.get(position);
            view.setName(item.getName());
            view.setMobile(item.getMobile());



            return view;
        }
    }


}
