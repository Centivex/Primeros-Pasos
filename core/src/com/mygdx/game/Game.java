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
import com.badlogic.gdx.scenes.scene2d.actions.*;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.badlogic.gdx.utils.Timer;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;


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

			spritPlayer.draw(batch);

		}

		@Override
		public void act(float delta) {
			super.act(delta);
			//mirar si esto es importante :
			/*for(Iterator<Action> iter = this.getActions().iterator(); iter.hasNext();){
				iter.next().act(delta);
			}*/

			spritPlayer.setPosition(this.getX(),getY());
			spritPlayer.setRotation(this.getRotation());
			spritPlayer.setScale(this.getScaleX(),getScaleY());
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

		//si quieres hacer una secuencia:
		SequenceAction sequenceAction = new SequenceAction();

		//le marcamos las acciones y la duracion de estas
		MoveToAction moveAction = new MoveToAction();
		RotateToAction rotateAction = new RotateToAction();
		ScaleToAction scaleAction = new ScaleToAction();
		DelayAction delayAction= new DelayAction();

		moveAction.setPosition(300f, 0f);
		moveAction.setDuration(5f);
		rotateAction.setRotation(90f);
		rotateAction.setDuration(5f);
		scaleAction.setScale(0.5f);
		scaleAction.setDuration(5f);
		delayAction.setDuration(5f);


		/*myActor.addAction(moveAction);
		myActor.addAction(rotateAction);
		myActor.addAction(scaleAction);*/

		//si quieres secuencia
		sequenceAction.addAction(scaleAction);
		sequenceAction.addAction(delayAction);
		sequenceAction.addAction(rotateAction);
		sequenceAction.addAction(moveAction);

		myActor.addAction(sequenceAction);

		//en paralelo
		//myActor.addAction(parallel(scaleTo(0.5f,0.5f,5f),rotateTo(90.0f,5f),moveTo(300.0f,0f,5f)));

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