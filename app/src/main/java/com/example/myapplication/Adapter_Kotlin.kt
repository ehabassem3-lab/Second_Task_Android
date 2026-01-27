package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class Adapter_Kotlin
    (var AminoListL: ArrayList<Kotlin_DataModel>) : RecyclerView.Adapter<Adapter_Kotlin.AminoViewHolder>() {
        lateinit var amino_click : Amino_click;
    lateinit var kotlinDatamodel: Kotlin_DataModel;

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AminoViewHolder {
        val view = LayoutInflater.from(parent.context).
        inflate(R.layout.recyclerview,parent,false)
        return AminoViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: AminoViewHolder,
        position: Int
    ) {
       var amino = AminoListL[position];
        holder.Fullname.text = amino.FullName;
        holder.TwoLitters.text = amino._2Letters;
        holder.ThreeLitters.text = amino._3Letters;
        holder.Image.setImageResource(amino.image)
        holder.itemView.setOnClickListener {
            amino_click.aminoClick(position, amino);

        }
    }

    override fun getItemCount(): Int =   AminoListL.size;




    class  AminoViewHolder(itemView : View): RecyclerView.ViewHolder(itemView){
           var Fullname : TextView = itemView.findViewById(R.id.FirstText);
        var TwoLitters : TextView = itemView.findViewById(R.id.SecondText);
        var ThreeLitters : TextView = itemView.findViewById(R.id.ThirdText);
        var Image : ImageView = itemView.findViewById(R.id.Image);



    }
    interface Amino_click{
        fun aminoClick(position: Int , kotlin: Kotlin_DataModel);

    }
}