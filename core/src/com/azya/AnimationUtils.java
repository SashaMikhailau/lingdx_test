package com.azya;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class AnimationUtils {

	public static final float FRAME_DURATION = 0.08f;

	public static Animation<TextureRegion> getAnimationFromSpriteSheetTexture(String pathToTexture, int colsCount, int rowsCount,int frameCount){
		Texture spriteSheet = new Texture(Gdx.files.internal(pathToTexture));
		TextureRegion[][] split = TextureRegion.split(spriteSheet, spriteSheet.getWidth() / colsCount,
				spriteSheet.getHeight() / rowsCount);
		TextureRegion[] textureRegions = new TextureRegion[frameCount];
		int index = 0;
		for (int i = 0; i < split.length; i++) {
			for (int j = 0; j < split[i].length; j++) {
				textureRegions[index++] = split[i][j];
				if(index==frameCount){
					break;
				}
			}
		}
		spriteSheet.dispose();
		return new Animation<TextureRegion>(FRAME_DURATION, textureRegions);
	}
}
