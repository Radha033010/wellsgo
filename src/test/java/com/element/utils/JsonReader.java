package com.element.utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

public class JsonReader {

    public String jsonReader(String getJson ,int list, String feature ,String path)
    {
        try {
            JSONParser jsonParser = new JSONParser();
            FileReader reader = new FileReader(path);
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONArray companyDetailsList = (JSONArray) obj;
//            System.out.println("Users List-> " + companyDetailsList);
            JSONObject company = (JSONObject) companyDetailsList.get(list);
//            System.out.println("Users -> " + company);//This prints every block - one json object
            JSONObject user = (JSONObject) company.get(feature);
//            System.out.println(user);
            String Entitname = (String) user.get(getJson);
            return Entitname;
        } catch (Exception exception) {
        }
        return null;
    }
}
