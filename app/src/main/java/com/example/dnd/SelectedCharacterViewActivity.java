package com.example.dnd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import android.widget.*;


import com.example.dnd.CharSheet.Character;

public class SelectedCharacterViewActivity extends AppCompatActivity {

    Character sampleChar;
    EditText charName;
    //ImageView charView
    EditText classLevel;
    EditText races;
    EditText background;
    EditText armourClass;
    EditText initiative;
    EditText speed;



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

        charName = (EditText) findViewById(R.id.selectedCharacterName);
        classLevel = (EditText) findViewById(R.id.classLevel);
        races = (EditText) findViewById(R.id.Race);
        background = (EditText) findViewById(R.id.background);
        armourClass = (EditText) findViewById(R.id.armorClassValue);
        initiative = (EditText) findViewById(R.id.initiativeValue);
        speed = (EditText) findViewById(R.id.speedValue);

        sampleChar = (Character) getIntent().getSerializableExtra("charSheet");

        charName.setText(sampleChar.NAME);
        classLevel.setText(sampleChar.getFirstClass() + sampleChar.level);
        races.setText(sampleChar.RACE.name);
        background.setText(sampleChar.BACKGROUND);
        armourClass.setText(sampleChar.combatInfo.armourClass + "");
        initiative.setText(sampleChar.combatInfo.initiative + "");
        speed.setText(sampleChar.combatInfo.getFirstSpeed() + "");
    }




    public void changeCharacterImage(View view) {

    }

    public void launchStatsPage(View view) {
        Intent intent = new Intent(this, StatsPageActivity.class);
        startActivity(intent);
    }

    public void launchDieRoller(View view) {
        Intent intent = new Intent(this, DieRollerActivity.class);

        startActivityForResult(intent, 1);
    }

    public void obBackPressed(){
        Intent replyIntent = new Intent();
        replyIntent.putExtra("charSheet", sampleChar);
        setResult(RESULT_OK, replyIntent);

        this.finish();
    }

    @Override
    public void onActivityResult(int requestCode,
                                 int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                sampleChar = (Character) getIntent().getSerializableExtra("charSheet");
            }
        }
    }
}
