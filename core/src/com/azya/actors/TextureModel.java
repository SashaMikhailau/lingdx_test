package com.azya.actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class TextureModel {
    public static final String pathToCrouchAnimation = "/atlases/crouch.atlas";
    public static final String pathToAttackAnimation = "/atlases/attack.atlas";
    public static final String pathToWalkAnimation = "/atlases/walk.atlas";
    public static final String pathToHitAnimation = "/atlases/hit.atlas";
    private TextureAtlas attackSpriteSheet;
    private TextureAtlas walkSpriteSheet;
    private TextureAtlas crouchSpriteSheet;
    private TextureAtlas hitSpriteSheet;

    public TextureModel(TextureAtlas attackSpreadSheet, TextureAtlas walkSpreadSheet,
                        TextureAtlas crouchSpreadSheet, TextureAtlas hitSpreadSheet) {
        this.attackSpriteSheet = attackSpreadSheet;
        this.walkSpriteSheet = walkSpreadSheet;
        this.crouchSpriteSheet = crouchSpreadSheet;
        this.hitSpriteSheet = hitSpreadSheet;
    }

    public TextureModel(String path) {
        crouchSpriteSheet = new TextureAtlas(Gdx.files.internal(path + pathToCrouchAnimation));
        attackSpriteSheet = new TextureAtlas(Gdx.files.internal(path + pathToAttackAnimation));
        walkSpriteSheet = new TextureAtlas(Gdx.files.internal(path + pathToWalkAnimation));
        hitSpriteSheet = new TextureAtlas(Gdx.files.internal(path + pathToHitAnimation));
    }

    public TextureAtlas getAttackSpriteSheet() {
        return attackSpriteSheet;
    }

    public TextureAtlas getWalkSpriteSheet() {
        return walkSpriteSheet;
    }

    public TextureAtlas getCrouchSpriteSheet() {
        return crouchSpriteSheet;
    }

    public TextureAtlas getHitSpriteSheet() {
        return hitSpriteSheet;
    }

    public void dispose(){
    	attackSpriteSheet.dispose();
    	walkSpriteSheet.dispose();
    	crouchSpriteSheet.dispose();
    	hitSpriteSheet.dispose();
	}
}
