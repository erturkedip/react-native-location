package com.rnl;


import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.support.v4.app.ActivityCompat;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.mapzen.android.lost.api.LocationListener;
import com.mapzen.android.lost.api.LocationRequest;
import com.mapzen.android.lost.api.LocationServices;
import com.mapzen.android.lost.api.LostApiClient;

import java.util.HashMap;
import java.util.Map;

public class RNReactNativeLocationModule extends ReactContextBaseJavaModule {

    protected static final String TAG = "RNLocation";

    private final ReactApplicationContext reactContext;

    private static final String BALANCED_POWER_KEY = "BALANCED_POWER_ACCURACY";
    private static final String HIGH_ACCURACY_KEY = "HIGH_ACCURACY";
    private static final String LOW_POWER_KEY = "LOW_POWER";
    private static final String NO_POWER_KEY = "NO_POWER";

    private final LocationListener locationListener;
    private final LostApiClient lostApiClient;

    public RNReactNativeLocationModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
        locationListener = new RNReactNativeLocationListener(this.getReactApplicationContext(), new RNReactNativeFactory());

        lostApiClient = new LostApiClient.Builder(this.getReactApplicationContext()).build();
        lostApiClient.connect();
    }

    @Override
    public String getName() {
        return "RNReactNativeLocation";
    }

    @Override
    public Map<String, Object> getConstants() {
        final Map<String, Object> constants = new HashMap<>();
        constants.put(BALANCED_POWER_KEY, LocationRequest.PRIORITY_BALANCED_POWER_ACCURACY);
        constants.put(HIGH_ACCURACY_KEY, LocationRequest.PRIORITY_HIGH_ACCURACY);
        constants.put(LOW_POWER_KEY, LocationRequest.PRIORITY_LOW_POWER);
        constants.put(NO_POWER_KEY, LocationRequest.PRIORITY_NO_POWER);
        return constants;
    }

    @ReactMethod
    public void startLocationPolling(Integer interval, Float distance, int priority) {
        LocationRequest request = LocationRequest.create()
                .setInterval(interval) // milliseconds
                .setSmallestDisplacement(distance) // meters
                .setPriority(priority);

        if (ActivityCompat.checkSelfPermission(getCurrentActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getCurrentActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        LocationServices.FusedLocationApi.requestLocationUpdates(this.lostApiClient, request, this.locationListener);
    }

    @ReactMethod
    public void stopLocationPolling() {
        LocationServices.FusedLocationApi.removeLocationUpdates(this.lostApiClient, this.locationListener);
    }

    @ReactMethod
    public void mockLocation(Float latitude, Float longitude) {
        Location mockLocation = new Location("mock");
        mockLocation.setLatitude(latitude);
        mockLocation.setLongitude(longitude);
        LocationServices.FusedLocationApi.setMockMode(this.lostApiClient, true);
        LocationServices.FusedLocationApi.setMockLocation(this.lostApiClient, mockLocation);
    }

    @ReactMethod
    public void setMockMode(Boolean value) {
        LocationServices.FusedLocationApi.setMockMode(this.lostApiClient, value);
    }
}