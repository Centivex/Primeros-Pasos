package com.mygdx.game.Actores;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class Camara extends Actor {
    public OrthographicCamera cam;

    public Camara(){
        cam = new OrthographicCamera(256,256);
        //cam.setToOrtho(false,256,256);

    }
    @Override
    public void draw(Batch batch, float parentAlpha) {

        batch.setProjectionMatrix(cam.combined);
        cam.update();
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            cam.translate(-16,0);
        }else if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
            cam.translate(16,0);
        }else if(Gdx.input.isKeyPressed(Input.Keys.UP)){
            cam.translate(0,16);
        }else if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
            cam.translate(0,-16);
        }
    }
}
