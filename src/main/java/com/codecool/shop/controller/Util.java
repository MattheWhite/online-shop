package com.codecool.shop.controller;

import com.codecool.shop.model.Drinks;
import com.google.gson.Gson;

import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

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
        Drinks drinks = new Gson().fromJson(content, Drinks.class);
        String jsonResp = new Gson().toJson(drinks.getDrinks());
        System.out.println(jsonResp);
    }
}
