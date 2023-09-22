package com.example.appsettings;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    private TextView textNumber;
    private RelativeLayout background;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        updateView();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        updateView();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_choice, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.settings_item) {
            goToSettingsActivity();
        }
        return super.onOptionsItemSelected(item);
    }

    private void goToSettingsActivity() {
        startActivity(new Intent(this, SettingsActivity.class));
    }

    private void updateView() {
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        String number = sharedPref.getString("number", "0");
        String color = sharedPref.getString("background_color", "#CCCCCC");

        textNumber = findViewById(R.id.tv_number);
        background = findViewById(R.id.layout_background);

        textNumber.setText(number);
        background.setBackgroundColor(Color.parseColor(color));

    }
}