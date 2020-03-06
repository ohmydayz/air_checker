package kr.co.ohmydayz.sample.airchecker.view;

import android.annotation.SuppressLint;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

import kr.co.ohmydayz.sample.airchecker.R;
import kr.co.ohmydayz.sample.airchecker.model.GuAirStatus;
import kr.co.ohmydayz.sample.airchecker.model.WeatherModel;
import kr.co.ohmydayz.sample.airchecker.network.NetworkManager;
import kr.co.ohmydayz.sample.airchecker.network.WeatherApi;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AirStatusActivity extends AppCompatActivity {

    public static final String INTENT_CITY_STATUS = "CITY_STATUS";
    private GpsTracker gpsTracker;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_air_status);

        GuAirStatus.CityStatus cityStatus = (GuAirStatus.CityStatus) getIntent().getSerializableExtra(INTENT_CITY_STATUS);

        if (cityStatus == null) {
            Toast.makeText(this, "잘못된 접근입니다.", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }


        TextView cityTextView = findViewById(R.id.cityTextView);
        TextView dateTimeTextView = findViewById(R.id.dateTimeTextView);
        TextView so2ValueTextView = findViewById(R.id.so2ValueTextView);
        TextView coValueTextView = findViewById(R.id.coValueTextView);
        TextView o3ValueTextView = findViewById(R.id.o3ValueTextView);
        TextView no2ValueTextView = findViewById(R.id.no2ValueTextView);
        TextView pm10ValueTextView = findViewById(R.id.pm10ValueTextView);
        TextView pm25ValueTextView = findViewById(R.id.pm25ValueTextView);

        cityTextView.setText(cityStatus.시군구);
        dateTimeTextView.setText(cityStatus.측정일시);
        so2ValueTextView.setText(cityStatus.아황산가스_평균농도 + "ppm");
        coValueTextView.setText(cityStatus.일산화탄소_평균농도 + "ppm");
        o3ValueTextView.setText(cityStatus.오존_평균농도 + "ppm");
        no2ValueTextView.setText(cityStatus.이산화질소_평균농도 + "ppm");
        pm10ValueTextView.setText(cityStatus.미세먼지_평균농도 + "㎍/㎥");
        pm25ValueTextView.setText(cityStatus.초미세먼지_평균농도 + "㎍/㎥");


        final TextView textviewAddress = (TextView) findViewById(R.id.textview_address);
        Button button = findViewById(R.id.checkAddress);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        gpsTracker = new GpsTracker(AirStatusActivity.this);
        gpsTracker.getLocation(new GpsTracker.OnGetLocationListener() {
            @Override
            public void onGetLocation(Location location) {
                Toast.makeText(AirStatusActivity.this, location.getLatitude() + ", " + location.getLongitude(), Toast.LENGTH_SHORT).show();

                NetworkManager.getWeatherApi()
                        .create(WeatherApi.class)
                        .getWeather(location.getLatitude(), location.getLongitude())
                        .enqueue(new Callback<WeatherModel>() {
                            @Override
                            public void onResponse(Call<WeatherModel> call, Response<WeatherModel> response) {
                                if (response.isSuccessful()) {
                                    WeatherModel weatherStatus = response.body();
                                    Log.d("qq", weatherStatus.getWind().getSpeed() + "");
                                    Log.d("qq", weatherStatus.getWeather().get(0).getDescription());

                                }
                            }

                            @Override
                            public void onFailure(Call<WeatherModel> call, Throwable t) {
                                t.printStackTrace();
                                Toast.makeText(AirStatusActivity.this, "네트워크 연결을 확인해주세요.", Toast.LENGTH_SHORT).show();
                            }
                        });
            }
        });

    }



}

