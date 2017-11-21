package com.ryant.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import java.util.Random;
/**
 * Created by Ryan.T on 11/2/17.
 */

public class Asteroid {
    public static final int Asteroid_WIDTH = 165;
    public static final int Asteroid_HEIGHT = 150;
    //it can move up an down randomly between 0 and 130.
    private static final int fluctuation = 500;

    private int count;
    private Rectangle asteroidBound;

    private Texture Asteroid;
    private Vector2 posAsteroid;
    private Vector2 velocity;

    private Random rand;
    private static final int moveX = -15;
    private static final int moveY = -10;

    public Asteroid(float x) {
        //moveX = Math.Random()
        count = 0;
        Asteroid = new Texture("asteroid.png");
        rand = new Random();
        posAsteroid = new Vector2(x, rand.nextInt(fluctuation));
        velocity = new Vector2(0, 0);
        asteroidBound = new Rectangle(posAsteroid.x, posAsteroid.y, Asteroid_WIDTH, Asteroid_HEIGHT);

    }

    public void update(float dt) {
        count++;

        if(posAsteroid.y > 0) {
                velocity.add(moveX, moveY);
        }
        velocity.add(moveX, moveY);
        velocity.scl(dt);
        posAsteroid.add(moveX * dt, moveY * dt);
        asteroidBound.setX(posAsteroid.x);
        asteroidBound.setY(posAsteroid.y);
        if(posAsteroid.y < 0) {

        }
        velocity.scl(1/dt);

    }

    public Texture getAsteroid() {
     //returns asteroid
        return Asteroid;
    }

    public Vector2 getPosAsteroid() {
     //returns the position of the asteroid
        return posAsteroid;
    }

    public void reposition(float x) {

        posAsteroid.set(x, rand.nextInt(fluctuation));
        asteroidBound.setPosition(posAsteroid.x, posAsteroid.y);
    }

    public boolean collides(Rectangle player) {
     //if they overlap, its a collision
        //System.out.println(player.overlaps(asteroidBound));
        return player.overlaps(asteroidBound);
    }




}
