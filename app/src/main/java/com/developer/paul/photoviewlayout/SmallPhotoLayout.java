package com.developer.paul.photoviewlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.GridLayout;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paul on 29/4/17.
 */

public class SmallPhotoLayout extends GridLayout {
    private String TAG = "SmallPhotoLayout";
    private List<ImageView> imageViewList;
    private List<String> photoUrlList;
    private int width, height;
    private int squareWidth, squareHeight;

    public SmallPhotoLayout(Context context) {
        super(context);
        init();
    }

    public SmallPhotoLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    private void init(){
        setColumnCount(2);
        setRowCount(2);
        imageViewList = new ArrayList<>();
        for (int i = 0 ; i < 4 ; i ++){
            ImageView imageView = new ImageView(getContext());
            imageView.setPadding(5,5,5,5);
            imageViewList.add(imageView);
            Picasso.with(getContext()).load(R.drawable.gray).fit().centerCrop().into(imageViewList.get(i));
            addView(imageView);
        }
    }


    public void setPhotoUrlList(List<String> photoUrlList) {
        this.photoUrlList = photoUrlList;
        updatePhotos();
    }

    private void updatePhotos(){
        int len = photoUrlList.size()>4 ? 4 : photoUrlList.size();
        for(int i = 0; i < len; i++){
            Picasso.with(getContext()).load(photoUrlList.get(i)).error(R.drawable.location).fit().centerCrop().into(imageViewList.get(i));
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = MeasureSpec.getSize(widthMeasureSpec);
        height = MeasureSpec.getSize(heightMeasureSpec);
        width = width /3;

        squareWidth = width > height? height : width;
        squareHeight = squareWidth;

        Log.i(TAG, "onMeasure: " + squareWidth + " " + squareHeight);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
//        Log.i(TAG, "onLayout: " + l + " " + t + " " + r + " " + b);
//        imageViewList.get(0).layout(0, 0, width/2, height/2);
//
//        imageViewList.get(1).layout(width/2, 0, width, height/2);
//
//        imageViewList.get(2).layout(0, height/2, width/2, height);
//
//        imageViewList.get(3).layout(width/2, height/2, width, height);
        imageViewList.get(0).layout(0, 0, squareWidth/2, squareHeight/2);
        imageViewList.get(1).layout(squareWidth/2, 0, squareWidth, squareHeight/2);
        imageViewList.get(2).layout(0, squareHeight/2, squareWidth/2, squareHeight);
        imageViewList.get(3).layout(squareWidth/2, squareHeight/2, squareWidth, squareHeight);
    }
}

