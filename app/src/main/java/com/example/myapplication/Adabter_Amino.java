package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adabter_Amino  extends RecyclerView.Adapter<Adabter_Amino.MyViewHolder> {
    Context context;
    ArrayList<Recycler_Model> aminoAcidsModels;
    public Adabter_Amino(Context context , ArrayList<Recycler_Model> aminoAcidsModels){
        this.context = context;
        this.aminoAcidsModels = aminoAcidsModels;

    }


    @NonNull
    @Override
    public Adabter_Amino.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recyclerview,parent,false);
        return  new Adabter_Amino.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adabter_Amino.MyViewHolder holder, int position) {
        holder.tv1.setText(aminoAcidsModels.get(position).getFullName());
        holder.tv2.setText(aminoAcidsModels.get(position).get_2Letters());
        holder.tv3.setText(aminoAcidsModels.get(position).get_3Letters());
        holder.imageView.setImageResource(aminoAcidsModels.get(position).getImage());

    }

    @Override
    public int getItemCount() {
       return   aminoAcidsModels.size();
    }
  public static class MyViewHolder extends  RecyclerView.ViewHolder{
        AppCompatImageView imageView;
        TextView tv1,tv2,tv3;

      public MyViewHolder(@NonNull View itemView) {
          super(itemView);
          imageView = itemView.findViewById(R.id.Image);
          tv1 = itemView.findViewById(R.id.FirstText);
          tv2 = itemView.findViewById(R.id.SecondText);
          tv3 = itemView.findViewById(R.id.ThirdText);
      }
  }
}
