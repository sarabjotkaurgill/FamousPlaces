package com.example.famousplaces;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    private final String EMAIL_KEY = "email";
    private final String PASSWORD_KEY = "password";
    private SharedPreferences sharedPreferences;
    ListView famousPlaces;
    public static ArrayList<FamousPlacesArray> show_places = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        String SHARED_PREFERENCES_FILE = "com.example.myapplication";
        sharedPreferences = getSharedPreferences(SHARED_PREFERENCES_FILE, MODE_PRIVATE);

        famousPlaces = findViewById(R.id.famousPlaces);

        show_places.add(new FamousPlacesArray(getString(R.string.mont_royal), getString(R.string.mont_royal_des), 45.516109,-73.643059, R.drawable.mount_royal));
        show_places.add(new FamousPlacesArray(getString(R.string.vieux_montreal), getString(R.string.vieux_montreal_des),  45.516136,-73.656830, R.drawable.vieux_montreal));
        show_places.add(new FamousPlacesArray(getString(R.string.jardin_bonatique), getString(R.string.jardin_bonatique_des), 45.554331116 ,-73.554081117, R.drawable.botanical_garden));
        show_places.add(new FamousPlacesArray(getString(R.string.notre_dame_basilica), getString(R.string.notre_dame_basilica_des), 45.5027, -73.5538, R.drawable.norte_dame));
        show_places.add(new FamousPlacesArray(getString(R.string.parc_jean_drapeau), getString(R.string.parc_jean_drapeau_des), 45.517066,-73.533580, R.drawable.parc_jean_drapeau));
        show_places.add(new FamousPlacesArray(getString(R.string.pointe_a_calliere), getString(R.string.pointe_a_calliere_des), 45.480270,-73.793137, R.drawable.pointe_a_calliere));
        show_places.add(new FamousPlacesArray(getString(R.string.place_des_arts), getString(R.string.place_des_arts_des), 45.5083,73.5664, R.drawable.place_des_arts));
        show_places.add(new FamousPlacesArray(getString(R.string.mary_queen), getString(R.string.mary_queen_des), 45.4992,73.5682, R.drawable.mary_queen));
        show_places.add(new FamousPlacesArray(getString(R.string.mcCord_museum), getString(R.string.mcCord_museum_des), 45.5043,73.5734, R.drawable.mccord_museum));
        show_places.add(new FamousPlacesArray(getString(R.string.lachine_canal), getString(R.string.lachine_canal_des), 45.4310,73.6704, R.drawable.lachine_canel));

        PlacesAdapter pAdapter = new PlacesAdapter(show_places, getApplicationContext());
        famousPlaces.setAdapter(pAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.menu_logout) {
            AlertDialog.Builder customBuilder = new AlertDialog.Builder(this);
            customBuilder.setTitle(R.string.logout_alert);
            customBuilder.setMessage(R.string.alert_logout_msg);
            customBuilder.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.clear();
                    //editor.remove(EMAIL_KEY);
                    //editor.remove(PASSWORD_KEY);
                    editor.apply();
                    Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
            customBuilder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            customBuilder.create().show();
        }
        return true;
    }
}