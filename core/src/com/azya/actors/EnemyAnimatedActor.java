package com.azya.actors;

import com.azya.AnimationUtils;
import com.azya.MyInputListener;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class EnemyAnimatedActor extends AnimatedActor {
	@Override
	public Animation<TextureAtlas.AtlasRegion> setAnimation(TextureAtlas textureAtlas) {
		return AnimationUtils.getAnimationFromSpriteSheetTexture(textureAtlas);
	}

	public EnemyAnimatedActor(TextureModel textureModel) {
		super(textureModel);
		addListener(new MyInputListener());
	}
	@Override
	public void draw(Batch batch, float parentAlpha) {
		if(!currentFrame.isFlipX()){
			currentFrame.flip(true,false);
		}
		batch.draw(currentFrame, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(),
				getScaleX(), getScaleY(), getRotation());
		if(currentFrame.isFlipX()){
			currentFrame.flip(true,false);
		}
	}
}
