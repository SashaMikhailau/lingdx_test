package com.azya.actors;

import com.azya.AnimationUtils;
import com.azya.MyInputListener;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class EnemyAnimatedActor extends AnimatedActor {
	@Override
	public Animation<TextureRegion> setAnimation(Texture spriteSheet, int colCOunt, int rowCount, int frameCount) {
		return AnimationUtils.getMirroredAnimationFromSpriteSheetTexture(spriteSheet, colCOunt, rowCount,
				frameCount);
	}

	public EnemyAnimatedActor(TextureModel textureModel) {
		super(textureModel);
		addListener(new MyInputListener());
	}
}
