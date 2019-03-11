package com.javadevnairobi.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.javadevnairobi.R;
import com.javadevnairobi.view.DetailView;

import java.util.ArrayList;

import static android.support.v4.content.ContextCompat.startActivity;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    public static final String EXTRA_MESSAGE = "com.javadevnairobi.MESSAGE";
    public static final String EXTRA_MESSAGE2 = "com.javadevnairobi.MESSAGE2";
    private static final String TAG = "RecyclerViewAdapter";
    private  ArrayList<String> mimageNames = new ArrayList<>();
    private  ArrayList<String> mimages = new ArrayList<>();
    private  ArrayList<String> url = new ArrayList<>();
    private  ArrayList<String> repoUrl = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(ArrayList<String> mimageNames, ArrayList<String> mimages, Context mContext) {
        this.mimageNames = mimageNames;
        this.mimages = mimages;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_layout, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        Glide.with(mContext)
                .asBitmap()
                .load(mimages.get(holder.getAdapterPosition()))
                .into(holder.image);
        holder.name.setText(mimageNames.get(holder.getAdapterPosition()));
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = mimageNames.get(holder.getAdapterPosition());
                Intent intent = new Intent(mContext, DetailView.class);
                intent.putExtra(EXTRA_MESSAGE, username);
                startActivity(mContext, intent, null);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mimageNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView image;
        TextView name;
        CardView parentLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.card_profile_image);
            name = itemView.findViewById(R.id.name);
            parentLayout = itemView.findViewById(R.id.profile_card);
        }
    }
}
