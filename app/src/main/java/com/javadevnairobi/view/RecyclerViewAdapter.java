package com.javadevnairobi.view;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.javadevnairobi.R;

import java.util.ArrayList;

import static android.support.v4.content.ContextCompat.startActivity;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    public static final String EXTRA_MESSAGE = "com.javadevnairobi.MESSAGE";
    private static final String TAG = "RecyclerViewAdapter";
    private  ArrayList<String> mimageNames = new ArrayList<>();
    private  ArrayList<String> mimages = new ArrayList<>();
    private Context mContext;

    public RecyclerViewAdapter(ArrayList<String> mimageNames, ArrayList<String> mimages, Context mContext) {
        this.mimageNames = mimageNames;
        this.mimages = mimages;
        this.mContext = mContext;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem, parent, false);
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
                String message = mimageNames.get(holder.getAdapterPosition());
                Intent intent = new Intent(mContext, ViewProfile.class);
                intent.putExtra(EXTRA_MESSAGE, message);
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
        RelativeLayout parentLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.profile_image);
            name = itemView.findViewById(R.id.name);
            parentLayout = itemView.findViewById(R.id.parent_layout);
        }
    }
}
