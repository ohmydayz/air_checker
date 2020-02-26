package kr.co.ohmydayz.sample.airchecker.network;

import android.content.Context;

import com.chuckerteam.chucker.api.ChuckerInterceptor;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkManager {
    //    public static final String OPEN_API_SERVICE_KEY = "EIYNGg9Ujhig9t8puSXN2lA1Zqgqe6Cj0r8akQKlbJgDpPS157uBzZ55kzHVe17aicAT2d31cWKkOMmEcNTyiQ%3D%3D";
    public static final String OPEN_API_SERVICE_KEY = "h4RhMo52FBawFGCI%2BJV4esZZQ28gupFusjKbFG%2Bf2lDnUJ%2FYBYTp9XHZ0I75a4bHs0yfXzzKCrOqdb1Y0p%2FSpQ%3D%3D";
    public static final String WEATHER_API_SERVICE_KEY = "ef98329700fd850e08d1d7b0c5579b2e";

    private static final NetworkManager instance = new NetworkManager();

    private Retrofit openApi;
    private Retrofit weatherApi;

    public static Retrofit getOpenApi() {
        return instance.openApi;
    }
    public static Retrofit getWeatherApi(){
        return instance.weatherApi;
    }

    public static void init(Context context) {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new ChuckerInterceptor(context))
                .build();

        instance.openApi = new Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://openapi.airkorea.or.kr/openapi/services/rest/")
                .build();

        instance.weatherApi = new Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://api.openweathermap.org/data/2.5/")
                .build();
    }
}
