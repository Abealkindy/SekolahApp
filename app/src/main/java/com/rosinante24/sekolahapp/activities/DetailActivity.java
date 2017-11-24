package com.rosinante24.sekolahapp.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.rosinante24.sekolahapp.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity implements OnMapReadyCallback {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.imagebackdetail)
    ImageView imagebackdetail;
    @BindView(R.id.viewDetail)
    View viewDetail;
    @BindView(R.id.textnamadetail)
    TextView textnamadetail;
    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout toolbarLayout;
    @BindView(R.id.app_bar)
    AppBarLayout appBar;
    @BindView(R.id.textdeskripsi)
    TextView textdeskripsi;
    @BindView(R.id.texttelpon)
    TextView texttelpon;
    @BindView(R.id.buttoncall)
    Button buttoncall;

    private GoogleMap googleMaps;
    private String nama, alamat, lat, lang, npsn, kecamatan, kelurahan, kota, notelp;
    private int gambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        nama = getIntent().getStringExtra("nama");
        alamat = getIntent().getStringExtra("alamat");
        lat = getIntent().getStringExtra("latitude");
        lang = getIntent().getStringExtra("longitude");
        npsn = getIntent().getStringExtra("npsn");
        kecamatan = getIntent().getStringExtra("kecamatan");
        kelurahan = getIntent().getStringExtra("kelurahan");
        kota = getIntent().getStringExtra("kota");
        notelp = getIntent().getStringExtra("telp");
        gambar = getIntent().getIntExtra("gambar", 0);

        textnamadetail.setText(nama);
        imagebackdetail.setImageResource(gambar);
        textdeskripsi.setText("Nomor NPSN : " + npsn + "\n\n");
        textdeskripsi.append("Kelurahan : " + kelurahan + "\n\n");
        textdeskripsi.append("Kecamatan : " + kecamatan + "\n\n");
        textdeskripsi.append("Kota : " + kota + "\n");
        texttelpon.setText("Nomor Telpon : " + notelp);
        buttoncall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_CALL);
                intent.setData(Uri.parse("tel:" + notelp));
                if (ActivityCompat.checkSelfPermission(DetailActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(intent);
            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        googleMaps = googleMap;
        double latitude, longitude;
        latitude = Double.parseDouble(lat);
        longitude = Double.parseDouble(lang);
        LatLng sydney = new LatLng(latitude, longitude);
        googleMaps.addMarker(new MarkerOptions().position(sydney).title(alamat));
        googleMaps.moveCamera(CameraUpdateFactory.newLatLng(sydney));
        googleMaps.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 16));
        googleMaps.getUiSettings().setAllGesturesEnabled(true);
        googleMaps.getUiSettings().setZoomGesturesEnabled(true);
    }
}
