package com.javadevnairobi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.javadevnairobi.R;

import java.util.ArrayList;

public class RepoViewAdapter extends  RecyclerView.Adapter <RepoViewAdapter.RepoViewHolder>{
    private ArrayList<String> repoName = new ArrayList<>();
    private ArrayList<String> repoDescription = new ArrayList<>();
    private ArrayList<Integer> star = new ArrayList<>();
    private ArrayList<Integer> watchers = new ArrayList<>();
    private ArrayList<Integer> folks = new ArrayList<>();
    private Context context;

    public RepoViewAdapter(ArrayList<String> repoName, ArrayList<String> repoDescription, ArrayList<Integer> star, ArrayList<Integer> watchers, ArrayList<Integer> folks, Context context) {
        this.repoName = repoName;
        this.repoDescription = repoDescription;
        this.context = context;
        this.star = star;
        this.watchers = watchers;
        this.folks = folks;
    }

    public static  class RepoViewHolder extends  RecyclerView.ViewHolder {
        TextView repoName;
        TextView repoDescription;
        TextView starCount;
        TextView watchersCount;
        TextView folksCount;
        RelativeLayout parentLayout;
        public RepoViewHolder(View itemView) {
            super(itemView);
            repoName= itemView.findViewById(R.id.repo_name);
            repoDescription = itemView.findViewById(R.id.repo_description);
            starCount = itemView.findViewById(R.id.star);
            watchersCount = itemView.findViewById(R.id.watchers);
            folksCount = itemView.findViewById(R.id.folks);
            parentLayout = itemView.findViewById(R.id.repo_parent);
        }
    }

    @Override
    public RepoViewAdapter.RepoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_repolist, parent, false);
        view.setNestedScrollingEnabled(false);
        RepoViewAdapter.RepoViewHolder holder = new RepoViewAdapter.RepoViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RepoViewAdapter.RepoViewHolder repoViewHolder, int i) {
        repoViewHolder.repoName.setText(repoName.get(repoViewHolder.getAdapterPosition()));
        repoViewHolder.repoDescription.setText(repoDescription.get(repoViewHolder.getAdapterPosition()));
        repoViewHolder.starCount.setText("" + star.get(repoViewHolder.getAdapterPosition()));
        repoViewHolder.watchersCount.setText("" + watchers.get(repoViewHolder.getAdapterPosition()));
        repoViewHolder.folksCount.setText("" + folks.get(repoViewHolder.getAdapterPosition()));
    }

    @Override
    public int getItemCount() {
        return repoName.size();
    }
}

