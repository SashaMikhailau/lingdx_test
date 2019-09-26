package com.azya.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public abstract class AnimatedActor extends Actor {
	private final Animation<TextureRegion> crouchAnimation;
	private volatile State state = State.PASSIVE;
	private Animation<TextureRegion> attackAnimation;
	private Animation<TextureRegion> walkAnimation;
	private Animation<TextureRegion> currentAnimation;
	private float currentAnimationTime = (float) Math.random() * 10;
	private TextureRegion currentFrame;
	public AnimatedActor(TextureModel textureModel) {
		crouchAnimation = setAnimation(textureModel.getCrouchSpreadSheet(),6,2,8);
		walkAnimation = setAnimation(textureModel.getWalkSpreadSheet(),6,4,24);
		attackAnimation = setAnimation(textureModel.getAttackSpreadSheet(),6,4,20);
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

	public abstract Animation<TextureRegion> setAnimation(Texture spriteSheet,int colCOunt,
														  int rowCount,int frameCount);

	@Override
	public void act(float delta) {
		super.act(delta);
		currentAnimationTime += delta;
		currentFrame = currentAnimation.getKeyFrame(currentAnimationTime, true);
		setBounds(getX(), getY(), currentFrame.getRegionWidth(),
				currentFrame.getRegionHeight());
	}



	@Override
	public void draw(Batch batch, float parentAlpha) {
		batch.draw(currentFrame, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(),
				getScaleX(), getScaleY(), getRotation());
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
