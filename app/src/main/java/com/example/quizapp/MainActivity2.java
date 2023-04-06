package com.example.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.quizapp.Adapter.RecycleAdapter;
import com.example.quizapp.Model.onlineImages;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {
    ImageView yourImageView;
    Button bSetWallpaper;
    RecyclerView recyclerView;
    RecycleAdapter recycleAdapter;
    ArrayList<onlineImages> imagesArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        recyclerView = findViewById(R.id.recycleview);

        // yourImageView = (ImageView) findViewById(R.id.image_resource);
//



        imagesArrayList = new ArrayList<>();
        imagesArrayList.add(new onlineImages("https://i.pinimg.com/originals/44/e3/63/44e3636951fdde4f1a525b7d4b6fa87b.jpg"));
        imagesArrayList.add(new onlineImages("https://w0.peakpx.com/wallpaper/284/885/HD-wallpaper-neymar-2019-brasil-brazil-football-futbol-neymar-jr.jpg"));

        imagesArrayList.add(new onlineImages("https://w0.peakpx.com/wallpaper/115/855/HD-wallpaper-messi-football.jpg"));

        imagesArrayList.add(new onlineImages("https://w0.peakpx.com/wallpaper/723/183/HD-wallpaper-mbappe-futbol-psg.jpg"));
        recyclerView.hasFixedSize();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recycleAdapter = new RecycleAdapter(MainActivity2.this, imagesArrayList);
        recyclerView.setAdapter(recycleAdapter);


    }
}

