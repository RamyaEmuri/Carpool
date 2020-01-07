package com.example.carpool;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.PagerAdapter;

class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {
        this.context=context;
    }

    public int[] slide_image = {
            R.drawable.image,
            R.drawable.gasoline,
            R.drawable.friends,
            R.drawable.traffic,
            R.drawable.pollution,
    };


    public  String[] slide_heading = {
            "Saving Money",
            "Saving Gasoline",
            "Meet New Friends",
            "Decrease Traffic",
            "Decrease Pollution"
    };


    public String[] slide_description = {

            "The first and probably most important savings goal you need to consider is building up an emergency fund. You can't always predict what life has in store for you. ",
            "The first and probably most important savings goal you need to consider is building up an emergency fund. You can't always predict what life has in store for you.",
            "The first and probably most important savings goal you need to consider is building up an emergency fund. You can't always predict what life has in store for you. ",
            "The first and probably most important savings goal you need to consider is building up an emergency fund. You can't always predict what life has in store for you. ",
            "The first and probably most important savings goal you need to consider is building up an emergency fund. You can't always predict what life has in store for you. ",

    };



    @Override
    public int getCount()
    {
        return slide_heading.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ConstraintLayout) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.fragment1, container, false );

        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        TextView textView = (TextView) view.findViewById(R.id.textView);
        TextView textView1 = (TextView) view.findViewById(R.id.textView1);

        imageView.setImageResource(slide_image[position]);
        textView.setText(slide_heading[position]);
        textView1.setText(slide_description[position]);

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {

        container.removeView((ConstraintLayout) object);
    }


}
