package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by KMallaney on 11/1/17.
 */

public class Astro
{
    private static final int GRAVITY = -10;
    private Vector3 position;
    private Vector3 vel;

    private Texture astro;

    public Astro(int x, int y)
    {
        position = new Vector3(x, y,0);
        vel = new Vector3(0,0,0);
        astro = new Texture("PixelAstronaut.png");
    }

    public Vector3 getPosition() {
        return position;
    }

    public Texture getTexture() {
        return astro;
    }

    public void update(float dt)
    {
        if(position.y > 0)
        {
            vel.add(0, GRAVITY, 0);
        }
        vel.scl(dt);
        position.add(0,vel.y,0);
        vel.scl(1/dt);
        if(position.y < 0)
        {
            position.y = 0;
        }
    }

    public void jump()
    {
        vel.y = 250;
    }

}
