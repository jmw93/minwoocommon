package com.example.listviewexample;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Myfirstadapter extends BaseAdapter {

    private final List<Weather> mData;
    private Map<String,Integer> mWeatherImageMap;
    public Myfirstadapter(List data){
        mData = data;
        mWeatherImageMap = new HashMap<>();
        mWeatherImageMap.put("맑음",R.drawable.sunny);

    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder holder;
        if(convertView ==null) {
            holder = new viewHolder();
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_weather, parent, false);
            TextView cityText = convertView.findViewById(R.id.city);
            TextView tempText = convertView.findViewById(R.id.temp);
            ImageView weatherImage = convertView.findViewById(R.id.imageView);
            holder.cityText = cityText;
            holder.tempText = tempText;
            holder.weatherImage = weatherImage;
            }else{
            holder = (viewHolder) convertView.getTag();
            }
            Weather weather = mData.get(position);
            holder.cityText.setText(weather.getCity().toString());
            holder.tempText.setText(weather.getTemp().toString());
            holder.weatherImage.setImageResource(mWeatherImageMap.get(weather.getWeather()));

        return convertView;
    }

    public class viewHolder{
        ImageView weatherImage;
        TextView cityText;
        TextView tempText;
    }
}
