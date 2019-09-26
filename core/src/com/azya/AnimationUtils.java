package com.azya;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Action;

public class AnimationUtils {

	public static final float FRAME_DURATION = 0.48f;

	public static Animation<TextureRegion> getAnimationFromSpriteSheetTexture(Texture spriteSheet,
																			  int colsCount, int rowsCount, int frameCount) {
		TextureRegion[] textureRegions = getTextureRegionsFromSpriteSheet(spriteSheet, colsCount, rowsCount, frameCount);
		return new Animation<TextureRegion>(FRAME_DURATION/frameCount, textureRegions);
	}

	public static Animation<TextureRegion> getMirroredAnimationFromSpriteSheetTexture(Texture spriteSheet,
																					  int colsCount, int rowsCount, int frameCount) {
		TextureRegion[] textureRegions = getTextureRegionsFromSpriteSheet(spriteSheet, colsCount, rowsCount, frameCount);
		for (TextureRegion textureRegion : textureRegions) {
			textureRegion.flip(true, false);
		}
		return new Animation<TextureRegion>(FRAME_DURATION/frameCount, textureRegions);
	}

	private static TextureRegion[] getTextureRegionsFromSpriteSheet(Texture spriteSheet, int colsCount, int rowsCount, int frameCount) {
		TextureRegion[][] split = TextureRegion.split(spriteSheet, spriteSheet.getWidth() / colsCount,
				spriteSheet.getHeight() / rowsCount);
		TextureRegion[] textureRegions = new TextureRegion[frameCount];
		int index = 0;
		for (int i = 0; i < split.length; i++) {
			for (int j = 0; j < split[i].length; j++) {
				textureRegions[index++] = split[i][j];
				if (index == frameCount) {
					break;
				}
			}
		}
		return textureRegions;
	}

}
