package com.example.arshinde.adzlok;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by arshinde on 22-02-2019.
 */

public class BlogAdapter extends ArrayAdapter<BlogModel> {
    private List<BlogModel> items;
    private int resource;
    private Context context;

    public BlogAdapter(Context context, int resource, List<BlogModel> items) {
        super(context, resource, items);

        this.context=context;
        this.resource=resource;
        this.items=items;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

       View row=convertView;
       BlogModel_Holder holder=null;
       LayoutInflater inflater=((Activity)context).getLayoutInflater();
       row=inflater.inflate(resource,parent,false);

       holder=new BlogModel_Holder();
       //holder.image=(ImageView)row.findViewById(R.id.image);
        holder.name=(TextView)row.findViewById(R.id.name);
        holder.title=(TextView)row.findViewById(R.id.title);
        holder.desc=(TextView)row.findViewById(R.id.desc);
        holder.location=(TextView)row.findViewById(R.id.location);

        setupItem(holder);

        return row;
    }



    public void setupItem(BlogModel_Holder holder)
    {
       // holder.image.set
        holder.name.setText(holder.blogModel.getName());
        holder.title.setText(holder.blogModel.getTitle());
        holder.desc.setText(holder.blogModel.getDesc());
        holder.location.setText(holder.blogModel.getLocation());

    }


    public static class BlogModel_Holder{
        BlogModel blogModel;
        ImageView image;
        TextView name;
        TextView title;
        TextView desc;
        TextView location;
    }


}
