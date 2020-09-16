package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Player extends Actor {

    Texture textPlayer= new Texture("Player/caminar_abajo_1.png");
    Sprite spritPlayer= new Sprite(textPlayer);

    public Player(){
        //necesario para cliclar encima de el (o colisiones???)
       // setBounds(spritPlayer.getX(),spritPlayer.getY(),spritPlayer.getWidth(),spritPlayer.getHeight());

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        spritPlayer.draw(batch);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        //mirar si esto es importante :
			/*for(Iterator<Action> iter = this.getActions().iterator(); iter.hasNext();){
				iter.next().act(delta);
			}*/

        spritPlayer.setPosition(this.getX(),getY());
        spritPlayer.setRotation(this.getRotation());
        spritPlayer.setScale(this.getScaleX(),getScaleY());


    }
}
