package com.mygdx.game.states;
//Works
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.GameSD;
import com.mygdx.game.sprites.Astro;

/**
 * Created by KMallaney on 11/1/17.
 */

public class playState extends State {
    private Astro astro;
    private Texture bg;


    public playState(GameStateManager gsm) {
        super(gsm);
        astro = new Astro(10,300);
        cam.setToOrtho(false, GameSD.WIDTH/2,GameSD.HEIGHT/2);
        bg = new Texture("SpaceBGTEST1.png");
    }

    @Override
    protected void handleInput() {
        if(Gdx.input.justTouched())
        {
            astro.jump();
        }
    }

    @Override
    public void update(float dt) {
        handleInput();
        astro.update(dt);
    }

    @Override
    public void render(SpriteBatch sb) {
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(bg, cam.position.x - (cam.viewportWidth/2),0);
        sb.draw(astro.getTexture(),astro.getPosition().x,astro.getPosition().y);
        sb.end();
    }

    @Override
    public void dispose() {

    }
}
