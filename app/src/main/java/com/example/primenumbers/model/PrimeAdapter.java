package com.example.primenumbers.model;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.primenumbers.R;

import java.util.ArrayList;
import java.util.List;

public class PrimeAdapter extends RecyclerView.Adapter<PrimeAdapter.ItemViewHolder>{

    private final List<Integer> data;

    public PrimeAdapter(){
        this.data = new ArrayList<>();
    }
    public void setData (List<Integer> newData){
        data.clear();
        data.addAll(newData);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View rootView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.number_pass,viewGroup,false);
        return new ItemViewHolder(rootView);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int position) {
        //Integer num = data.get(position);
        itemViewHolder.tvPrime.setText(data.get(position).toString());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView tvPrime;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            tvPrime = itemView.findViewById(R.id.tvPrimeNum);
        }
    }
}
