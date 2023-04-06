package com.example.quizapp.Adapter;

import android.app.AlertDialog;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quizapp.R;
import com.example.quizapp.Model.onlineImages;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;


public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {
    private final Context context;
    ArrayList<onlineImages> imagemodels;
   WallpaperManager wallpaperManager;






    public RecycleAdapter(Context context, ArrayList<onlineImages> imagemodels) {
        this.context = context;
        this.imagemodels = imagemodels;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.galleryiew,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        onlineImages images = imagemodels.get(position);
        String imageurl = "";
        imageurl = images.getImage();
        Picasso.get().load(imageurl).into(holder.imageView);

        holder.bSetWallpaper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which){
                            case DialogInterface.BUTTON_POSITIVE:
                                WallpaperManager wallpaperManager = WallpaperManager.getInstance(context);
                                Bitmap bitmap = ((BitmapDrawable) holder.imageView.getDrawable()).getBitmap();
                                try {
                                    wallpaperManager.setBitmap(bitmap);
                                    Toast.makeText(context, "Wallpaper Set Successfully", Toast.LENGTH_SHORT).show();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                break;

                            case DialogInterface.BUTTON_NEGATIVE:
                                //No button clicked
                                break;
                        }
                    }
                };

                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setMessage("Are you sure?").setPositiveButton("Yes", dialogClickListener)
                        .setNegativeButton("No", dialogClickListener).show();


            }


        });



    }

    @Override
    public int getItemCount() {
        return imagemodels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        Button bSetWallpaper;

        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            imageView = itemView.findViewById(R.id.idIVWallpaper);
            bSetWallpaper= itemView.findViewById(R.id.bSetWallpaper);
        }
    }



}

