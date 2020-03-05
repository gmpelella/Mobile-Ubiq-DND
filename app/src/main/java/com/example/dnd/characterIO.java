package com.example.dnd;

import android.app.Activity;
import android.content.Context;
import android.util.Log;

import com.example.dnd.CharSheet.Character;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class characterIO {
    private Context currContext;

    public characterIO(Context _currContext){
        currContext = _currContext;
    }

    public void storeChar(Character character, Activity currActivity) {
        try {
            //JSON Serializer
            ObjectMapper mapper = new ObjectMapper();
            mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
            FileOutputStream jsonFile = currContext.openFileOutput("sampleChar.json", Context.MODE_PRIVATE);

            mapper.writeValue(jsonFile, character);

        }catch(Exception e){
            Log.e("FileWriting" , e.getMessage());
        }
    }

    public Character readChar(){
        try{
            FileInputStream fis = currContext.openFileInput("sampleChar.json");
            ObjectMapper mapper = new ObjectMapper();
            mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);

            Character importedChar = mapper.readValue(fis, Character.class);

            fis.close();
            return  importedChar;
        }catch(Exception e){
            Log.e("FileReading" , e.getMessage());
        }
        return null;
    }
}
