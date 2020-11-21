package com.mygdx.game.Actores;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class MapaZelda extends Actor {

    private TiledMap tiledMap;
    private TiledMapRenderer tiledMapRenderer;
    private OrthographicCamera cam;

    private World world;


    public MapaZelda(OrthographicCamera cam , World world){
        this.world=world;
        this.cam=cam;
        tiledMap= new TmxMapLoader().load("Mapa/Prado.tmx");
        tiledMapRenderer = new OrthogonalTiledMapRenderer(tiledMap, 1/100f);

        BodyDef bdefMap=new BodyDef();
        PolygonShape shapeMap= new PolygonShape();
        FixtureDef fdefMap= new FixtureDef();
        Body bodyMap;

        for(MapObject object: tiledMap.getLayers().get(3).getObjects().getByType(RectangleMapObject.class)){
            Rectangle rect= ((RectangleMapObject) object).getRectangle();

            bdefMap.type= BodyDef.BodyType.StaticBody;
            bdefMap.position.set((rect.getX()+ rect.getWidth()/2)/100, (rect.getY()+rect.getHeight()/2)/100);

            bodyMap=world.createBody(bdefMap);
            shapeMap.setAsBox((rect.getWidth()/2)/100, (rect.getHeight()/2)/100);
            fdefMap.shape=shapeMap;
            bodyMap.createFixture(fdefMap);
        }


    }

    public void dibuja(){
        tiledMapRenderer.setView(cam);
        tiledMapRenderer.render();
    }

}
