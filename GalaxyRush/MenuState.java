//Adding a comment!

package com.mygdx.game.States;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.GameSD;

/**
 * Created by KMallaney on 10/27/17.
 */

public class MenuState extends State {
    private Texture background;
    private Texture playBtn;

    public MenuState(GameStateManager gsm) {
        super(gsm);
        background = new Texture("MenuBG.png");
        playBtn = new Texture("43-Play-button.png");
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch sb) {
        sb.begin();
        sb.draw(background, 0,0, GameSD.WIDTH, GameSD.HEIGHT);
        sb.draw(playBtn, (GameSD.WIDTH/2)-(playBtn.getWidth()/2),GameSD.HEIGHT/4);
        sb.end();
    }
}
