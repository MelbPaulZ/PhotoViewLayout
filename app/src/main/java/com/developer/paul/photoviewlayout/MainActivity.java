package com.developer.paul.photoviewlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> urls = new ArrayList<>();
        urls.add("http://zone1.aqusagtechnologi.netdna-cdn.com/wp-content/uploads/2015/07/url1.jpg");
        urls.add("http://zone1.aqusagtechnologi.netdna-cdn.com/wp-content/uploads/2015/07/url1.jpg");
        urls.add("http://zone1.aqusagtechnologi.netdna-cdn.com/wp-content/uploads/2015/07/url1.jpg");
        urls.add("http://zone1.aqusagtechnologi.netdna-cdn.com/wp-content/uploads/2015/07/url1.jpg");
        urls.add("http://zone1.aqusagtechnologi.netdna-cdn.com/wp-content/uploads/2015/07/url1.jpg");
        PhotoLayout photoLayout = (PhotoLayout) findViewById(R.id.photo_layout);
        photoLayout.setPhotoUrlList(urls);
    }
}
