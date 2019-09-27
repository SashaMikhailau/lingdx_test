package com.azya.screens;

import com.azya.stages.MainStage;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.StretchViewport;

public class MainScreen implements Screen {
	private Stage stage;
	private Skin uiSkin;
	public static final int VIEWPORT_WIDTH = 1000;
	public static final int VIEWPORT_HEIGHT = 700;


	public MainScreen() {
		stage = new MainStage(new StretchViewport(VIEWPORT_WIDTH, VIEWPORT_HEIGHT));
		uiSkin = new Skin(Gdx.files.internal("ui/uiskin.json"));
		final TextButton textButton = new TextButton("Attack", uiSkin, "default");
		textButton.addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent event, float x, float y) {
				textButton.setText("You clicked");
			}
		});
		textButton.setHeight(100);
		textButton.setWidth(100);
		textButton.setPosition(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
		stage.addActor(textButton);
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	public void render(float delta) {
		Gdx.gl.glClearColor(0.3f, 0.3f, 0.3f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(delta);
		stage.draw();
	}

	@Override
	public void show() {

	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void hide() {

	}

	@Override
	public void dispose() {
		stage.dispose();
	}
}
