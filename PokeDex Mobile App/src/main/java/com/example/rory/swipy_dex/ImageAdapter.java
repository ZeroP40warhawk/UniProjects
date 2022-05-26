package com.example.rory.swipy_dex;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

/**
 * Created by Rory on 22/03/2016.
 */
public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    // create a new ImageView for each item referenced by the Adapter
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }

        imageView.setImageResource(mThumbIds[position]);
        return imageView;
    }

    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.bulbasaur, R.drawable.ivysaur,
            R.drawable.venusaur, R.drawable.p4,
            R.drawable.p5, R.drawable.p6,
            R.drawable.p7, R.drawable.p8,
            R.drawable.p9, R.drawable.p10,
            R.drawable.p11, R.drawable.p12,
            R.drawable.p13, R.drawable.p14,
            R.drawable.p15, R.drawable.p16,
            R.drawable.p17, R.drawable.p18,
            R.drawable.p19, R.drawable.p20,
            R.drawable.p20, R.drawable.p21,
            R.drawable.p22, R.drawable.p23,
            R.drawable.p24, R.drawable.p25,
            R.drawable.p26, R.drawable.p27,
            R.drawable.p28, R.drawable.p29,
            R.drawable.p30,
    };
}
