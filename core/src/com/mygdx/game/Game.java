package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;


public class Game extends ApplicationAdapter implements InputProcessor {
	SpriteBatch batch;

	private Texture textPlayer;
	private Sprite spritPlayer;
	private float posx, posy;




	//public static void main (String[] args) throws Exception {
	//	TexturePacker.process("C:\\Users\\abran\\Desktop\\pruebafusion", "C:\\Users\\abran\\Desktop\\pruebafusion\\fusion", "movimiento");
	//}

	@Override
	public void create () {
		batch = new SpriteBatch();
		float w = Gdx.graphics.getWidth();
		float h = Gdx.graphics.getHeight();



		textPlayer= new Texture("Player/caminar_abajo_1.png");
		spritPlayer= new Sprite(textPlayer);

		posx= w/2 -spritPlayer.getWidth()/2;
		posy=h/2 - spritPlayer.getHeight()/2;

		spritPlayer.setPosition(posx, posy);


		Gdx.input.setInputProcessor(this);

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		//teclado

//		if(Gdx.input.isKeyJustPressed(Input.Keys.LEFT)){
//			if(Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT))
//				spritPlayer.translateX(-1f);
//			else
//				spritPlayer.translateX(-10.0f);
//		}
//		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
//			if(Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT))
//				spritPlayer.translateX(1f);
//			else
//				spritPlayer.translateX(10.0f);
//		}

		//--------------------------------------------------------------------------------------------------------------
		//raton

//		if(Gdx.input.isButtonPressed(Input.Buttons.LEFT)){
//			spritPlayer.setPosition(Gdx.input.getX() - spritPlayer.getWidth()/2,
//					Gdx.graphics.getHeight() - Gdx.input.getY() - spritPlayer.getHeight()/2);
//		}
//		if(Gdx.input.isButtonPressed(Input.Buttons.RIGHT)){
//			spritPlayer.setPosition(Gdx.graphics.getWidth()/2 -spritPlayer.getWidth()/2,
//					Gdx.graphics.getHeight()/2 - spritPlayer.getHeight()/2);
//		}


		batch.begin();
		spritPlayer.setPosition(posx,posy);
		spritPlayer.draw(batch);

		batch.end();
	}




	@Override
	public void dispose () {
		batch.dispose();
		textPlayer.dispose();

	}

	//------------------------------------------------------------------------------------------------------------------

	//cosas del InputProcessor

	@Override
	public boolean keyDown(int keycode) {
		float moveAmount = 1.0f;
		if(Gdx.input.isKeyPressed(Input.Keys.CONTROL_LEFT))
			moveAmount = 10.0f;

		if(keycode == Input.Keys.LEFT)
			posx-=moveAmount;
		if(keycode == Input.Keys.RIGHT)
			posx+=moveAmount;
		return true;
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
		if(button == Input.Buttons.LEFT){
			posx = screenX - spritPlayer.getWidth()/2;
			posy = Gdx.graphics.getHeight() - screenY - spritPlayer.getHeight()/2;
		}
		if(button == Input.Buttons.RIGHT){
			posx = Gdx.graphics.getWidth()/2 - spritPlayer.getWidth()/2;
			posy = Gdx.graphics.getHeight()/2 - spritPlayer.getHeight()/2;
		}
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