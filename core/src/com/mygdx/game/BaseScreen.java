package com.mygdx.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class BaseScreen implements Screen {
    private  Game juego;
    public SpriteBatch bacth;

    public BaseScreen(Game juego){
        this.juego=juego;
        bacth=new SpriteBatch();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        bacth.dispose();
    }
}
