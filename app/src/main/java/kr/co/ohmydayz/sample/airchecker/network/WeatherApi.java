package kr.co.ohmydayz.sample.airchecker.network;

import kr.co.ohmydayz.sample.airchecker.model.WeatherModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Creator : Yeonju Kim
 * Date : 2020년 02월 24일.
 * File Description :
 */


public interface WeatherApi {
    @GET("weather?units=metric&appid=" + NetworkManager.WEATHER_API_SERVICE_KEY)
    Call<WeatherModel> getWeather(@Query("lat") double latitude, @Query("lon") double longitutde);
}
