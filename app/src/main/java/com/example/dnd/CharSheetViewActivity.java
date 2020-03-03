package com.example.dnd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class CharSheetViewActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.character_sheet_view_main);
        //This is the page wherein all of the characters stored on the device are listed.
        //This consists of a linearLayout, which should be populated with buttons for each person in database.
        //There is a sample button currently in the xml file containing all the information which should be generated with each button.

        //take an array of chars
        //for each char
        //create a new button
        //w everything thats currently in the existing button
        //make the text of the button = the name of the character, class, level

//        Button myButton = new Button(this);
//        myButton.setText("Push Me");
//
//        LinearLayout ll = (LinearLayout)findViewById(R.id.buttonlayout);
//        LayoutParams lp = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
//        ll.addView(myButton, lp);

    }

    public void launchSelectedCharView(View view) {
        Intent intent = new Intent(this, SelectedCharacterViewActivity.class);
        startActivity(intent);
    }


}
