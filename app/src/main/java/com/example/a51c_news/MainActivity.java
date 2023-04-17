package com.example.a51c_news;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements GridRecyclerViewAdapter.OnRowClickListener, HorizontalRecyclerViewAdapter.OnRowClickListener{

    //
    RecyclerView GridRecyclerView, HorizontalRecyclerView;
    GridRecyclerViewAdapter GridRecyclerViewAdapter;
    HorizontalRecyclerViewAdapter HorizontalRecyclerViewAdapter;
    List<NewsDataModel> newsDataModelList = new ArrayList<>();

    //define data for data model
    String[] titleList = {"9NEWS", "7NEWS", "ABC NEWS", "THE AGE"};
    String[] descriptionList = {"_____________________________________________________________________________________________", "_____________________________________________________________________________________________", "_____________________________________________________________________________________________", "_____________________________________________________________________________________________"};
    int[] imageList = {R.drawable.image_icon, R.drawable.image_icon, R.drawable.image_icon, R.drawable.image_icon};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //link recyclerViews and define/set adapters
        GridRecyclerView = findViewById(R.id.RecyclerViewGrid);
        GridRecyclerViewAdapter = new GridRecyclerViewAdapter(newsDataModelList, this, this);
        GridRecyclerView.setAdapter(GridRecyclerViewAdapter);

        HorizontalRecyclerView = findViewById(R.id.HorizontalRecyclerView);
        HorizontalRecyclerViewAdapter = new HorizontalRecyclerViewAdapter(newsDataModelList, this, this);
        HorizontalRecyclerView.setAdapter(HorizontalRecyclerViewAdapter);

        GridRecyclerView.setLayoutManager(new GridLayoutManager(this, 2, GridLayoutManager.HORIZONTAL, false));

        HorizontalRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

        //construct data model with data
        for (int i = 0; i < titleList.length; i++) {
            NewsDataModel newsDataModel = new NewsDataModel(i, titleList[i], descriptionList[i], imageList[i]);
            newsDataModelList.add(newsDataModel);
        }


        //create and hide fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        NewsFragment fragment = (NewsFragment) fragmentManager.findFragmentById(R.id.fragmentContainerView);
        fragmentTransaction.hide(fragment).commit();
    }

    @Override
    public void onItemClick(int position) {
        //create fragment
        NewsFragment newsFragment = new NewsFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();

        //bundle selection for fragment
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        newsFragment.setArguments(bundle);

        //show fragment
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainerView, newsFragment).addToBackStack("").commit();
    }

    //allow fragment access to data model
    public List<NewsDataModel> getNewsDataModel() {
        return newsDataModelList;
    }
}