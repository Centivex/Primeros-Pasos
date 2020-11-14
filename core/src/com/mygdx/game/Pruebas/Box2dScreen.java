package com.mygdx.game.Pruebas;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.mygdx.game.BaseScreen;
import com.mygdx.game.Game;

public class Box2dScreen extends BaseScreen {

    //el mundo
    private World world;

    //hacer que el mundo acepte renders
    private Box2DDebugRenderer renderer;
    private OrthographicCamera cam;

    //el cuerpo
    private Body playerBody;
    private Fixture playerFixture;

    private Body circuloBody;
    private  Fixture circuloFixture;

    private boolean choca=false;

    public Box2dScreen(Game juego) {
        super(juego);
    }

    @Override
    public void show() {
        super.show();
        world= new World(new Vector2(0,0), true);

        cam = new OrthographicCamera(20,20);
        renderer=new Box2DDebugRenderer();

        //---------------------------------------------------------------------------------------------------
        //colisiones
        world.setContactListener(new ContactListener() {
            @Override
            public void beginContact(Contact contact) {
                Fixture fixtureA=contact.getFixtureA(), fixtureB= contact.getFixtureB();

                if (fixtureA.getUserData().equals("player")&& fixtureB.getUserData().equals("circulo")
                        ||fixtureA.getUserData().equals("circulo")&& fixtureB.getUserData().equals("player" )){
                    choca=true;
                }

                /*if (fixtureA== playerFixture && fixtureB== circuloFixture){
                    choca=true;
                }*/
            }

            @Override
            public void endContact(Contact contact) {

            }

            @Override
            public void preSolve(Contact contact, Manifold oldManifold) {

            }

            @Override
            public void postSolve(Contact contact, ContactImpulse impulse) {

            }
        });

        //----------------------------------------------------------------------------------------------------
        //necesitamos definir el cuerpo
        BodyDef playerDef=new BodyDef();
        playerDef.position.set(0,0);
        //puede ser dinamico o estatico
        playerDef.type= BodyDef.BodyType.DynamicBody;
        playerBody= world.createBody(playerDef);

        //----------------------------------------------------------------
        BodyDef circleDef= new BodyDef();
        circleDef.position.set(5, 0);
        circleDef.type= BodyDef.BodyType.StaticBody;
        circuloBody=world.createBody(circleDef);



        //------------------------------------------------------------------
        //le damos forma al cuerpo
        PolygonShape playerShape= new PolygonShape();
        //esto funciona en metro, no en pixeles D:
        playerShape.setAsBox(0.75f,0.75f);
        playerFixture=playerBody.createFixture(playerShape,1);
        playerShape.dispose();


        //-----------------------------------------------------------------
        CircleShape circleShape= new CircleShape();
        circleShape.setRadius(1);
        circuloFixture= circuloBody.createFixture(circleShape,1);
        circleShape.dispose();


        circuloFixture.setSensor(true);
        //----------------------------------------------------------------
        //meter userdata para las colisiones
        playerFixture.setUserData("player");
        circuloFixture.setUserData("circulo");

    }

    @Override
    public void render(float delta) {
        super.render(delta);
        Gdx.gl.glClearColor(0, 0, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        world.step(delta,6,2);

        cam.update();
        renderer.render(world,cam.combined);

        if(Gdx.input.isKeyPressed(Input.Keys.LEFT)){
            playerBody.applyLinearImpulse(1,0,playerBody.getPosition().x,playerBody.getPosition().y,true);
        }

        if(choca==true){
            System.out.println("hola");
        }

    }

    @Override
    public void dispose() {
        super.dispose();
        playerBody.destroyFixture(playerFixture);
        world.destroyBody(playerBody);
        circuloBody.destroyFixture(circuloFixture);
        world.destroyBody(circuloBody);
        world.dispose();
        renderer.dispose();

    }
}
