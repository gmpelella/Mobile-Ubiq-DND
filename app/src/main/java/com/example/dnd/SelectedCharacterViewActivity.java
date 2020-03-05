package com.example.dnd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.dnd.CharSheet.Character;

public class SelectedCharacterViewActivity extends AppCompatActivity {

    Character sampleChar;
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

        sampleChar = (Character) getIntent().getSerializableExtra("charSheet");
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
