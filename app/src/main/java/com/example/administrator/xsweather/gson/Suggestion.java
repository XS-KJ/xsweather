package com.example.administrator.xsweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Administrator on 2018/1/5 0005.
 */

public class Suggestion {

    @SerializedName("comf")
    public Comfort comfort;

    @SerializedName("cw")
    public CatWash carwash;

    @SerializedName("sport")
    public Sport sport;

    public class Comfort{

        @SerializedName("txt")
        public String info;
    }

    public class CatWash{

        @SerializedName("txt")
        public String info;
    }

    public class Sport{

        @SerializedName("txt")
        public String info;
    }
}
