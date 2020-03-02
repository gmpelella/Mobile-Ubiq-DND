package com.example.dnd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;


public class MainActivity extends AppCompatActivity {
    //DND START

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchCreateChar(View view) {
        Intent intent = new Intent(this, CreateCharActivity.class);
        startActivity(intent);
    }

    public void launchViewChars(View view) {
        Intent intent = new Intent(this, CharSheetViewActivity.class);
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
}
