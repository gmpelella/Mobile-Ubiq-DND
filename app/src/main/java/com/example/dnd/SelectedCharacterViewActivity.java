package com.example.dnd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SelectedCharacterViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //CHRIS this is where you would fill all the windows with the character information as it was last saved
        //you have windows for:
        /*
        Character name
        character class/level
        character race
        character background
        armor class
        initiative
        speed
        that's all the fillable things on this window
         */



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selected_character_view);
    }




    public void changeCharacterImage(View view) {

    }

    public void launchStatsPage(View view) {
        Intent intent = new Intent(this, StatsPageActivity.class);
        startActivity(intent);
    }

    public void launchDieRoller(View view) {
        Intent intent = new Intent(this, DieRollerActivity.class);

        startActivity(intent);
    }
}
