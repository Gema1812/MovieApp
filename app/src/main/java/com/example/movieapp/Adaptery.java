package com.example.movieapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Adaptery extends RecyclerView.Adapter<Adaptery.MyViewHolder> {


    private Context mContext;
    private List<MovieModelClass> mData;

    public Adaptery(Context mContext, List<MovieModelClass> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        v = inflater.inflate(R.layout.movie_item, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.id.setText(mData.get(position).getId());
        holder.name.setText(mData.get(position).getName());
        holder.ov.setText(mData.get(position).getOv());

        // using glide library to display the image
        //https://image.tmdb.org/t/p/w500/
        Glide.with(mContext)
                .load("https://image.tmdb.org/t/p/w500/"+mData.get(position).getImg())
                .into(holder.img);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(mContext, mData.get(position).getName(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(mContext, DetailActivity.class);

                intent.putExtra("detail_id", mData.get(position).getId());
                intent.putExtra("detail_name", mData.get(position).getName());
                intent.putExtra("detail_image", "https://image.tmdb.org/t/p/w500/"+mData.get(position).getImg());
                intent.putExtra("detail_overview", mData.get(position).getOv());

                mContext.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView id;
        TextView name;
        ImageView img;
        TextView ov;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            id = itemView.findViewById(R.id.id_txt);
            name = itemView.findViewById(R.id.name_txt);
            img = itemView.findViewById(R.id.imageView);
            ov = itemView.findViewById(R.id.ov_txt);
        }
    }
}
