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

public class ChildFragment2 extends Fragment {

    ArrayList<Data2> dataset;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view1 = inflater.inflate(R.layout.childfragment2, container, false);

        RecyclerView recycler_view_2 = view1.findViewById(R.id.recycler_view_2);

        dataset= new ArrayList<>();
        dataset.add(new Data2("ONGOING","Summer Vacation","Los Angeles-Alabama", R.drawable.radiobuttonicon));
        dataset.add(new Data2("UPCOMING","Work Trip","Los Angeles-Alabama", R.drawable.radiobuttonicon1));
        dataset.add(new Data2("EXPIRED","Winter Soldier","Los Angeles-Alabama", R.drawable.radiobuttonicon2));


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        CustomerAdapter2 objAdapter2 = new CustomerAdapter2(dataset);
        recycler_view_2.setLayoutManager(linearLayoutManager);
        recycler_view_2.setAdapter(objAdapter2);
        return view1;
    }
}
