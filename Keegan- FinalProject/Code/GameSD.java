package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.states.GameStateManager;
import com.mygdx.game.states.MenuState;


public class GameSD extends ApplicationAdapter {
	public static final int WIDTH = 1000;
	public static final int HEIGHT = 1000;
	public static final String TITLE = "Galaxy Rush";

	private GameStateManager gsm;
	private SpriteBatch batch;


	//Button
	private Stage stage;
	private Label outputLabel;


	//End Button


	@Override
	public void create () {

		stage = new Stage(new ScreenViewport());
		Gdx.input.setInputProcessor(stage);

		int helpGuides = 12;
		int rowHeight = Gdx.graphics.getWidth()/12;
		int colWidth = Gdx.graphics.getWidth()/12;
		Skin mySkin = new Skin(Gdx.files.internal("skin/glass-ui.json"));

		Label title = new Label("Buttons with skins", mySkin, "big-black");
		title.setSize(Gdx.graphics.getWidth(), rowHeight*2);
		title.setPosition(0,Gdx.graphics.getHeight()-rowHeight*2);
		title.setAlignment(Align.center);
		stage.addActor(title);

		//Button stuff
		Button charSelectButton = new TextButton("Character Select", mySkin,"small");
		charSelectButton.setSize(colWidth*4, rowHeight);
		charSelectButton.setPosition(colWidth/7,Gdx.graphics.getHeight()-rowHeight*3);
		charSelectButton.addListener(new InputListener() {
			@Override
			public void touchUp (InputEvent event,float x, float y, int pointer, int button)
			{
				outputLabel.setText("Char Select");
			}
			@Override
			public boolean touchDown (InputEvent event,float x, float y, int pointer, int button)
			{
				outputLabel.setText("Preesed Down");
				return true;
			}

		});
		stage.addActor(charSelectButton);
		//End Button Stuff


		/*batch = new SpriteBatch();
		gsm = new GameStateManager();
		Gdx.gl.glClearColor(1, 0, 0, 1);
		gsm.push(new MenuState(gsm));
		*/
	}

	@Override
	public void render () {

		//Button Stuff
		Gdx.gl.glClearColor(1,1,1,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act();
		stage.draw();




		//End Button Stuff



		/*Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		gsm.update(Gdx.graphics.getDeltaTime()); //Difference in render times
		gsm.render(batch);
		*/
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
}
//test
