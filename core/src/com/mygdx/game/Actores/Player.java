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


        spritPlayer.setRegion(13,10,14,23);
        spritPlayer.setSize((textPlayer.getWidth()-24)/100f,(textPlayer.getHeight()-24)/100f);

        BodyDef def= new BodyDef();
        def.position.set(spritPlayer.getWidth()/2,spritPlayer.getHeight()/2);
        def.type= BodyDef.BodyType.DynamicBody;
        body= world.createBody(def);


        PolygonShape playerShape= new PolygonShape();
        playerShape.setAsBox(5/100f,5/100f);
        fixture= body.createFixture(playerShape,1);
        playerShape.dispose();



        spritPlayer.setPosition(0, 0);
        setSize(spritPlayer.getWidth(),spritPlayer.getHeight());
        setPosition(spritPlayer.getX(),spritPlayer.getY());
    }



    @Override
    public void draw(Batch batch, float parentAlpha) {

        spritPlayer.draw(batch);

    }

    @Override
    public void act(float delta) {
        super.act(delta);


            if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                body.setLinearVelocity(-1, 0);

            }else if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            body.setLinearVelocity(1, 0);

            }else if (Gdx.input.isKeyPressed(Input.Keys.W)) {
                body.setLinearVelocity(0, 1);

            }else if (Gdx.input.isKeyPressed(Input.Keys.S)) {
                body.setLinearVelocity(0, -1);

            }
            else {
                body.setLinearVelocity(0, 0);
            }
            spritPlayer.setPosition(body.getPosition().x - 0.1f, body.getPosition().y - 0.1f);


    }
}
