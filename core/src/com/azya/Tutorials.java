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
			 public static final int FRAME_COLS = 6;
			 public static final int FRAME_ROWS = 2;
			 private Texture crouchSkeleton;
			 private Animation<TextureRegion> animation;
			 private SpriteBatch spriteBatch;
			 float stateTime;


	@Override
	public void create () {
		crouchSkeleton = new Texture(Gdx.files.internal("skeleton/SPRITE_SHEETS" +
				"/FW_Skeleton_Crouching.png"));
		TextureRegion[][] split = TextureRegion.split(crouchSkeleton, crouchSkeleton.getWidth() / FRAME_COLS,
				crouchSkeleton.getHeight() / FRAME_ROWS);
		TextureRegion[] textureRegions = new TextureRegion[8];
		int index = 0;
		for (int i = 0; i < split.length; i++) {
			for (int j = 0; j < split[i].length; j++) {
				textureRegions[index++] = split[i][j];
				if(index==8)break;
			}
		}
		animation = new Animation<TextureRegion>(0.08f, textureRegions);
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
		crouchSkeleton.dispose();
	}
}
