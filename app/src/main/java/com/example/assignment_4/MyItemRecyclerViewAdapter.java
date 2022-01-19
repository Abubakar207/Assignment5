package com.example.assignment_4;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.assignment_4.Room.Weather;
import com.example.assignment_4.databinding.FragmentCityBinding;
import com.example.assignment_4.placeholder.PlaceholderContent.PlaceholderItem;
import com.example.assignment_4.databinding.FragmentWeatherBinding;

import java.util.List;


public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {
    private  List<Weather> weather;
    public MyItemRecyclerViewAdapter(List<Weather> weather) {
        this.weather = weather;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

    return new ViewHolder(FragmentWeatherBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
      Weather obj = weather.get(position);
      holder.city.setText(obj.getCityname());
      holder.temp.setText(obj.getTemperature());
      holder.press.setText(obj.getPressure());
      holder.hum.setText(obj.getHumidity());
      holder.date.setText(obj.getRecordDate());

    }

    @Override
    public int getItemCount() {
        return weather.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder {
        public  TextView id,city  ,temp ,press , hum , date;


        public ViewHolder(FragmentWeatherBinding binding) {
            super(binding.getRoot());
              city =binding.cityText;
              temp = binding.tempText;
              press =binding.pressureText;
              hum = binding.HumText;
              date = binding.dateText;
        }

    }

}