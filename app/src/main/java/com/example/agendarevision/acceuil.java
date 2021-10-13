package com.example.agendarevision;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.agendarevision.Adapters.AdapterMdp;
import com.example.agendarevision.Entite.Model;

import java.util.ArrayList;
import java.util.List;

public class acceuil extends Fragment {
    private AppDataBase dataBase;
    //private ListeAmisAdapter mAdapter;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager manager;
    private List<Model> myDataSet = new ArrayList<Model>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.activity_acceuil,container,false);
        dataBase = AppDataBase.getAppDatabase(getActivity().getApplicationContext());
        recyclerView = view.findViewById(R.id.my_recycler_view);
        manager = new GridLayoutManager(getActivity(),1);
        recyclerView.setLayoutManager(manager);
        Context mContext = getActivity().getApplicationContext();

        myDataSet = dataBase.userDao().getAll();
        mAdapter = new AdapterMdp(mContext,myDataSet);
        recyclerView.setAdapter(mAdapter);

        return  view;
    }
}