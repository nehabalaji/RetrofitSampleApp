package com.example.retrofitsampleapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.retrofitsampleapp.R;
import com.example.retrofitsampleapp.model.Movie;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>{

    Context context;
    List<Movie> movieList;

    public RecyclerViewAdapter(Context mContext, List<Movie> mMovieList){
        this.context = mContext;
        this.movieList = mMovieList;
    }

    public void setMovieList(List<Movie> mMovieList){
        this.movieList = mMovieList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title.setText(movieList.get(position).getTitle());
        Glide.with(context).load(movieList.get(position).getImageUrl()).apply(RequestOptions.centerCropTransform()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        if(movieList != null){
            return movieList.size();
        }
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView title;
        ImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.title);
            image = (ImageView) itemView.findViewById(R.id.image);
        }
    }
}
