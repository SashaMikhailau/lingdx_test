package com.azya.models;

import lombok.Data;

@Data
public abstract class Model {
    private int hp;
    private int initialHp;
    private int power;
    private int critRate;
    private String name;
    private String assetName;
}
