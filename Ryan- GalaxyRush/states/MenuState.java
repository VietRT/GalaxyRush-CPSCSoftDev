package com.ryant.game.states;

import com.badlogic.gdx.Gdx;
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
import com.ryant.game.scrollDemo;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.*;


/**
 * Created by Ryan.T on 11/1/17.
 */

public class MenuState extends State {

    private Texture bg;
    private Image Background;
    private Stage stage;
    Texture playbuttontext;
    TextureRegion textureRegion;
    TextureRegionDrawable textureRegionDrawable;
    ImageButton playbutton;

    Texture optionbuttontext;
    TextureRegion optiontextureRegion;
    TextureRegionDrawable optiontextureRegionDrawable;
    ImageButton optionbutton;

    public MenuState(GameStateManager gsm) {

        super(gsm);
        bg = new Texture("spaceMenuBackground.gif");
        Background = new Image(bg);
        Background.setSize(scrollDemo.WIDTH, scrollDemo.HEIGHT);
        //PlayBtn = new Texture("bluePlayButton.png");

        playbuttontext = new Texture(Gdx.files.internal("bluePlayButton.png"));
        textureRegion = new TextureRegion(playbuttontext);
        //textureRegion.setRegion(scrollDemo.WIDTH/2, scrollDemo.HEIGHT/2, 100, 50);
        textureRegionDrawable = new TextureRegionDrawable(textureRegion);
        playbutton = new ImageButton(textureRegionDrawable);
        playbutton.setPosition(scrollDemo.WIDTH/ 5, scrollDemo.HEIGHT/2);
        stage = new Stage(new ScreenViewport());
        optionbuttontext = new Texture(Gdx.files.internal("Options.png"));
        optiontextureRegion = new TextureRegion(optionbuttontext);
        optiontextureRegionDrawable = new TextureRegionDrawable(optiontextureRegion);
        optionbutton = new ImageButton(optiontextureRegionDrawable);
        optionbutton.setSize(50, 50);
        optionbutton.setPosition(0, 0);
        Gdx.input.setInputProcessor(stage);
        stage.addActor(Background);
        stage.addActor(optionbutton);
        stage.addActor(playbutton);


    }

    @Override
    public void handleInput() {
        if (playbutton.isPressed()) {
            gsm.set(new PlayState(gsm));
            dispose();


        }
        if(optionbutton.isPressed()) {
            gsm.set(new menuOptionsState(gsm));
            dispose();
        }
    }



    @Override
    public void update(float dt) {
        handleInput();

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        //sb.draw(Background, 0,0, scrollDemo.WIDTH, scrollDemo.HEIGHT);
        //we're taking it in half, but that would draw it on the right half.
        //So we subtract the length of the play button in half so its fully centered.
        //sb.draw(PlayBtn, scrollDemo.WIDTH/2, scrollDemo.HEIGHT/2);
        stage.act();
        stage.draw();

        sb.end();

    }

    @Override
    public void dispose() {
        playbuttontext.dispose();
    }
}
