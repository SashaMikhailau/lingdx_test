package com.azya;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Stage;


public class Tutorials extends ApplicationAdapter
		 {

			 private Animation<TextureRegion> animation;
			 private SpriteBatch spriteBatch;
			 float stateTime;


	@Override
	public void create () {
		spriteBatch = new SpriteBatch();
		stateTime = 0;

	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stateTime += Gdx.graphics.getDeltaTime();
		TextureRegion currentFrame = animation.getKeyFrame(stateTime, true);
		spriteBatch.begin();
		spriteBatch.draw(currentFrame,50,50);
		spriteBatch.end();
	}

	@Override
	public void dispose () {
		spriteBatch.dispose();
	}
}
