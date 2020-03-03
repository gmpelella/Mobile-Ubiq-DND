package com.example.dnd;

//import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class DieRollerActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.die_roller);
    }


    //for each button dude function create popup bro
    public void d4(View view) {
        int num = rollRandom(4);
        Log.d("mytag","uh hello?"+num);
        //alertDialog(num);
    }
    public void d6(View view) {
        int num = rollRandom(6);

        alertDialog(num);
    }
    public void d8(View view) {
        int num = rollRandom(8);
        alertDialog(num);
    }
    public void d10(View view) {
        int num = rollRandom(10);
        alertDialog(num);
    }
    public void d12(View view) {
        int num = rollRandom(12);
        alertDialog(num);
    }
    public void d20(View view) {
        int num = rollRandom(20);
        alertDialog(num);
    }

    public int rollRandom(int maxRoll) {
        //make the object that will do the random rolling
        Random roller = new Random();
        //generate a new random number, add one to move the min from 0 to 1
        int randomRoll = roller.nextInt(maxRoll) + 1;

        //return the generated value
        return randomRoll;
    }
    private void alertDialog(int num) {
        AlertDialog.Builder dialog=new AlertDialog.Builder(this);
        dialog.setMessage(" "+num+" ");
        dialog.setTitle("You rolled:");
        dialog.setPositiveButton("On with the adventure!",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        Toast.makeText(getApplicationContext(),"continuing...",Toast.LENGTH_LONG).show();
                    }
                });
        dialog.setNegativeButton(" ",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"continuing.. ",Toast.LENGTH_LONG).show();
            }
        });
        AlertDialog alertDialog=dialog.create();
        alertDialog.show();
    }
}
