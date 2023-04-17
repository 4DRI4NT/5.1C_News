package com.example.a51c_news;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link NewsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class NewsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public NewsFragment() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment NewsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static NewsFragment newInstance(String param1, String param2) {
        NewsFragment fragment = new NewsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_news, container, false);

        //access bundle and check for contents
        Bundle bundle = this.getArguments();
        if (bundle != null) {

            //define and link elements to id
            TextView fragTitle = rootView.findViewById(R.id.fragTitleText);
            TextView fragDescription = rootView.findViewById(R.id.fragDescriptionText);
            ImageView fragImage = rootView.findViewById(R.id.fragImageView);

            //save data model
            List<NewsDataModel> newsDataModelList = ((MainActivity)this.getActivity()).getNewsDataModel();

            //save selection
            int position = bundle.getInt("position");

            //display elements of data model selection
            fragTitle.setText(newsDataModelList.get(position).getTitle());
            fragDescription.setText(newsDataModelList.get(position).getDescription());
            fragImage.setImageResource(newsDataModelList.get(position).getImage());

            //define and set recycler and adapter
            RecyclerView rowRecyclerView = rootView.findViewById(R.id.fragRecyclerView);
            RowRecyclerViewAdapter rowRecyclerViewAdapter = new RowRecyclerViewAdapter(newsDataModelList, getActivity());
            rowRecyclerView.setAdapter(rowRecyclerViewAdapter);

            rowRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        }

        return rootView;
    }
}