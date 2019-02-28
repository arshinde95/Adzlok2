package com.example.arshinde.adzlok;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class MoreFromAdvertiserActivity extends AppCompatActivity {
//    private RecyclerView mBlogList;
//    private DatabaseReference mDatabase;

    private ListView list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_from_advertiser);

        list=(ListView)findViewById(R.id.recyclerview);


        List<BlogModel> blogModelList=new ArrayList<BlogModel>();

        BlogAdapter adapter=new BlogAdapter(MoreFromAdvertiserActivity.this,R.layout.content_layout_,blogModelList);

        Vector v=new Vector();
        blogModelList.add(new BlogModel(null,"Puneet Pichholia","Android","Android Desc","World"));

        list.setAdapter(adapter);

//
//        Toolbar toolbar=(Toolbar)findViewById(R.id.toolbar);
//        toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp);
//
//        mDatabase= FirebaseDatabase.getInstance().getReference().child("user");
//        mDatabase.keepSynced(true);
//
//        mBlogList=(RecyclerView)findViewById(R.id.recyclerview);
//        mBlogList.setHasFixedSize(true);
//        mBlogList.setLayoutManager(new LinearLayoutManager(this));
//
//
//    }
//    protected void onStart()
//    {
//        super.onStart();
//        FirebaseRecyclerAdapter<BlogAdapter,BlogViewHolder>firebaseRecyclerAdapter=new FirebaseRecyclerAdapter<BlogAdapter,BlogViewHolder>
//                (BlogAdapter.class,R.layout.activity_more_from_advertiser,BlogViewHolder.class,mDatabase){
//            protected void populateViewHolder(BlogViewHolder viewHolder,BlogAdapter model,int position){
//
//            }
//        };
//    }
//
//    public static class BlogViewHolder extends RecyclerView.ViewHolder
//    {
//        View mView;
//        public BlogViewHolder(View itemView)
//        {
//            super(itemView);
//            mView=itemView;
//        }
//        public void setName(String name)
//        {
//            TextView post_name=(TextView)mView.findViewById(R.id.name);
//            post_name.setText(name);
//        }
//        public void setImage(Context ctx,String image)
//        {
//            ImageView post_image=(ImageView)mView.findViewById(R.id.profileimage);
//            Picasso.with(ctx).load(image).into(post_image);
//        }
    }
}
