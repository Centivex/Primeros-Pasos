package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Jarron extends Actor {

    Texture textJarron= new Texture("Player/jarron.png");
    Sprite spritJarron= new Sprite(textJarron);

    public Jarron(){

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        spritJarron.draw(batch);
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        //mirar si esto es importante :
			/*for(Iterator<Action> iter = this.getActions().iterator(); iter.hasNext();){
				iter.next().act(delta);
			}*/

        spritJarron.setPosition(this.getX(),getY());
        spritJarron.setRotation(this.getRotation());
        spritJarron.setScale(this.getScaleX(),getScaleY());


    }
}
