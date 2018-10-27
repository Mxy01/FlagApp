package com.example.lenovo.flag;

public class Item {
    String countryName;
    int flagImage;

    public Item(String countryName,int flagImage)
    {
        this.flagImage=flagImage;
        this.countryName=countryName;
    }
    public String getcountryName()
    {
        return countryName;
    }
    public int getflagImage()
    {
        return flagImage;
    }

}
