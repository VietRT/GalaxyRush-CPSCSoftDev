package com.ryant.game.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;


import java.util.Stack;

/**
 * Created by Ryan.T on 11/1/17.
 */

    public class GameStateManager {
    Stack<State> States;

    public GameStateManager() {


        States = new Stack<State>();
    }

    public void push(State state) {

        States.push(state);

    }

    public void pop(State state) {

        States.pop();

    }

    public void set(State state) {

        States.pop();
        States.push(state);
    }
    public void update(float dt) {

        States.peek().update(dt);

    }

    public void render(SpriteBatch sb) {

        States.peek().render(sb);
    }

}
