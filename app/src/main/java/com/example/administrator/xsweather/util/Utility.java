package com.example.administrator.xsweather.util;

import android.text.TextUtils;

import com.example.administrator.xsweather.db.City;
import com.example.administrator.xsweather.db.County;
import com.example.administrator.xsweather.db.Province;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2018/1/3 0003.
 */

public class Utility {
    /**
     * 解析和处理服务器返回的省级数据
     */
    public static boolean handleProvinceResponse(String reponse) {
        if (!TextUtils.isEmpty(reponse)){
            try{
                JSONArray allProvinces = new JSONArray(reponse);
                for (int i = 0; i < allProvinces.length(); i++){
                    JSONObject proinveObject = allProvinces.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(proinveObject.getString("name"));
                    province.setProvinceCode(proinveObject.getInt("id"));
                    province.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     *解析和处理服务器返回的市级数据
     */
    public static boolean handleCityResponse(String reponse, int provinceId) {
        if (!TextUtils.isEmpty(reponse)){
            try{
                JSONArray allCities = new JSONArray(reponse);
                for (int i = 0; i < allCities.length(); i++){
                    JSONObject cityObject = allCities.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCode(cityObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }

    /**
     * 解析和处理服务器返回的县级数据
     */
    public static boolean handleCountyResponse(String reponse, int cityId) {
        if (!TextUtils.isEmpty(reponse)){
            try{
                JSONArray allCounties = new JSONArray(reponse);
                for (int i = 0; i < allCounties.length(); i++){
                    JSONObject countyObject = allCounties.getJSONObject(i);
                    County county = new County();
                    county.setCountyName(countyObject.getString("name"));
                    county.setWeatherId(countyObject.getInt("id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return false;
    }
}
