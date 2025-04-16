package com.kmehta.journalApp.service;

import com.kmehta.journalApp.api.response.WeatherResponse;
import com.kmehta.journalApp.cache.AppCache;
import com.kmehta.journalApp.constants.PlaceHolders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    @Value("${weather_api_key}")
    private String apiKey;

    @Autowired
    private AppCache appCache;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private RedisService redisService;

    public WeatherResponse getWeather(String city) {

        try {
            WeatherResponse cachedResponse = redisService.get("Weather_of_" + city, WeatherResponse.class);
            if (cachedResponse != null) {
                return cachedResponse;
            } else {
                String finalApi = appCache.APP_CACHE.get(AppCache.keys.WEATHER_API.toString()).replace(PlaceHolders.CITY, city).replace(PlaceHolders.API_KEY, apiKey);
                ResponseEntity<WeatherResponse> response = restTemplate.exchange(finalApi, HttpMethod.GET, null, WeatherResponse.class);
                WeatherResponse body = response.getBody();
                if(body!=null){
                    redisService.set("Weather_of_" + city,body,300l);
                }
                return body;
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
