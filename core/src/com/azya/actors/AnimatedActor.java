package com.azya.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public abstract class AnimatedActor extends Actor {
	private volatile State state = State.PASSIVE;
	private final Animation<TextureAtlas.AtlasRegion> crouchAnimation;
	private Animation<TextureAtlas.AtlasRegion> attackAnimation;
	private Animation<TextureAtlas.AtlasRegion> walkAnimation;
	private Animation<TextureAtlas.AtlasRegion> currentAnimation;
	private float currentAnimationTime = (float) Math.random() * 10;
	protected TextureAtlas.AtlasRegion currentFrame;
	public AnimatedActor(TextureModel textureModel) {
		crouchAnimation = setAnimation(textureModel.getCrouchSpreadSheet());
		walkAnimation = setAnimation(textureModel.getWalkSpreadSheet());
		attackAnimation = setAnimation(textureModel.getAttackSpreadSheet());
		currentAnimation = crouchAnimation;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
		if(State.PASSIVE==state){
			setZIndex(1);
		} else {
			setZIndex(10);
		}
	}

	public abstract Animation<TextureAtlas.AtlasRegion> setAnimation(TextureAtlas spriteSheet);
	@Override
	public void act(float delta) {
		super.act(delta);
		currentAnimationTime += delta;
		currentFrame = currentAnimation.getKeyFrame(currentAnimationTime, true);
		setBounds(getX(), getY(), currentFrame.getRegionWidth(),
				currentFrame.getRegionHeight());
	}





	public void attack(AnimatedActor target) {
		if (getState() != State.PASSIVE) {
			return;
		}
		addAction(Actions.sequence(
				createStateAction(State.ACTING),
				createAnimationAction(walkAnimation),
				Actions.moveTo(target.getX() - getWidth(), target.getY(), 1),
				createAnimationAction(attackAnimation),
				Actions.delay(attackAnimation.getAnimationDuration())
				, createAnimationAction(walkAnimation)
				, Actions.moveTo(getX(), getY(), 1),
				createAnimationAction(crouchAnimation),
				createStateAction(State.PASSIVE)
		));
	}

	private Action createAnimationAction(final Animation animation) {
		return Actions.run(new Runnable() {
			@Override
			public void run() {
				currentAnimationTime = 0;
				currentAnimation = animation;
			}
		});
	}

	private Action createStateAction(final State state) {
		return Actions.run(new Runnable() {
			@Override
			public void run() {
				setState(state);
			}
		});
	}


}
