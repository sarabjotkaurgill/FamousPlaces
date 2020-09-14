package com.example.famousplaces;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class ViewPlaceActivity extends AppCompatActivity {

    ImageView pImage;
    TextView pName, pDesc;
    Button mapBtn;
    Double lat, longt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_place);

        pImage  = findViewById(R.id.pImage);
        pName   = findViewById(R.id.pName);
        pDesc   = findViewById(R.id.pDesc);
        mapBtn  = findViewById(R.id.viewMap);

        Intent intent = getIntent();
        int intValue = intent.getIntExtra("place", 0);

        pImage.setImageResource(HomeActivity.show_places.get(intValue).getPlaceImage());
        pName.setText(HomeActivity.show_places.get(intValue).getPlaceName());
        pDesc.setText(HomeActivity.show_places.get(intValue).getPlaceDesc());

        lat   = HomeActivity.show_places.get(intValue).getPlaceLat();
        longt = HomeActivity.show_places.get(intValue).getPlaceLong();
        Log.e("lat", lat.toString());
        Log.e("longt", longt.toString());
        mapBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uri = String.format(Locale.ENGLISH, "http://maps.google.com/maps?q=loc:%f,%f", lat,longt);
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(uri));
                startActivity(intent);
            }
        });
    }
}
