package com.example.a51c_news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RowRecyclerViewAdapter extends RecyclerView.Adapter<RowRecyclerViewAdapter.ViewHolder> {

    private List<NewsDataModel> newsDataModelList;
    private Context context;

    //constructor
    public RowRecyclerViewAdapter(List<NewsDataModel> newsDataModelList, Context context) {
        this.newsDataModelList = newsDataModelList;
        this.context = context;
    }

    @NonNull
    @Override
    public RowRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.news_row, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //sets data model elements into recycler layout
        holder.newsRowTitleText.setText(newsDataModelList.get(position).getTitle());
        holder.newsRowDescriptionText.setText(newsDataModelList.get(position).getDescription());
        holder.newsRowImageView.setImageResource(newsDataModelList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return newsDataModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //define elements
        TextView newsRowTitleText, newsRowDescriptionText;
        ImageView newsRowImageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            //link elements to id
            newsRowTitleText = itemView.findViewById(R.id.newsRowTitleText);
            newsRowDescriptionText = itemView.findViewById(R.id.newsRowDescriptionText);
            newsRowImageView = itemView.findViewById(R.id.newsRowImageView);
        }
    }
}
