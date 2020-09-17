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
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.badlogic.gdx.utils.Timer;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;


public class Game extends ApplicationAdapter {
	SpriteBatch batch;
	//private OrthographicCamera cam;
	private Stage stage;
	private Skin skin;

	/*public static void main (String[] args) throws Exception {
		TexturePacker.process("C:\\Users\\abran\\Desktop\\pruebafusion", "C:\\Users\\abran\\Desktop\\pruebafusion\\fusion", "llevar");
	}*/

	@Override
	public void create () {
		batch = new SpriteBatch();
//		cam= new OrthographicCamera(1280,720);
		stage= new Stage();
		skin =new Skin(Gdx.files.internal("data/uiskin.json"));

		Botones button= new Botones(skin);

		stage.addActor(button);


		//si metes el touch de arriba o haces los input por eventos o si despues quieres tener un interfaz y no choquen los botones
		Gdx.input.setInputProcessor(stage);
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