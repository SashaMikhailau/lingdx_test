package com.azya.actors;

import com.azya.AnimationUtils;
import com.azya.battlestage.BattlePosition;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;

public class FriendAnimatedActor extends AnimatedActor {

	@Override
	public Animation<TextureAtlas.AtlasRegion> setAnimation(TextureAtlas textureAtlas) {
		return AnimationUtils.getAnimationFromSpriteSheetTexture(textureAtlas);
	}

	public FriendAnimatedActor(BattlePosition battlePosition,TextureModel textureModel) {
		super(battlePosition,textureModel);
	}
	@Override
	public void draw(Batch batch, float parentAlpha) {
		batch.draw(currentFrame, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(),
				getScaleX(), getScaleY(), getRotation());
	}
}
