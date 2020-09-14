package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.backends.lwjgl.audio.Mp3;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.*;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.badlogic.gdx.utils.Timer;


public class Game extends ApplicationAdapter {
	//SpriteBatch batch;
	//private OrthographicCamera cam;

	public  class MyActor extends Actor{

		Texture textPlayer= new Texture("Player/caminar_abajo_1.png");

		Sprite spritPlayer= new Sprite(textPlayer);

		float actorx=0;

		public MyActor(){
			//necesario para cliclar encima de el
			//setBounds(actorx,0,textPlayer.getWidth(),textPlayer.getHeight());

			/*addListener(new InputListener(){
				public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
					((MyActor)event.getTarget()).started = true;
					return true;
				}
			});*/

		}



		@Override
		public void draw(Batch batch, float parentAlpha) {
			spritPlayer.draw(batch);
			//batch.draw(textPlayer,actorx,0);
		}

		@Override
		public void act(float delta) {

			if(Gdx.input.isKeyPressed(Input.Keys.A)){
				actorx=100;
				spritPlayer.translateX(actorx);
			}

		}
	}

	private Stage stage;




	//public static void main (String[] args) throws Exception {
	//	TexturePacker.process("C:\\Users\\abran\\Desktop\\pruebafusion", "C:\\Users\\abran\\Desktop\\pruebafusion\\fusion", "movimiento");
	//}

	@Override
	public void create () {
//		batch = new SpriteBatch();
//		cam= new OrthographicCamera(1280,720);

		stage= new Stage();


		//si metes el touch de arriba o haces los input por eventos o si despues quieres tener un interfaz y no choquen los botones
		Gdx.input.setInputProcessor(stage);

		MyActor myActor = new MyActor();
		//necesario por si clicla encima
		//myActor.setTouchable(Touchable.enabled);
		stage.addActor(myActor);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();


		//batch.setProjectionMatrix(cam.combined);

		//cam.update();
		//batch.begin();
		//batch.end();
	}




	@Override
	public void dispose () {
		//batch.dispose();
		stage.dispose();
	}

}