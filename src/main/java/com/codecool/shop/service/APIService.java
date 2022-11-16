package com.codecool.shop.service;

import com.codecool.shop.model.Drinks;
import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class APIService {

    public static String getStringifiedJson(URL url) throws IOException {
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine = in.readLine();
        con.disconnect();
        return inputLine;
    }

    public static Drinks setupJson(String urlString) throws IOException {
        URL url = new URL(urlString);
        String content = getStringifiedJson(url);
        Drinks drinks = new Gson().fromJson(content, Drinks.class);
        return drinks;
    }
}
