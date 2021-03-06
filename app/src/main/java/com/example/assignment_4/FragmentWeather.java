package com.example.assignment_4;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.assignment_4.Room.AppDatabase;
import com.example.assignment_4.Room.City;
import com.example.assignment_4.Room.DaoClass;
import com.example.assignment_4.Room.Weather;
import com.example.assignment_4.placeholder.PlaceholderContent;

import java.util.List;

/**
 * A fragment representing a list of Items.
 */
public class FragmentWeather extends Fragment {

    // TODO: Customize parameters
    private int mColumnCount = 1;

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static FragmentWeather newInstance(int columnCount) {
        FragmentWeather fragment = new FragmentWeather();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public FragmentWeather() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_weather_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            AppDatabase db = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "Weather").allowMainThreadQueries().build();
            DaoClass cityDao = db.daoClass();
            List<Weather> weathers =cityDao.AllRecord();
            Log.d("TAG",weathers.toString()+"Weather INFO");
            MyItemRecyclerViewAdapter adapter = new MyItemRecyclerViewAdapter(weathers);
            recyclerView.setAdapter(adapter);
        }
        return view;
    }
}