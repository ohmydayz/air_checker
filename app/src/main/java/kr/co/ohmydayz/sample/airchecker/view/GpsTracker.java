package kr.co.ohmydayz.sample.airchecker.view;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;

import com.google.android.gms.location.FusedLocationProviderClient;

import static android.content.Context.LOCATION_SERVICE;


public class GpsTracker {

    private final Context mContext;
    Location location;
    double latitude;
    double longitude;

    protected LocationManager locationManager;


    public GpsTracker(Context context) {
        this.mContext = context;
    }

    public Location getLocation(OnGetLocationListener listener) {
        try {
            locationManager = (LocationManager) mContext.getSystemService(LOCATION_SERVICE);

            boolean isGPSEnabled = locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER);
            boolean isNetworkEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

            if (!isGPSEnabled && !isNetworkEnabled) {

            } else {
                FusedLocationProviderClient client = new FusedLocationProviderClient(mContext);
                client.getLastLocation().addOnCompleteListener(task -> {
                    if (listener != null) {
                        listener.onGetLocation(task.getResult());
                    }
                });

            }
        } catch (Exception e) {
            Log.d("@@@", "" + e.toString());
        }

        return location;
    }

    public double getLatitude() {
        if (location != null) {
            latitude = location.getLatitude();
        }

        return latitude;
    }

    public double getLongitude() {
        if (location != null) {
            longitude = location.getLongitude();
        }

        return longitude;
    }

    public interface OnGetLocationListener {
        void onGetLocation(Location location);
    }

}