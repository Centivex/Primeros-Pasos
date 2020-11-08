package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public class Box2dScreen extends BaseScreen {

    private World world;

    public Box2dScreen(Game juego) {
        super(juego);
    }

    @Override
    public void show() {
        super.show();

        world= new World(new Vector2(0,0), true);
    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(0, 0, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        world.step(delta,6,2);
    }

    @Override
    public void dispose() {
        super.dispose();
        world.dispose();
    }
}
