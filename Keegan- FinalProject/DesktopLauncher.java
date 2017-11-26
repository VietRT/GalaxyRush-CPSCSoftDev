package com.mygdx.game.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.mygdx.game.GameSD;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = GameSD.WIDTH;
		config.height = GameSD.HEIGHT;
		config.title = GameSD.TITLE;
		new LwjglApplication(new GameSD(), config);
	}
}
