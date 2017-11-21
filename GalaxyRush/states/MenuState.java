package com.ryant.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.ryant.game.scrollDemo;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

/**
 * Created by Ryan.T on 11/1/17.
 */

public class MenuState extends State {

    private Texture Background;
    private Texture PlayBtn;
    /*
    TextButton startButton;
    TextButton.TextButtonStyle startStyle;
    BitmapFont font;
    Skin startSkin;
    TextureAtlas startAtlas;

    public void create() {
        font = new BitmapFont();
        startSkin = new Skin();
        startAtlas = new TextureAtlas(Gdx.files.internal("buttons/buttons.pack"));
        startSkin.addRegions(startAtlas);
        startStyle = new TextButton.TextButtonStyle();
        startStyle.font = font;
        startButton = new TextButton("Start", startStyle);
    }
    */

    public MenuState(GameStateManager gsm) {

        super(gsm);
        Background = new Texture("spaceMenuBackground.gif");
        PlayBtn = new Texture("bluePlayButton.png");
    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()) {
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
        sb.draw(Background, 0,0, scrollDemo.WIDTH, scrollDemo.HEIGHT);
        //we're taking it in half, but that would draw it on the right half.
        //So we subtract the length of the play button in half so its fully centered.
        sb.draw(PlayBtn,(scrollDemo.WIDTH / 2) - PlayBtn.getWidth() / 2, scrollDemo.HEIGHT / 2);

        sb.end();

    }

    @Override
    public void dispose() {
        Background.dispose();
        PlayBtn.dispose();
    }
}
