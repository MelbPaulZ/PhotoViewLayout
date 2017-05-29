package com.developer.paul.photoviewlayout.test;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.developer.paul.photoviewlayout.R;
import com.developer.paul.photoviewlayout.databinding.FragmentTestBinding;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Paul on 30/4/17.
 */

public class TestFragment extends Fragment {

    private FragmentTestBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_test, container,false);
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TestViewModel viewModel = new TestViewModel();
        binding.setVm(viewModel);

        List<String> urls = new ArrayList<>();
        urls.add("http://zone1.aqusagtechnologi.netdna-cdn.com/wp-content/uploads/2015/07/url1.jpg");
        urls.add("http://zone1.aqusagtechnologi.netdna-cdn.com/wp-content/uploads/2015/07/url1.jpg");
        urls.add("http://zone1.aqusagtechnologi.netdna-cdn.com/wp-content/uploads/2015/07/url1.jpg");
        urls.add("http://zone1.aqusagtechnologi.netdna-cdn.com/wp-content/uploads/2015/07/url1.jpg");
        urls.add("http://zone1.aqusagtechnologi.netdna-cdn.com/wp-content/uploads/2015/07/url1.jpg");
        Urls photos = new Urls(urls);
        viewModel.setUrls(photos);

    }
}
