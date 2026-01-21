package com.example.myapplication;

public class Recycler_Model {
    String FullName ;
    String _3Letters;
    String _2Letters;
    int Image;

    public Recycler_Model
            (String fullName,
             String _3Letters,
             String _2Letters,
             int image) {
        FullName = fullName;
        this._3Letters = _3Letters;
        this._2Letters = _2Letters;
        Image = image;
    }

    public String getFullName() {
        return FullName;
    }

    public String get_3Letters() {
        return _3Letters;
    }

    public String get_2Letters() {
        return _2Letters;
    }

    public int getImage() {
        return Image;
    }
}
