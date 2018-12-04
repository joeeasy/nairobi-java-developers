package com.javadevnairobi;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
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
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Log.d(TAG, "onBindViewHolder: ");
        Glide.with(mContext)
                .asBitmap()
                .load(mimages.get(position))
                .into(holder.image);
        holder.username.setText(mimageNames.get(position));
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: ");
                Toast.makeText(mContext, mimageNames.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mimageNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        CircleImageView image;
        TextView username;
        RelativeLayout parentLayout;
        public ViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.profile_image);
            username = itemView.findViewById(R.id.username);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            android.util.Log.d(TAG, "ViewHolder() returned: " +  image);
        }
    }
}
