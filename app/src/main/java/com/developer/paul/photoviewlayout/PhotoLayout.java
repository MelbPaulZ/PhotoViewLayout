package com.developer.paul.photoviewlayout;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paul on 29/4/17.
 */

public class PhotoLayout extends LinearLayout {
    private int height, width;
    private String TAG = "PhotoLayout";

    private List<ImageView> imgList;
    private SmallPhotoLayout rl;
    private List<String> photoUrlList;

    public PhotoLayout(Context context) {
        super(context);
        init();
    }

    public PhotoLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        setOrientation(LinearLayout.HORIZONTAL);

        imgList = new ArrayList<>();
        initImageViews();

        rl = new SmallPhotoLayout(getContext());
        LayoutParams rlLayoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        rlLayoutParams.weight = 1;
        rl.setLayoutParams(rlLayoutParams);
        rl.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "click small photos", Toast.LENGTH_SHORT).show();
            }
        });

        addView(rl);
    }

    private void initImageViews(){
        for(int i = 0 ; i < 2; i++) {
            ImageView img = new ImageView(getContext());
            img.setId(i);
            LayoutParams imgLayoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            imgLayoutParams.weight = 1;
            imgLayoutParams.setMargins(10,10,10,10);
            img.setLayoutParams(imgLayoutParams);
            Picasso.with(getContext()).load(R.drawable.gray).into(img);
            img.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), "click image : " + v.getId(), Toast.LENGTH_SHORT).show();
                }
            });
            imgList.add(img);
            addView(img);
        }
    }

    public void setPhotoUrlList(List<String> photoUrlList) {
        this.photoUrlList = photoUrlList;
        updatePhotoUrl();
    }

    private void updatePhotoUrl(){
        int len = photoUrlList.size() > 2? 2: photoUrlList.size();
        for(int i = 0; i < len; i++){
            Picasso.with(getContext()).load(photoUrlList.get(i)).error(R.drawable.location).fit().centerCrop().into(imgList.get(i));
        }

        if (photoUrlList.size()>2){
            rl.setPhotoUrlList(photoUrlList.subList(2, photoUrlList.size()));
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        width = MeasureSpec.getSize(widthMeasureSpec);
        height = MeasureSpec.getSize(heightMeasureSpec);

        rl.measure(MeasureSpec.makeMeasureSpec(width/3, MeasureSpec.EXACTLY),
                MeasureSpec.makeMeasureSpec(height, MeasureSpec.EXACTLY));
//        Log.i(TAG, "onMeasure: " + width + " " + height + " "+ squareWidth + " " + squareHeight);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
//        Log.i(TAG, "onLayout: " + l + " " + t + " " + squareWidth + " " + squareHeight);
        rl.layout(width * 2/3, 0, r, b);
    }
}
