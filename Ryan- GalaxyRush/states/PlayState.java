package com.ryant.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFontCache;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.ryant.game.scrollDemo;
import com.ryant.game.sprites.Asteroid;
import com.ryant.game.sprites.Astronaut;
import com.badlogic.gdx.utils.Array;

/**
 * Created by Ryan.T on 11/2/17.
 */

public class PlayState extends State {
    private static final int asteroidSpace = 125;
    private static final int asteroidCount = 2;

    private Astronaut Astronaut;
    private Texture Background;

    private Array<Asteroid> asteroids;

    private int scoreCount;
    private String yourScore;
    BitmapFont yourBitmap;



    public PlayState(GameStateManager gsm) {
        super(gsm);
        Astronaut = new Astronaut(25,500);
        //sets the camera to view a partial area of our game world.
        cam.setToOrtho(false, scrollDemo.WIDTH, scrollDemo.HEIGHT);
        Background = new Texture("spaceGameBackGround2.png");

        asteroids = new Array<Asteroid>();

        for(int i = 1; i <= asteroidCount; i++){
            asteroids.add(new Asteroid(i *(asteroidSpace + Asteroid.Asteroid_WIDTH)));

        }
        scoreCount = 0;
        yourScore = "score: 0";
        yourBitmap = new BitmapFont();


    }

    @Override
    public void handleInput() {
        if(Gdx.input.justTouched()) {
            Astronaut.jump();
        }

    }

    @Override
    public void update(float dt) {
    handleInput();

    Astronaut.update(Gdx.graphics.getDeltaTime());
    cam.position.x = Astronaut.getPosition().x + 80;

    for(Asteroid asteroid: asteroids) {
       if(cam.position.x - (cam.viewportWidth / 2) > asteroid.getPosAsteroid().x + asteroid.getAsteroid().getWidth()) {
           asteroid.reposition(asteroid.getPosAsteroid().x + ((Asteroid.Asteroid_WIDTH + asteroidSpace) * asteroidCount));
       }

            if(asteroid.collides(Astronaut.getBounds()) || Astronaut.getPosition().y < 0 || Astronaut.getPosition().y > 750)
            gsm.set(new PlayState(gsm));
    }

        cam.update();



        for(Asteroid asteroid: asteroids) {
                asteroid.update(Gdx.graphics.getDeltaTime());
        }



    }

    @Override
    public void render(SpriteBatch sb) {
        //basically sets it so the camera wont draw anything out of view.
        sb.setProjectionMatrix(cam.combined);
        sb.begin();
        sb.draw(Background, cam.position.x - (cam.viewportWidth), 0);
        sb.draw(Astronaut.getTexture(), Astronaut.getPosition().x, Astronaut.getPosition().y);

        for(Asteroid asteroid: asteroids) {
            sb.draw(asteroid.getAsteroid(), asteroid.getPosAsteroid().x, asteroid.getPosAsteroid().y);
        }
        for(Asteroid asteroid: asteroids) {
            if(!asteroid.collides(Astronaut.getBounds())) {
                scoreCount++;
                yourScore = "score: " + scoreCount;
            }
        }
        yourBitmap.setColor(1.0f, 1.0f, 1.0f, 1.0f);
        yourBitmap.getData().setScale(1.5f);
        yourBitmap.draw(sb, yourScore, cam.position.x + 95, cam.position.y + 380);

        sb.end();


    }

    @Override
    public void dispose() {
        for(Asteroid asteroid: asteroids) {
            if(asteroid.getPosAsteroid().y  < 0 || asteroid.getPosAsteroid().x < 0) {
                dispose();
            }
        }


    }
}
