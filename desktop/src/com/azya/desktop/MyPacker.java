package com.azya.desktop;

import com.badlogic.gdx.tools.texturepacker.TexturePacker;

public class MyPacker {
    public void main(String[] args) {
      /*  TexturePacker.process("android/assets/skeleton/PNG/attack","android/assets/skeleton" +
                "/atlases","attack");
        TexturePacker.process("android/assets/skeleton/PNG/crouch","android/assets/skeleton" +
                "/atlases","crouch");
        TexturePacker.process("android/assets/skeleton/PNG/walk","android/assets/skeleton/atlases","walk");*/
        TexturePacker.process("android/assets/skeleton/PNG/hit","android/assets/skeleton/atlases",
                "hit");
        TexturePacker.process("android/assets/skeleton/PNG/die","android/assets/skeleton/atlases",
                "die");
    }
}
