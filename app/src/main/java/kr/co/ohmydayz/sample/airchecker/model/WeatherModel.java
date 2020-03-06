package kr.co.ohmydayz.sample.airchecker.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Creator : Yeonju Kim
 * Date : 2020년 02월 24일.
 * File Description :
 */


public class WeatherModel implements Serializable {
    @SerializedName("weather")
    private List<Weather> weather = null;
    @SerializedName("main")
    private Main main;
    @SerializedName("wind")
    private Wind wind;
    @SerializedName("clouds")
    private Clouds clouds;
    @SerializedName("sys")
    private Sys sys;

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public Sys getSys() {
        return sys;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public class Weather implements Serializable {

        @SerializedName("id")
        private Integer id;
        @SerializedName("main")
        private String main;
        @SerializedName("description")
        private String description;
        @SerializedName("icon")
        private String icon;
        private final static long serialVersionUID = -7238799741667328011L;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getMain() {
            return main;
        }

        public void setMain(String main) {
            this.main = main;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

    }

    public class Main implements Serializable {

        @SerializedName("temp")
        private Double temp;
        @SerializedName("feels_like")
        private Double feels_like;
        @SerializedName("temp_min")
        private Double temp_min;
        @SerializedName("temp_max")
        private Double temp_max;
        @SerializedName("pressure")
        private Integer pressure;
        @SerializedName("humidity")
        private Integer humidity;
        private final static long serialVersionUID = -3742609839323393869L;

        public Double getTemp() {
            return temp;
        }

        public void setTemp(Double temp) {
            this.temp = temp;
        }

        public Double getFeels_like() {
            return feels_like;
        }

        public void setFeels_like(Double feels_like) {
            this.feels_like = feels_like;
        }

        public Double getTemp_min() {
            return temp_min;
        }

        public void setTemp_min(Double temp_min) {
            this.temp_min = temp_min;
        }

        public Double getTemp_max() {
            return temp_max;
        }

        public void setTemp_max(Double temp_max) {
            this.temp_max = temp_max;
        }

        public Integer getPressure() {
            return pressure;
        }

        public void setPressure(Integer pressure) {
            this.pressure = pressure;
        }

        public Integer getHumidity() {
            return humidity;
        }

        public void setHumidity(Integer humidity) {
            this.humidity = humidity;
        }

    }

    public class Sys implements Serializable {

        @SerializedName("type")
        private Integer type;
        @SerializedName("id")
        private Integer id;
        @SerializedName("country")
        private String country;
        @SerializedName("sunrise")
        private Integer sunrise;
        @SerializedName("sunset")
        private Integer sunset;
        private final static long serialVersionUID = -2323426395490703987L;

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public Integer getSunrise() {
            return sunrise;
        }

        public void setSunrise(Integer sunrise) {
            this.sunrise = sunrise;
        }

        public Integer getSunset() {
            return sunset;
        }

        public void setSunset(Integer sunset) {
            this.sunset = sunset;
        }

    }

    public class Wind implements Serializable {

        @SerializedName("speed")
        private double speed;
        @SerializedName("deg")
        private Integer deg;
        private final static long serialVersionUID = -8666756660275293167L;

        public double getSpeed() {
            return speed;
        }

        public void setSpeed(double speed) {
            this.speed = speed;
        }

        public Integer getDeg() {
            return deg;
        }

        public void setDeg(Integer deg) {
            this.deg = deg;
        }

    }

    public class Clouds implements Serializable {
        @SerializedName("all")
        private Integer all;
        private final static long serialVersionUID = 3082534180060001277L;

        public Integer getAll() {
            return all;
        }

        public void setAll(Integer all) {
            this.all = all;
        }

    }
}