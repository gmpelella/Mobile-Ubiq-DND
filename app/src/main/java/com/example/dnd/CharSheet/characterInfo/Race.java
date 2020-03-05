package com.example.dnd.CharSheet.characterInfo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

public class Race implements Serializable {
    public String name;

    public Race(@JsonProperty("name") String _name){
        name = _name;
    }
}
