package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class First_Kotlin : AppCompatActivity() {
    var Images: IntArray = intArrayOf(
        R.drawable.image_1, R.drawable.image_2, R.drawable.image_3,
        R.drawable.image_4, R.drawable.image_5, R.drawable.image_6,
        R.drawable.image_7, R.drawable.image_8, R.drawable.image_9,
        R.drawable.image_10, R.drawable.image_11, R.drawable.image_12,
        R.drawable.image_13, R.drawable.image_14, R.drawable.image_15,
        R.drawable.image_16, R.drawable.image_17, R.drawable.image_18,
        R.drawable.image_19, R.drawable.image_20,
        R.drawable.image_1, R.drawable.image_2, R.drawable.image_3,
        R.drawable.image_4, R.drawable.image_5, R.drawable.image_6,
        R.drawable.image_7, R.drawable.image_8, R.drawable.image_9,
        R.drawable.image_10, R.drawable.image_11, R.drawable.image_12,
        R.drawable.image_13, R.drawable.image_14, R.drawable.image_15,
        R.drawable.image_16, R.drawable.image_17, R.drawable.image_18,
        R.drawable.image_19, R.drawable.image_20,


        )

    var aminoList = ArrayList<Kotlin_DataModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_recycle)
        CreatingModels()
        var adapterKotlin = Adapter_Kotlin(aminoList) ;
        val recyclerView: RecyclerView = findViewById(R.id.MyrecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapterKotlin;
        adapterKotlin.amino_click = object : Adapter_Kotlin.Amino_click{
            override fun aminoClick(position: Int, kotlin: Kotlin_DataModel) {
                val intent = Intent(this@First_Kotlin, FaceBook_Recycler::class.java)
                startActivity(intent)
            }
        }
    }

    fun CreatingModels() {
        val FullName = getResources().getStringArray(R.array.TxT_Dummy)
        val _2abberr = getResources().getStringArray(R.array.compound_abbr_2)
        val _3abberr = getResources().getStringArray(R.array.compound_abbr_3)
        for (i in Images.indices) {
            aminoList.add(
                Kotlin_DataModel(
                    FullName[i],
                    _2abberr[i],
                    _3abberr[i],
                    Images[i]


                )
            )
        }
    }

}