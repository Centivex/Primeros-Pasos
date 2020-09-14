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
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.badlogic.gdx.utils.Timer;


public class Game extends ApplicationAdapter {
	//SpriteBatch batch;
	//private OrthographicCamera cam;

	public  class MyActor extends Actor{

		Texture textPlayer= new Texture("Player/caminar_abajo_1.png");

		Sprite spritPlayer= new Sprite(textPlayer);



		public MyActor(){
			//necesario para cliclar encima de el (o colisiones???)
			setBounds(0,0,textPlayer.getWidth(),textPlayer.getHeight());

		}



		@Override
		public void draw(Batch batch, float parentAlpha) {
			spritPlayer.setPosition(this.getX(),getY());
			spritPlayer.draw(batch);

		}

		/*@Override
		public void act(float delta) {


		}*/
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

		//le marcamos las acciones y la duracion de estas
		MoveToAction moveAction = new MoveToAction();
		moveAction.setPosition(300f, 0f);
		moveAction.setDuration(10f);
		myActor.addAction(moveAction);

		stage.addActor(myActor);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();

//-----------------------------------------------------------------------------------------------------------------------
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