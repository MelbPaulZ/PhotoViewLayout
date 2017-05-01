package com.developer.paul.photoviewlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.developer.paul.photoviewlayout.test.TestFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TestFragment testFragment = new TestFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.container, testFragment).commit();

    }
}
