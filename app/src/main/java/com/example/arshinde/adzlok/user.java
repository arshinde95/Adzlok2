package com.example.arshinde.adzlok;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.graphics.Bitmap;
import android.widget.TextView;



import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

/**
 * Created by arshinde on 17-02-2019.
 */

public class user extends RecyclerView.Adapter<user.SearchViewHolder> {
    Context context;
    ArrayList<String> fullnameList;
    ArrayList<String>statusList;
    ArrayList<String>profilePicLIst;


    class SearchViewHolder extends RecyclerView.ViewHolder{

        ImageView profileimage;
        TextView username,status;

        public SearchViewHolder(View itemView) {
            super(itemView);
            profileimage=(ImageView)itemView.findViewById(R.id.profileimage);
            username=(TextView)itemView.findViewById(R.id.username);
            status=(TextView)itemView.findViewById(R.id.status);

        }
    }

    public user(Context context,ArrayList<String> fullnameList,ArrayList<String>statusList,ArrayList<String>profilePicLIst){

        this.context=context;
        this.fullnameList=fullnameList;
        this.statusList=statusList;
        this.profilePicLIst=profilePicLIst;
    }


    @NonNull
    @Override
    public user.SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(context).inflate(R.layout.list_layout,parent,false);

        return new user.SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {

        holder.username.setText(fullnameList.get(position));
        holder.status.setText(statusList.get(position));

        Glide.with(context).asBitmap().load(profilePicLIst.get(position)).placeholder(R.mipmap.ic_launcher_round).into(holder.profileimage);

    }


    @Override
    public int getItemCount() {
        return fullnameList.size();
    }
}
