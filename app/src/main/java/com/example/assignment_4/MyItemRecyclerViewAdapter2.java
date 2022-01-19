package com.example.assignment_4;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.assignment_4.Room.City;
import com.example.assignment_4.placeholder.PlaceholderContent.PlaceholderItem;
import com.example.assignment_4.databinding.FragmentCityBinding;

import java.util.List;


public class MyItemRecyclerViewAdapter2 extends RecyclerView.Adapter<MyItemRecyclerViewAdapter2.ViewHolder> {

    private  List<City> city;

    public MyItemRecyclerViewAdapter2(List<City> items) {
        this.city = items;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(FragmentCityBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {


        City obj = city.get(position);
        holder.id.setText(String.valueOf(obj.getId()));
        holder.cityname.setText(obj.getCity());


    }

    @Override
    public int getItemCount() {
        return city.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public  TextView id;
        public  TextView cityname;

        public ViewHolder(FragmentCityBinding binding) {
            super(binding.getRoot());
            id = (TextView) binding.cid;
            cityname =(TextView) binding.cityName;
        }

    }
}