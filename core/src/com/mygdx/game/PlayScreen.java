package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.game.Actores.Camara;
import com.mygdx.game.Actores.MapaZelda;
import com.mygdx.game.Actores.Player;

public class PlayScreen extends BaseScreen {
    private Game juego;


    private Stage stage;
    private Player jugador1;
    private MapaZelda mapaZelda;
    public Camara cam;

    private World world;


    public PlayScreen(Game juego){
        super(juego);

        world= new World(new Vector2(0,0), true);


        cam=new Camara();
        jugador1=new Player(world);
        //mapaZelda=new MapaZelda(cam.cam);

        FitViewport viewp = new FitViewport(250, 250, cam.cam);
        viewp.setScreenPosition(100,100);

        stage= new Stage(viewp);
        //stage.setDebugAll(true);
        Gdx.input.setInputProcessor(stage);

        stage.addActor(cam);
        //stage.addActor(mapaZelda);
        stage.addActor(jugador1);



    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        world.step(delta,6,2);
        //mapaZelda.dibuja();
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();


    }

    @Override
    public void dispose() {
        stage.dispose();
        world.dispose();

    }
}
