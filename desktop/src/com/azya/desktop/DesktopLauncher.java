package com.azya.desktop;

import com.azya.Tutorials;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "graphicsdemo";
		config.width = 900;
		config.height = 700;
		new LwjglApplication(new Tutorials(), config);
	}
}
