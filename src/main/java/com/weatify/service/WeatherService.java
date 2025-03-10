package com.weatify.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.net.*;
import java.io.*;

@Service
public class WeatherService {

    @Value("${API_KEY}")
    private String API_KEY;

    public String getWeatherFromAPI(String regCode) throws Exception {
        String apiUrl = "https://apihub.kma.go.kr/api/typ01/url/wrn_met_data.php?"
                + "reg=" + regCode
                + "&disp=0&authKey=" + API_KEY;   // API_KEY

        URL url = new URL(apiUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setRequestProperty("Content-Type", "application/json");

        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder response = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response.toString();
    }
}
