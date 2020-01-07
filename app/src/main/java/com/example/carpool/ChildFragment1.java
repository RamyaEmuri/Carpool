package com.example.carpool;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ChildFragment1 extends Fragment {
    ArrayList<Data1> dataset1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.childfragment1, container, false);

        RecyclerView recycler_view_1 = view.findViewById(R.id.recycler_view_1);




        dataset1= new ArrayList<>();
        dataset1.add(new Data1("Jared Leto","Just Created a Trip","2 hours ago","Summer vacation trip to Alabama",R.drawable.person31));
        dataset1.add(new Data1("Jared Leto","Just created a ride now","2 hours ago","Holiday visit to Singapur",R.drawable.person21));
        dataset1.add(new Data1("Jared Leto","Updating status","2 mins ago","Holiday Trip to Ooty",R.drawable.person31));
        dataset1.add(new Data1("Anvar Mehtha","Updated status","3 hours ago"," Trip to Singapur",R.drawable.person41));
        dataset1.add(new Data1("Joshesph P Joy","Updated status","2 hours ago","Holiday visit to Nallamala",R.drawable.person21));
        dataset1.add(new Data1("David Villa","Updated status","2 hours ago","Holiday Trip to Amazon Forest",R.drawable.person31));

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        CustomerAdapter1 objAdapter1 = new CustomerAdapter1(dataset1);
        recycler_view_1.setLayoutManager(linearLayoutManager);
        recycler_view_1.setAdapter(objAdapter1);

        return view;
    }
}
