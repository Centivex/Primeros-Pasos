package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Jarron extends Actor {

    Texture textJarron= new Texture("Player/jarron.png");
    Sprite spritJarron= new Sprite(textJarron);

    public Player player;

    public Jarron(Player player){
        setBounds(0,0,spritJarron.getWidth(),spritJarron.getHeight());
        this.player=player;
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


        spritJarron.setPosition(player.spritPlayer.getX()+player.spritPlayer.getWidth()-25,0);

    }
}
