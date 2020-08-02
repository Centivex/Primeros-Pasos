package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.tools.texturepacker.TexturePacker;


public class Game extends ApplicationAdapter {
	SpriteBatch batch;

	private TextureAtlas textAtlas;
	private Animation anim;
	private float tiempoAnim=0;


	//public static void main (String[] args) throws Exception {
	//	TexturePacker.process("C:\\Users\\abran\\Desktop\\pruebafusion", "C:\\Users\\abran\\Desktop\\pruebafusion\\fusion", "movimiento");
	//}

	@Override
	public void create () {
		batch = new SpriteBatch();

		textAtlas= new TextureAtlas(Gdx.files.internal("Player/movimiento.atlas"));

		TextureRegion[] movDerecha= new TextureRegion[4];

		for(int i=0;i<4;i++){

			movDerecha[i]= (textAtlas.findRegion("caminar_derecha",i+1));
			System.out.println("i es: "+i);
		}

		anim= new Animation(1f, movDerecha);

		//para pillar completo el atlas:
		//anim= new Animation(1/15f, textAtlas.getRegions());
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		tiempoAnim += Gdx.graphics.getDeltaTime();
		batch.draw((TextureRegion) anim.getKeyFrame(tiempoAnim,false),0,0);
		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		textAtlas.dispose();

	}
}