package com.mygdx.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import java.util.Random;

/**
 * Created by KMallaney on 11/1/17.
 */

public class Asteroid {
    private Texture topAsteroid, botAsteroid;
    private Vector2 posTopAster, posBotUFO;
    private Random rand;
    private static final int astGap = 85;
    private static final int LOWEST_OPENING = 120;
    private static final int FLUCTUATION = 130;

    public Asteroid(float x)
    {
        topAsteroid = new Texture("Asteroid.png");
        botAsteroid = new Texture("Asteroid.png");
        rand = new Random();
        posTopAster = new Vector2(x,rand.nextInt(FLUCTUATION) + astGap + LOWEST_OPENING);
        posBotUFO = new Vector2(x, posTopAster.y - astGap - botAsteroid.getHeight());
    }

    public Texture getTopAsteroid() {
        return topAsteroid;
    }

    public Texture getBotAsteroid() {
        return botAsteroid;
    }

    public Vector2 getPosTopAster() {
        return posTopAster;
    }

    public Vector2 getPosBotUFO() {
        return posBotUFO;
    }

    public void reposition(int x)
    {
        posTopAster.set( posTopAster = new Vector2(x,rand.nextInt(FLUCTUATION) + astGap + LOWEST_OPENING));
        posBotUFO.set(posBotUFO = new Vector2(x, posTopAster.y - astGap - botAsteroid.getHeight()));
    }
}
