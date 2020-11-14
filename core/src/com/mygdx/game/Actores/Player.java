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


        spritPlayer.setSize(16+24,16+24);

        BodyDef def= new BodyDef();
        def.position.set(spritPlayer.getWidth()/2,spritPlayer.getHeight()/2);
        def.type= BodyDef.BodyType.DynamicBody;
        body= world.createBody(def);


        PolygonShape playerShape= new PolygonShape();
        playerShape.setAsBox(5,5f);
        fixture= body.createFixture(playerShape,1);
        playerShape.dispose();



        //spritPlayer.setPosition(-spritPlayer.getWidth()/2, -spritPlayer.getHeight()/2);
        setSize(spritPlayer.getWidth()-24,spritPlayer.getHeight()-24);
        setPosition(spritPlayer.getX()+12,spritPlayer.getY()+12);

    }



    @Override
    public void draw(Batch batch, float parentAlpha) {

        spritPlayer.draw(batch);

    }

    @Override
    public void act(float delta) {
        super.act(delta);

        if(Gdx.input.isKeyPressed(Input.Keys.W)){
            setY(getY()+4);
            spritPlayer.setY(getY());
        }if(Gdx.input.isKeyPressed(Input.Keys.S)){
            setY(getY()-4);
            spritPlayer.setY(getY());
        }if(Gdx.input.isKeyPressed(Input.Keys.A)){
            setX(getX()-4);
            spritPlayer.setX(getX());
        }if(Gdx.input.isKeyPressed(Input.Keys.D)){
            setX(getX()+4);
            spritPlayer.setX(getX());
        }



    }
}
