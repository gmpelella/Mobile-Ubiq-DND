package com.example.dnd;

import android.content.Context;

import com.example.dnd.CharSheet.Character;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class characterIO {
    private Context currContext;

    public characterIO(Context _currContext){
        currContext = _currContext;
    }

    public void storeChar(Character character) {
        try {
            FileOutputStream fos = currContext.openFileOutput("sampleChar", Context.MODE_PRIVATE);
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(this);
            os.close();
            fos.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public Character readChar(){
        try{
            FileInputStream fis = currContext.openFileInput("sampleChar");
            ObjectInputStream is = new ObjectInputStream(fis);
            Character importedChar = (Character) is.readObject();
            is.close();
            fis.close();
            return importedChar;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
