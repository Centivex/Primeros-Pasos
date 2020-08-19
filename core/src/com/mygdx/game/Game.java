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
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.badlogic.gdx.utils.Timer;


public class Game extends ApplicationAdapter {
	SpriteBatch batch;

	//private Sound sonido;
	//para guardar algo que tenga grandes datos
	//private long idSonidoContinua;

	private Music musica;

	private OrthographicCamera cam;





	//public static void main (String[] args) throws Exception {
	//	TexturePacker.process("C:\\Users\\abran\\Desktop\\pruebafusion", "C:\\Users\\abran\\Desktop\\pruebafusion\\fusion", "movimiento");
	//}

	@Override
	public void create () {
		batch = new SpriteBatch();

		cam= new OrthographicCamera(1280,720);

		//sonido= Gdx.audio.newSound(Gdx.files.internal("sonido/cancion.mp3"));
		musica=Gdx.audio.newMusic(Gdx.files.internal("sonido/cancion.mp3"));

		//play
		//sonido.play();

		//play controlando el sonido
		//sonido.play(0.5f);


		//en loop cada 5 segundos

		//no sólo puedes meter el loop en long, tambien puedes meter un play,etc
//		idSonidoContinua = sonido.loop();
//		Timer.schedule(new Timer.Task(){
//			@Override
//			public void run(){
//				sonido.stop(idSonidoContinua);
//			}
//		}, 5.0f);

		//cambiar el volumen con id
		//sonido.setPitch(idSonidoContinua,0.5f);

		//cambiar el volumen y tenerlo en estereo (primer valor oido derecho , segundo el izquierdo)
		//sonido.setPan(idSonidoContinua, 1,1);
//-------------------------------------------------------------------------------------------------------------------------
		//musica

		musica.play();

		musica.setVolume(1.0f);
		musica.pause();
		musica.stop();
		musica.play();
		//te devuelve en que segundo está la cancion
		Gdx.app.log("SONG",Float.toString(musica.getPosition()));

	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.setProjectionMatrix(cam.combined);



		cam.update();
		batch.begin();
		batch.end();
	}




	@Override
	public void dispose () {
		batch.dispose();
		//sonido.dispose();
		musica.dispose();
	}

}