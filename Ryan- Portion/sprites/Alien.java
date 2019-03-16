package com.ryant.game.sprites;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import java.util.Random;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * Created by Ryan.T on 11/6/17.
 */

public class Alien {

    private Texture Alien;
    private Vector2 alienPos;
    private static final int alien_WIDTH = 181;
    private static final int alien_HEIGHT = 122;
    private Texture Bullet;
    private Sprite bulletSprite;
    private Vector2 bulletPos;
    private Vector2 bulletVelocity;

    private static final int bulletSpeed = -250;

    public Alien(float  x, float y) {
        Alien = new Texture("spaceGameAlien.png");
        Bullet = new Texture("Bullet.jpg");
        bulletSprite = new Sprite(Bullet);
        bulletSprite.flip(true, false);
        alienPos = new Vector2(x, y);
        bulletPos = new Vector2(x, y);
        bulletVelocity = new Vector2(0,0);
    }

    public void update(float dt) {
        bulletVelocity.add(bulletSpeed, 0);
        bulletVelocity.scl(dt);

    }








}
