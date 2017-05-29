package com.developer.paul.photoviewlayout.test;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.Toast;

import com.developer.paul.photoviewlayout.BR;
import com.developer.paul.photoviewlayout.PhotoLayout;

import java.util.List;


/**
 * Created by Paul on 30/4/17.
 */

public class TestViewModel extends BaseObservable {
    private Urls urls;

    private PhotoLayout.ImageClickListener imageClickListener = new PhotoLayout.ImageClickListener() {
        @Override
        public View.OnClickListener onBigImageClick(final String url) {
            return new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "here paul customized big: " + url, Toast.LENGTH_SHORT).show();
                }
            };
        }

        @Override
        public View.OnClickListener onSmallImageClick(final String url) {
            return new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(v.getContext(), "here paul customized small: " + url, Toast.LENGTH_SHORT).show();
                }
            };
        }
    };

    @Bindable
    public PhotoLayout.ImageClickListener getImageClickListener() {
        return imageClickListener;
    }

    public void setImageClickListener(PhotoLayout.ImageClickListener imageClickListener) {
        this.imageClickListener = imageClickListener;
        notifyPropertyChanged(BR.imageClickListener);
    }

    @Bindable
    public Urls getUrls() {
        return urls;
    }

    public void setUrls(Urls urls) {
        this.urls = urls;
        notifyPropertyChanged(BR.urls);
    }

    @BindingAdapter("bind:photoUrls")
    public static void setUrls(PhotoLayout view, List<String> urls){
        view.setPhotoUrlList(urls);
    }

    @BindingAdapter("bind:imageClickListener")
    public static void setImageClickListener(PhotoLayout view, PhotoLayout.ImageClickListener imageClickListener){
        view.setImageClickListener(imageClickListener);
    }
}
