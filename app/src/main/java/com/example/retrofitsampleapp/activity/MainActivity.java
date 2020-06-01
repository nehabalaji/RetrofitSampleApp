package com.example.retrofitsampleapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.retrofitsampleapp.R;
import com.example.retrofitsampleapp.network.ApiClient;
import com.example.retrofitsampleapp.network.ApiInterface;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
    }
}
