package com.outfit.weather;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class WeatherApiConnection {

    // == fields ==

    private final String API_KEY = "0568df02db4ce2fb48547646fd2789b7";
    private String urlString;


    // == public methods ==

    public Map<String, Object> jsonToMap(String str) {
        Map<String, Object> map = new Gson().fromJson(
                str, new TypeToken<HashMap<String, Object>>() {}.getType()
        );
        return map;
    }

    public Map<String, Object> getMaps(int zipCode, String countryCode) {
        try {
            StringBuilder result = new StringBuilder();
            URL url = new URL(urlString = "http://api.openweathermap.org/data/2.5/weather?zip=" + zipCode + "," + countryCode + "&appid=" + API_KEY
                    + "&units=imperial");
            URLConnection conn = url.openConnection();
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;
            while ((line = rd.readLine()) != null) {
                result .append(line);
            }
            rd.close();
            System.out.println(result);

            Map<String, Object> respMap = jsonToMap(result.toString());
            Map<String, Object> mainMap = jsonToMap(respMap.get("main").toString());
            return mainMap;

        } catch (IOException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
