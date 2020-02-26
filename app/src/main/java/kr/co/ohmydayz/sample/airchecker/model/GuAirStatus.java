package kr.co.ohmydayz.sample.airchecker.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class GuAirStatus {
    @SerializedName("list")
    public List<CityStatus> cityStatuses;

    public static class CityStatus implements Serializable {
        @SerializedName("dataTime")
        public String 측정일시;
        @SerializedName("cityName")
        public String 시군구;
        @SerializedName("so2Value")
        public String 아황산가스_평균농도;
        @SerializedName("coValue")
        public String 일산화탄소_평균농도;
        @SerializedName("o3Value")
        public String 오존_평균농도;
        @SerializedName("no2Value")
        public String 이산화질소_평균농도;
        @SerializedName("pm10Value")
        public String 미세먼지_평균농도;
        @SerializedName("pm25Value")
        public String 초미세먼지_평균농도;
    }
}
