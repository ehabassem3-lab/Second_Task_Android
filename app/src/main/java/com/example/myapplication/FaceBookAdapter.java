package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageButton;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FaceBookAdapter extends RecyclerView.Adapter<FaceBookAdapter.MyViewHolder> {
    Context context ;
    ArrayList<FaceBook_Model> FaceBookArrayList;

    public FaceBookAdapter(Context context, ArrayList<FaceBook_Model> faceBookArrayList) {
        this.context = context;
        FaceBookArrayList = faceBookArrayList;
    }

    @NonNull
    @Override
    public FaceBookAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.android_assighments_3_stamba,parent,false);
        return  new FaceBookAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FaceBookAdapter.MyViewHolder holder, int position) {
        holder.ProfileName.setText(FaceBookArrayList.get(position).getProfileName());
        holder.ProfileImage.setImageResource(FaceBookArrayList.get(position).getProfileImage());

    }

    @Override
    public int getItemCount() {
        return FaceBookArrayList.size();
    }

    public static class MyViewHolder extends  RecyclerView.ViewHolder {
        TextView ProfileName ;
        AppCompatImageView ProfileImage;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            ProfileImage = itemView.findViewById(R.id.ProfileImage);
            ProfileName = itemView.findViewById(R.id.ProfileName);
        }
    }
}
