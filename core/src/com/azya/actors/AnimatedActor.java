package com.azya.actors;

import com.azya.battlestage.BattlePosition;
import com.azya.battlestage.BattlePositionResolver;
import com.azya.rolesystem.Attack;
import com.azya.stages.MainStage;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;

public abstract class AnimatedActor extends Actor {
	private volatile State state = State.PASSIVE;
	private final Animation<TextureAtlas.AtlasRegion> crouchAnimation;
	private Animation<TextureAtlas.AtlasRegion> attackAnimation;
	private Animation<TextureAtlas.AtlasRegion> walkAnimation;
	private Animation<TextureAtlas.AtlasRegion> hitAnimation;
	private Animation<TextureAtlas.AtlasRegion> currentAnimation;
	private BattlePosition battlePosition;
	private float currentAnimationTime = (float) Math.random() * 10;
	protected TextureAtlas.AtlasRegion currentFrame;
	public AnimatedActor(BattlePosition battlePosition,TextureModel textureModel) {
		this.battlePosition = battlePosition;
		new BattlePositionResolver().resolvePosition(this);
		crouchAnimation = setAnimation(textureModel.getCrouchSpriteSheet());
		walkAnimation = setAnimation(textureModel.getWalkSpriteSheet());
		attackAnimation = setAnimation(textureModel.getAttackSpriteSheet());
		hitAnimation = setAnimation(textureModel.getHitSpriteSheet());
		currentAnimation = crouchAnimation;
		setZIndex(1);
	}

	public State getState() {
		return state;
	}

	public BattlePosition getBattlePosition() {
		return battlePosition;
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





	public void attack(final AnimatedActor target) {
		if (getState() != State.PASSIVE) {
			return;
		}
		addAction(Actions.sequence(
				createStateAction(State.ACTING),
				createAnimationAction(walkAnimation),
				Actions.moveTo(target.getX() - getWidth(), target.getY(), 1),
				createAttackAction(target)
				, createAnimationAction(walkAnimation)
				, Actions.moveTo(getX(), getY(), 1),
				createAnimationAction(crouchAnimation),
				createStateAction(State.PASSIVE)
		));
	}

	private Action createAttackAction(final AnimatedActor target) {
		return Actions.sequence(createAnimationAction(attackAnimation),
				Actions.delay(attackAnimation.getAnimationDuration()/2)
				,Actions.run(new Runnable() {
					@Override
					public void run() {
						target.hitted(new Attack(10));
					}
				}),
				Actions.delay(attackAnimation.getAnimationDuration()/2));
	}

	public void hitted(final Attack attack){
		addAction(Actions.sequence(
				createStateAction(State.ACTING),
				createAnimationAction(hitAnimation)
				,Actions.run(new Runnable() {
					@Override
					public void run() {
						((MainStage) getStage()).poputHit(attack);
					}
				}),
				Actions.delay(hitAnimation.getAnimationDuration()),
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
