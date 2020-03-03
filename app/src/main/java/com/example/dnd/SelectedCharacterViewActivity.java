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
<<<<<<< HEAD

    public void launchStatsPage(View view) {
        Intent intent = new Intent(this, StatsPageActivity.class);
=======
    public void launchDieRoller(View view) {
        Intent intent = new Intent(this, DieRollerActivity.class);
>>>>>>> 11a8bf8333b7d1f79ebd06c1f16fd5d73fa3dfa0
        startActivity(intent);
    }
}
