package com.mygdx.game.states;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.GameSD;
import com.mygdx.game.states.State;
import com.mygdx.game.states.GameStateManager;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.*;

/**
 * Created by KMallaney on 12/5/17.
 */

public class menuOptionsState extends State {

    private Texture bg;
    private Image background;
    private Stage stage;
    private Texture char1button,char2button;
    Texture char1buttonText,char2buttonText;
    ImageButton char1but,char2but;
    TextureRegion textureregion,textureregion2;
    TextureRegionDrawable textureRegionDrawable;
    //private Texture

    public menuOptionsState(GameStateManager gsm){
        super(gsm);
        bg = new Texture("MenuBG.png");
        background = new Image(bg);
        background.setSize(GameSD.WIDTH,GameSD.HEIGHT);
        char1button = new Texture("PixelAstronaut.png");
        char2button = new Texture("");
        char1buttonText = new Texture(Gdx.files.internal("PixelAstronaut.png"));
        char2buttonText = new Texture(Gdx.files.internal(""));
        textureregion = new TextureRegion(char1buttonText);
        textureregion2 = new TextureRegion();
        textureRegionDrawable = new TextureRegionDrawable(textureregion);
        char1but = new ImageButton(textureRegionDrawable);
        char2but = new ImageButton(textureRegionDrawable);
        char1but.setPosition(GameSD.WIDTH/2, GameSD.HEIGHT/2);
        char2but.setPosition(GameSD.WIDTH/4,GameSD.HEIGHT/2);
        Gdx.input.setInputProcessor(stage);

    }





    @Override
    public void handleInput()
    {

    }
    @Override
    public void update(float dt)
    {
        handleInput();
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        stage.act();
        stage.draw();
        sb.end();
    }
    @Override
    public void dispose()
    {
        char1button.dispose();
        char2button.dispose();
    }



}
