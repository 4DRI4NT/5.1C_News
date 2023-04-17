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

public class GridRecyclerViewAdapter extends RecyclerView.Adapter<GridRecyclerViewAdapter.ViewHolder>{

    private List<NewsDataModel> newsDataModelList;
    private Context context;
    private OnRowClickListener listener;

    //constructor
    public GridRecyclerViewAdapter(List<NewsDataModel> newsDataModelList, Context context, OnRowClickListener clickListener) {
        this.newsDataModelList = newsDataModelList;
        this.context = context;
        this.listener = clickListener;
    }

    @NonNull
    @Override
    public GridRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.news_grid, parent, false);

        return new ViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull GridRecyclerViewAdapter.ViewHolder holder, int position) {
        //sets data model elements into recycler layout
    holder.newsGridTitleText.setText(newsDataModelList.get(position).getTitle());
    holder.newsGridDescriptionText.setText(newsDataModelList.get(position).getDescription());
    holder.newsGridImageView.setImageResource(newsDataModelList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return newsDataModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        //define elements
        TextView newsGridTitleText, newsGridDescriptionText;
        ImageView newsGridImageView;
        OnRowClickListener onRowClickListener;
        public ViewHolder(@NonNull View itemView, OnRowClickListener onRowClickListener) {
            super(itemView);

            //link elements to id
            newsGridTitleText = itemView.findViewById(R.id.newsGridTitleText);
            newsGridDescriptionText = itemView.findViewById(R.id.newsGridDescriptionText);
            newsGridImageView = itemView.findViewById(R.id.newsGridImageView);
            this.onRowClickListener = onRowClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onRowClickListener.onItemClick(getAdapterPosition());
        }
    }

    public interface OnRowClickListener {
        void onItemClick(int position);
    }
}
