package com.example.arshinde.adzlok;

import android.graphics.Color;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class SwipePagesActivity extends AppCompatActivity {
    private ViewPager viewPager;
    private LinearLayout linearLayout;
    private TextView[] mdots;
    private SliderAdapter sliderAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_pages);
        viewPager = (ViewPager) findViewById(R.id.view);
        linearLayout = (LinearLayout) findViewById(R.id.linear);
        sliderAdapter = new SliderAdapter(this);
        viewPager.setAdapter(sliderAdapter);
        viewPager.addOnPageChangeListener(viewListenr);
        RelativeLayout relativeLayout=(RelativeLayout)findViewById(R.id.recyclerview);
        addDotsIndicator(0);

    }
    public void addDotsIndicator(int position)
    {
        mdots=new TextView[3];
        linearLayout.removeAllViews();

        for(int i=0;i<mdots.length;i++)

        {

            mdots[i]=new TextView(this);
            mdots[i].setText(Html.fromHtml("&#8226"));
            mdots[i].setTextSize(35);
            mdots[i].setTextColor(Color.GRAY);

            linearLayout.addView(mdots[i]);


        }
        if(mdots.length>0)
        {
            mdots[position].setTextColor(Color.WHITE);

        }
    }

    ViewPager.OnPageChangeListener viewListenr=new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}
