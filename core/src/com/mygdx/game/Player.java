package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Player extends Actor {

    Texture textPlayer= new Texture("Player/caminar_abajo_1.png");
    Sprite spritPlayer= new Sprite(textPlayer);



    public Player( ){

        //necesario para cliclar encima de el (o colisiones???)
       setBounds(this.getX(),this.getY(),spritPlayer.getWidth(),spritPlayer.getHeight());
       spritPlayer.setPosition(-spritPlayer.getWidth()/2, -spritPlayer.getHeight()/2);

       setSize(spritPlayer.getWidth(), spritPlayer.getHeight());
       setPosition(spritPlayer.getX(), spritPlayer.getY());
       setOrigin(0,0);
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



        if(Gdx.input.isKeyPressed(Input.Keys.W)){
            setX(getX()+10);
            spritPlayer.setX(getX());
        }



    }
}
