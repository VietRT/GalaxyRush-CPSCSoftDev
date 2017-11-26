package com.ryant.game.sprites;

import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
/**
 * Created by Ryan.T on 11/2/17.
 */

public class Astronaut {
    private Vector3 position;
    private Vector3 velocity;
    public final static int Astro_WIDTH = 36;
    public final static int Astro_HEIGHT = 49;
    private Rectangle bounds;

    private Texture Astronaut;
    private static final int gravity = -5;
    private static final int movement = 100;


    public Astronaut(int x, int y) {
        position = new Vector3(x, y, 0);
        velocity = new Vector3(0, 0 ,0);
        Astronaut = new Texture("gameAstronaut4.png");
        bounds = new Rectangle(x, y, Astro_WIDTH, Astro_HEIGHT);
    }

    public void update(float dt) {
        if(position.y > 0) {
            velocity.add(0, gravity, 0);
        }
        velocity.add(0, gravity, 0);
        velocity.scl(dt);
        //position.add(0, velocity.y, 0);
        position.add(movement * dt, velocity.y, 0);
        bounds.setPosition(position.x, position.y);
        //reverses what we scaled previously.
        velocity.scl(1/dt);

    }

    public Vector3 getPosition() {

        return position;
    }

    public Vector3 getVelocity() {

        return velocity;
    }

    public Texture getTexture() {

        return Astronaut;
    }

    public void jump() {

        velocity.y = 300;
    }

    public Rectangle getBounds() {

        return bounds;
    }
}
