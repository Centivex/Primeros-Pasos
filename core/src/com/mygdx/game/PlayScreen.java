package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

public class PlayScreen implements Screen {
    private Game juego;

    private OrthographicCamera cam;

    Texture textPlayer;
    Sprite spritPlayer;

    World world;
    Body body;

    //private Stage stage;
    //private TiledMap tiledMap;
    //private TiledMapRenderer tiledMapRenderer;

    public PlayScreen(Game juego){
        this.juego=juego;

        /*cam = new OrthographicCamera();
		cam.setToOrtho(false,256,256);
		cam.update();*/

		/*tiledMap= new TmxMapLoader().load("Mapa/Prado.tmx");
		tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);*/

        textPlayer= new Texture("Player/caminar_abajo_1.png");
        spritPlayer= new Sprite(textPlayer);
        spritPlayer.setPosition(Gdx.graphics.getWidth() / 2 - spritPlayer.getWidth() / 2,
                Gdx.graphics.getHeight() / 2);


        world = new World(new Vector2(0, -98f), true);

        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(spritPlayer.getX(), spritPlayer.getY());

        body = world.createBody(bodyDef);
        PolygonShape shape = new PolygonShape();
        shape.setAsBox(spritPlayer.getWidth()/2, spritPlayer.getHeight()/2);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = shape;
        fixtureDef.density = 1f;
        Fixture fixture = body.createFixture(fixtureDef);
        shape.dispose();
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


		/*if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
			cam.translate(-16,0);
		}else if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
			cam.translate(16,0);
		}else if(Gdx.input.isKeyPressed(Input.Keys.UP)){
			cam.translate(0,16);
		}else if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
			cam.translate(0,-16);
		}

		cam.update();*/
	/*	tiledMapRenderer.setView(cam);
		tiledMapRenderer.render();*/

        world.step(Gdx.graphics.getDeltaTime(), 6, 2);
        spritPlayer.setPosition(body.getPosition().x, body.getPosition().y);


        //bacth.setProjectionMatrix(cam.combined);
        juego.bacth.begin();
        spritPlayer.draw(juego.bacth);
        juego.bacth.end();
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        textPlayer.dispose();
        world.dispose();

    }
}
