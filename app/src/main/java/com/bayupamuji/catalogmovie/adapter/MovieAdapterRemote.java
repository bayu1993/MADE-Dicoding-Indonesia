package com.bayupamuji.catalogmovie.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bayupamuji.catalogmovie.R;
import com.bayupamuji.catalogmovie.data.DataMovie;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapterRemote extends RecyclerView.Adapter<ViewHolder> {
    private final Context context;
    private final List<DataMovie> dataMovies = new ArrayList<>();
    private final ItemClickListener itemClickListener;

    public MovieAdapterRemote(Context context, ItemClickListener itemClickListener) {
        this.context = context;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        final DataMovie data = dataMovies.get(i);
        viewHolder.bind(data,context);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemClickListener.onItemClick(data);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataMovies.size();
    }

    public void updateMovie(List<DataMovie> dataMovie){
        this.dataMovies.clear();
        this.dataMovies.addAll(dataMovie);
        notifyDataSetChanged();
    }

}