package com.example.mountainclimbingapp.Interface;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class JsonParserMap {
    private HashMap<String,String> parseJsonObjectMap(JSONObject object) {
        HashMap<String, String> dataList = new HashMap<>();
        try {
            String name = object.getString("name");

            String latitude = object.getJSONObject("geometry")
                    .getJSONObject("location").getString("lat");

            String longitude = object.getJSONObject("geometry")
                    .getJSONObject("location").getString("lng");


            dataList.put("name", name);
            dataList.put("lat", latitude);
            dataList.put("longitude", longitude);

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return dataList;
    }
    private List<HashMap<String, String>> parseJasonArray(JSONArray jsonArray){
        List<HashMap<String,String>> datalist = new ArrayList<>();

        for ( int i=0; i<jsonArray.length(); i++){
            try {
                HashMap<String, String> data = parseJsonObjectMap((JSONObject) jsonArray.get(i));
                datalist.add(data);
            }catch (JSONException e){
                e.printStackTrace();

            }
        }
        return datalist;
    }
    public List<HashMap<String, String>> parseResult(JSONObject object){
        JSONArray jsonArray = null;
        try {
            jsonArray = object.getJSONArray("results");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return  parseJasonArray(jsonArray);
    }
}

