package com.example.retofit_app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.retofit_app.retrofit.Controller;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Controller controller = new Controller();
        controller.start();
    }
}