package com.azya;

import com.azya.screens.MainScreen;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Tutorials extends Game {

	@Override
	public void create() {
		setScreen(new MainScreen());
	}


}
