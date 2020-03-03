package com.example.dnd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StatsPageActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stats_page);
    }

    public void launchDieRoller(View view) {
        Intent intent = new Intent(this, DieRollerActivity.class);
        startActivity(intent);
    }

}
