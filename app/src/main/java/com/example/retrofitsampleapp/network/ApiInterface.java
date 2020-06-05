package com.example.retrofitsampleapp.network;

import com.example.retrofitsampleapp.model.Movie;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("volley_array.json")
    Call<List<Movie>> getMovies();
    
}
