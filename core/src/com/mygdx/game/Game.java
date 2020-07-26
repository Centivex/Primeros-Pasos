package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;


public class Game extends ApplicationAdapter {
	SpriteBatch batch;
	//private BitmapFont font;

	//private Texture texPlayer;
	//private Sprite  spritPlayer;

	private Pixmap pixDibujo;
	private Texture texDibujo;
	private Sprite spritDibujo;




	@Override
	public void create () {
		batch = new SpriteBatch();
		//dibujar cuadrado y rellaenarlo de ese color
		pixDibujo = new Pixmap(256,128, Pixmap.Format.RGBA8888);
		pixDibujo.setColor(Color.GREEN);
		pixDibujo.fill();

		//dibujar linea
		pixDibujo.setColor(Color.BLACK);
		pixDibujo.drawLine(0, 0, pixDibujo.getWidth()-1, pixDibujo.getHeight()-1);
		pixDibujo.drawLine(0, pixDibujo.getHeight()-1, pixDibujo.getWidth()-1, 0);

		//dibujar u circulo
		pixDibujo.setColor(Color.YELLOW);
		pixDibujo.drawCircle(pixDibujo.getWidth()/2, pixDibujo.getHeight()/2, pixDibujo.getHeight()/2 - 1);


		texDibujo = new Texture(pixDibujo);

		pixDibujo.dispose();

		spritDibujo= new Sprite(texDibujo);

		//texPlayer= new Texture("Player/caminar_abajo_1.png");
		//spritPlayer= new Sprite(texPlayer);

		//font = new BitmapFont();
		//font.setColor(Color.BLUE);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();

		spritDibujo.setPosition(0, 0);
		spritDibujo.draw(batch);
		spritDibujo.setPosition(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
		spritDibujo.draw(batch);

		//spritPlayer.draw(batch);

		//font.draw(batch,"HOLA",200,200);
		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		texDibujo.dispose();
		//texPlayer.dispose();
		//font.dispose();
	}
}