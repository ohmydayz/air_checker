package kr.co.ohmydayz.sample.airchecker;

import android.app.Application;

import kr.co.ohmydayz.sample.airchecker.network.NetworkManager;

public class AirCheckApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        NetworkManager.init(this);
    }
}
