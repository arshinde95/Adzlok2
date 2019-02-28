package com.example.arshinde.adzlok;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by arshinde on 16-02-2019.
 */

public class SliderAdapter extends PagerAdapter {
    Context context;
    LayoutInflater layoutInflater;
    public SliderAdapter(Context context)
    {
        this.context=context;
    }



    //Array

    public String[] slide_title=
            {
                    "Earn from your space. Connect with advertisers directly",
                    "With adzlok, Advertising becomes easy ",
                    "Your influence can make you rich!"
            };
    public int [] slide_image={
            R.drawable.first,
            R.drawable.second,
            R.drawable.three

    };
    public String[] slide_head=
            {
              "Advertiser", "Publisher", "Influencer"

            };
    public String [] slide_effects={
           "With adzlok, List your physical space where you can promote a brand and start getting advertisers ",
            "Get ideas for advertising your business. No Brokers! Connect with media owner directly",
            "With adzlok, you can monetize your followers and help advertisers in their digital marketing by content sharing."
    };

    public int[] lst_background={
            Color.rgb(128,191,255),
            Color.rgb(0,230,230),
            Color.rgb(128,212,255)
    };


    @Override
    public int getCount() {
        return slide_head.length;
    }

    @Override
   public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view ==(RelativeLayout) object;
    }

    public Object instantiateItem(ViewGroup container ,int position)
    {
        layoutInflater=(LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.slide_layout,container,false);
        RelativeLayout relativeLayout=(RelativeLayout)view.findViewById(R.id.slideRelative);


        ImageView SlideImageView=(ImageView)view.findViewById(R.id.icons);
        TextView SlideHeading =(TextView)view.findViewById(R.id.head);
        TextView SlideDesciption=(TextView)view.findViewById(R.id.desc);
        TextView Slidetitle=(TextView)view.findViewById(R.id.title);
        relativeLayout.setBackgroundColor(lst_background[position]);

        Slidetitle.setText(slide_title[position]);
        SlideImageView.setImageResource(slide_image[position]);
        SlideHeading.setText(slide_head[position]);
        SlideDesciption.setText(slide_effects[position]);




        container.addView(view);
        return view;

    };

    public void distroyItem(ViewGroup container,int position,Object object)
    {
        container.removeView((RelativeLayout )object);
    }
}
