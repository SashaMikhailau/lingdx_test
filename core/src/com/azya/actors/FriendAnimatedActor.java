package com.azya.actors;

import com.azya.AnimationUtils;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class FriendAnimatedActor extends AnimatedActor {

	@Override
	public Animation<TextureRegion> setAnimation(Texture spriteSheet, int colCOunt, int rowCount, int frameCount) {
		return AnimationUtils.getAnimationFromSpriteSheetTexture(spriteSheet, colCOunt, rowCount,
				frameCount);
	}

	public FriendAnimatedActor(TextureModel textureModel) {
		super(textureModel);
	}
}
