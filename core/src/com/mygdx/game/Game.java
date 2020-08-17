package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;


public class Game extends ApplicationAdapter implements InputProcessor {
	SpriteBatch batch;

	private OrthographicCamera cam;
	private Texture textFondo;
	private Sprite spritFondo;




	//public static void main (String[] args) throws Exception {
	//	TexturePacker.process("C:\\Users\\abran\\Desktop\\pruebafusion", "C:\\Users\\abran\\Desktop\\pruebafusion\\fusion", "movimiento");
	//}

	@Override
	public void create () {
		batch = new SpriteBatch();

		cam= new OrthographicCamera(1280,720);



		textFondo= new Texture("fondo.jpg");
		textFondo.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);



		spritFondo= new Sprite(textFondo);
		spritFondo.setOrigin(0,0);
		spritFondo.setPosition(-spritFondo.getWidth()/2,-spritFondo.getHeight()/2);


		Gdx.input.setInputProcessor(this);

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.setProjectionMatrix(cam.combined);

		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
			cam.translate(10,0);
		}else  if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
			cam.translate(-10,0);
		}


		cam.update();
		batch.begin();
		spritFondo.draw(batch);
		batch.end();
	}




	@Override
	public void dispose () {
		batch.dispose();
		textFondo.dispose();

	}

	//------------------------------------------------------------------------------------------------------------------

	//cosas del InputProcessor

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
}