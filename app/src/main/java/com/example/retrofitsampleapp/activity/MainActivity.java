package com.example.retrofitsampleapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.retrofitsampleapp.R;
import com.example.retrofitsampleapp.adapter.RecyclerViewAdapter;
import com.example.retrofitsampleapp.model.Movie;
import com.example.retrofitsampleapp.network.ApiClient;
import com.example.retrofitsampleapp.network.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    List<Movie> movieList;
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieList = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerViewAdapter = new RecyclerViewAdapter(getApplicationContext(), movieList);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setHasFixedSize(true);

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<List<Movie>> call = apiService.getMovies();
        call.enqueue(new Callback<List<Movie>>() {
            @Override
            public void onResponse(Call<List<Movie>> call, Response<List<Movie>> response) {
                movieList = response.body();
                recyclerViewAdapter.setMovieList(movieList);
            }

            @Override
            public void onFailure(Call<List<Movie>> call, Throwable t) {
                Log.d("TAG","Response = "+t.toString());
            }
        });
    }
}
