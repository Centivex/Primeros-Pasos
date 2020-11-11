package com.mygdx.game.Actores;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Player extends Actor {

    Texture textPlayer= new Texture("Player/caminar_abajo_1.png");
    Sprite spritPlayer= new Sprite(textPlayer);

    World world;
    Body body;
    Fixture fixture;

    public Player(World world ){
        this.world=world;


       spritPlayer.setPosition(-spritPlayer.getWidth()/2, -spritPlayer.getHeight()/2);
       setSize(90, 90);
       setPosition(spritPlayer.getX(), spritPlayer.getY());
       setOrigin(0,0);

//-----------------------------------------------------------------------------------------
        BodyDef def= new BodyDef();
        def.position.set(0,0.5f);
        def.type= BodyDef.BodyType.DynamicBody;
        body= world.createBody(def);

        PolygonShape playerShape= new PolygonShape();
        playerShape.setAsBox(0.5f,0.5f);
        fixture= body.createFixture(playerShape,3);
        playerShape.dispose();

    }



    @Override
    public void draw(Batch batch, float parentAlpha) {

        spritPlayer.draw(batch);

    }

    @Override
    public void act(float delta) {
        super.act(delta);

        setPosition(body.getPosition().x*90,body.getPosition().y*90);

        if(Gdx.input.isKeyPressed(Input.Keys.W)){
            setX(getX()+10);
            spritPlayer.setX(getX());
        }



    }
}
