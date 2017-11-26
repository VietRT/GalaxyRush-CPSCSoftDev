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

    //background and ImageButton
    private Texture bg;
    private Image Background;
    private Stage stage;
    private Texture PlayBtn;
    Texture playbuttontext;
    TextureRegion textureRegion;
    TextureRegionDrawable textureRegionDrawable;
    ImageButton playbutton;


    public MenuState(GameStateManager gsm) {

        super(gsm);
        bg = new Texture("spaceMenuBackground.gif");
        Background = new Image(bg);
        Background.setSize(scrollDemo.WIDTH, scrollDemo.HEIGHT);
        PlayBtn = new Texture("bluePlayButton.png");

        playbuttontext = new Texture(Gdx.files.internal("bluePlayButton.png"));
        textureRegion = new TextureRegion(playbuttontext);
        //textureRegion.setRegion(scrollDemo.WIDTH/2, scrollDemo.HEIGHT/2, 100, 50);
        textureRegionDrawable = new TextureRegionDrawable(textureRegion);
        playbutton = new ImageButton(textureRegionDrawable);
        playbutton.setPosition(scrollDemo.WIDTH/ 5, scrollDemo.HEIGHT/2);
        stage = new Stage(new ScreenViewport());
        stage.addActor(Background);
        stage.addActor(playbutton);
        Gdx.input.setInputProcessor(stage);
        /*playbutton.addListener(new InputListener() {
            public void clicked(InputEvent event, float x, float y) {
                Gdx.app.log("start game", "pressed");

            }
        });*/

    }

    @Override
    public void handleInput() {
         if(playbutton.isPressed()) {
         gsm.set(new PlayState(gsm));
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
        PlayBtn.dispose();
    }
}
