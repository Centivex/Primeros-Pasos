package com.mygdx.game.Actores;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class Botones extends Actor {

    public TextButton button;

    public Botones(Skin skin){
        button = new TextButton("Click me", skin, "default");
        button.setWidth(200f);
        button.setHeight(20f);
        button.setPosition(Gdx.graphics.getWidth() /2 - 100f, Gdx.graphics.getHeight()/2 - 10f);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        button.draw(batch,parentAlpha);
    }

    @Override
    public void act(float delta) {
        super.act(delta);

        if(Gdx.input.isTouched()){
            button.setText("You clicked the button");
        }
    }
}
