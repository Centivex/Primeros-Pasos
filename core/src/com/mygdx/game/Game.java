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
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.scenes.scene2d.*;
import com.badlogic.gdx.scenes.scene2d.actions.*;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;
import com.badlogic.gdx.utils.Timer;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;


public class Game extends ApplicationAdapter {

	private OrthographicCamera cam;
	private TiledMap tiledMap;
	private TiledMapRenderer tiledMapRenderer;

	//private Stage stage;


	/*public static void main (String[] args) throws Exception {
		TexturePacker.process("C:\\Users\\abran\\Desktop\\pruebafusion", "C:\\Users\\abran\\Desktop\\pruebafusion\\fusion", "llevar");
	}*/

	@Override
	public void create () {

		//float w = Gdx.graphics.getWidth();
		//float h = Gdx.graphics.getHeight();
		cam = new OrthographicCamera();
		cam.setToOrtho(false,256,256);
		cam.update();

		tiledMap= new TmxMapLoader().load("Mapa/Prado.tmx");
		tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap);




	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
			cam.translate(-16,0);
		}else if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)){
			cam.translate(16,0);
		}else if(Gdx.input.isKeyPressed(Input.Keys.UP)){
			cam.translate(0,16);
		}else if(Gdx.input.isKeyPressed(Input.Keys.DOWN)){
			cam.translate(0,-16);
		}

		cam.update();
		tiledMapRenderer.setView(cam);
		tiledMapRenderer.render();

	}




	@Override
	public void dispose () {

	}

}