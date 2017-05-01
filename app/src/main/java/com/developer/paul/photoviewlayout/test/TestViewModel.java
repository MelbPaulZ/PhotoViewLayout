package com.developer.paul.photoviewlayout.test;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.BindingAdapter;

import com.developer.paul.photoviewlayout.BR;
import com.developer.paul.photoviewlayout.PhotoLayout;

import java.util.List;


/**
 * Created by Paul on 30/4/17.
 */

public class TestViewModel extends BaseObservable {
    private Urls urls;

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
}
