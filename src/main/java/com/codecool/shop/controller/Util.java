package com.codecool.shop.controller;

import com.codecool.shop.model.BaseModel;
import com.codecool.shop.model.Product;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Util {

    public static String getStringifiedJson(URL url) throws IOException {
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine = in.readLine();
        con.disconnect();
        return inputLine;
    }

    static void setupJson(HttpServletResponse response, URL url) throws IOException {
        String content = getStringifiedJson(url);
        System.out.println(content);
//        Type listType = new TypeToken<ArrayList<BaseModel>>(){}.getType();
        BaseModel productList = new Gson().fromJson(content, BaseModel.class);
        System.out.println(productList);
//        Gson gson = new Gson();
//        String fullJson = gson.toJson(gson.toJson(content));
//        System.out.println(fullJson);
//        PrintWriter out = response.getWriter();
//
//        out.println(fullJson);
    }
}
