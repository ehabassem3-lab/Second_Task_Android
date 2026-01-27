package com.example.myapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.function.LongFunction;
import java.util.zip.Inflater;

public class Adabter_Amino extends RecyclerView.Adapter<Adabter_Amino.MyViewHolder> {
    ArrayList<Recycler_Model> AminoAcidsArraylist;
 Recycler_Model model;
      Amino_Click aminoClick;
    Context context;

    public void setAminoClick(Amino_Click aminoClick) {
        this.aminoClick = aminoClick;
    }

    public Adabter_Amino(ArrayList<Recycler_Model> aminoAcidsArraylist, Context context) {
        AminoAcidsArraylist = aminoAcidsArraylist;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recyclerview,parent,false);
        Log.e("onCreateViewHolder","onCreateViewHolder");
        return  new Adabter_Amino.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tv1.setText(AminoAcidsArraylist.get(position).getFullName());
        holder.tv2.setText(AminoAcidsArraylist.get(position).get_2Letters());
        holder.tv3.setText(AminoAcidsArraylist.get(position).get_3Letters());
        holder.Image.setImageResource(AminoAcidsArraylist.get(position).getImage());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aminoClick.SetClickAmino(model,position);
            }
        });


        Log.e("onBindViewHolder","onBindViewHolder");

    }

    @Override
    public int getItemCount() {
        return AminoAcidsArraylist.size() ;
    }

    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView tv1,tv2,tv3;
        AppCompatImageView Image;
       public  MyViewHolder(@NonNull View v){
            super(v);
            tv1 = v.findViewById(R.id.FirstText);
            tv2 = v.findViewById(R.id.SecondText);
            tv3 = v.findViewById(R.id.ThirdText);
            Image = v.findViewById(R.id.Image);

        }

    }


}
