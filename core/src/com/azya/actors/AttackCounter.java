package com.azya.actors;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class AttackCounter extends Actor {
	private int damage;
	private BitmapFont font;

	public AttackCounter(int damage,BitmapFont font) {
		this.font = font;
		font.setColor(1,1,1,1);
		this.damage = damage;
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		font.draw(batch, "HIT: " + damage + "!", getStage().getWidth()/2, getStage().getHeight()/2);
	}
}
