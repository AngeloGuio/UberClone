package com.cibertec.uberclone.activities.diver;

import android.content.Intent;
import android.location.Location;
import android.location.LocationRequest;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.cibertec.myapplication.R;
import com.cibertec.myapplication.includes.MyToolbar;
import com.cibertec.myapplication.providers.AuthProvider;
import com.cibertec.uberclone.activities.MainActivity;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

public class MapDriverActivity extends AppCompatActivity  implements OnMapReadyCallback{

    private AuthProvider mAuthProvider;
    private GoogleMap mMap;
    private SupportMapFragment mMapFragment;

    private LocationRequest mLocationRequest;
    private FusedLocationProviderClient mFuseLocation;

    LocationCallback mLocationCallback = new LocationCallback() {
        @Override
        public void onLocationResult(LocationResult locationResult){
            for (Location location: locationResult.getLocations()){
                if (getApplicationContext() != null){
                    //Obtener la localizacion del usuario en tiempo real
                }
            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_driver);
        MyToolbar.show(this,"Conductor",false);

        mAuthProvider = new AuthProvider();

        mMapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mMapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.driver_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.action_logout){
            logout();
        }

        return super.onOptionsItemSelected(item);
    }

    void logout(){
        mAuthProvider.logout();
        Intent intent = new Intent(MapDriverActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}