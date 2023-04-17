package com.example.a51c_news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HorizontalRecyclerViewAdapter extends RecyclerView.Adapter<HorizontalRecyclerViewAdapter.ViewHolder>{

    private List<NewsDataModel> newsDataModelList;
    private Context context;
    private OnRowClickListener listener;

    //constructor
    public HorizontalRecyclerViewAdapter(List<NewsDataModel> newsDataModelList, Context context, OnRowClickListener clickListener) {
        this.newsDataModelList = newsDataModelList;
        this.context = context;
        this.listener = clickListener;
    }

    @NonNull
    @Override
    public HorizontalRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.top_stories, parent, false);

        return new HorizontalRecyclerViewAdapter.ViewHolder(itemView, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalRecyclerViewAdapter.ViewHolder holder, int position) {
        //sets data model elements into recycler layout
        holder.topStoriesImageView.setImageResource(newsDataModelList.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return newsDataModelList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        //define elements
        ImageView topStoriesImageView;
        OnRowClickListener onRowClickListener;
        public ViewHolder(@NonNull View itemView, OnRowClickListener onRowClickListener) {
            super(itemView);

            //link elements to id
            topStoriesImageView = itemView.findViewById(R.id.topStoriesImageView);
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