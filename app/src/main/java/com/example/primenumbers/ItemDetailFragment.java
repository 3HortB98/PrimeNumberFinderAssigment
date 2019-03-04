package com.example.primenumbers;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.primenumbers.home.HomeContract;
import com.example.primenumbers.home.HomePresenter;
import com.example.primenumbers.model.PrimeAdapter;

import java.util.ArrayList;
import java.util.List;

public class ItemDetailFragment extends Fragment{
    PrimeAdapter primeAdapter = new PrimeAdapter();

    public static final String PRIMES_LIST = "primes_list";
    List<Integer> primes = new ArrayList<>();

    public ItemDetailFragment(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null && getArguments().containsKey(PRIMES_LIST)) {

            primes.addAll(getArguments().getIntegerArrayList(PRIMES_LIST));
        }

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.prime_detail_fragment, container, false);
        RecyclerView recyclerView = rootview.findViewById(R.id.rvData);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setAdapter(primeAdapter);
        primeAdapter.setData(primes);

        return rootview;


    }


}
