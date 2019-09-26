package com.azya.actors;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Background extends Actor {
	private Texture texture;
	public Background(Texture texture) {
		this.texture = texture;
		setZIndex(0);
	}

	@Override
	public void draw(Batch batch, float parentAlpha) {
		batch.draw(texture,0,0,getStage().getWidth(),getStage().getWidth());
	}
}
