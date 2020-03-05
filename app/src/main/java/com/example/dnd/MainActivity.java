package com.example.dnd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.dnd.CharSheet.Item.MoneyValue;
import com.example.dnd.CharSheet.Item.Weapon;
import com.example.dnd.CharSheet.characterInfo.AbilitiesAndProficiencies;
import com.example.dnd.CharSheet.characterInfo.CombatInfo;
import com.example.dnd.CharSheet.characterInfo.Race;
import com.example.dnd.CharSheet.characterInfo.Spell;
import com.example.dnd.CharSheet.Character;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    //DND START

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        createAndStoreSampleChar();
    }

    public void launchCreateChar(View view) {
        Intent intent = new Intent(this, CreateCharActivity.class);
        startActivity(intent);
    }

    public void launchViewChars(View view) {
        Intent intent = new Intent(this, CharSheetViewActivity.class);
        intent.putExtra("charSheet", loadSampleChar());

        startActivity(intent);
    }

    public void launchImportChar(View view) {
        Intent intent = new Intent(this, ImportCharActivity.class);
        startActivity(intent);
    }

    public void launchExportChar(View view) {
        Intent intent = new Intent(this, ExportCharActivity.class);
        startActivity(intent);
    }

    public void createAndStoreSampleChar(){
        characterIO charIO = new characterIO(getApplicationContext());

        Character sampleChar = new Character("Kel'Shri", new Race("Wood Elf"), "Noble", "Neutral Good",
                "greatQuestion", 2, new String[]{"Cleric"}, 500, new CombatInfo(3,
                new int[]{30}, 15, 9, 9, 0, new int[]{6}, 0,0),
                new Weapon[]{new Weapon("knife", Weapon.damageTypes.ACID, new int[]{3},
                        new MoneyValue(0,1,0,0,0,false, false),
                        new Weapon.weaponProperties[]{Weapon.weaponProperties.LIGHT}, 1)},
                new Spell[0], new Spell[0], new AbilitiesAndProficiencies(2,
                new ArrayList<>(Arrays.asList(new AbilitiesAndProficiencies.allProficiencies[]{AbilitiesAndProficiencies.allProficiencies.CONSTITUTION})),
                13, 7,10,14,10, 9));

            charIO.storeChar(sampleChar, this);
    }

    public Character loadSampleChar(){
        characterIO charIO = new characterIO(getApplicationContext());
        Character retrievedCharJSON = charIO.readChar();

        Log.i("Pointless Log", "Breakpoint Me");

        return retrievedCharJSON;
    }

}
