package hu.legjava.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import static hu.legjava.game.Main.PPM;

public class GameScreen implements Screen {
    private Main main;
    private Controller controller;
    private SpriteBatch batch;
    private OrthographicCamera cam;
    private Sprite grasstest;
    private Sprite basetoweertest;

    public GameScreen(Main main,Controller controller) {
        this.main = main;
        this.controller = controller;


    }

    @Override
    public void show() {
        batch = new SpriteBatch();
        cam = controller.getCam();
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glEnable(GL20.GL_BLEND);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        controller.update(delta);
        controller.mapRenderer();
        batch.setProjectionMatrix(cam.combined);
        batch.begin();
        //grasstest.draw(batch);
        //basetoweertest.draw(batch);

        for(VDat dat : controller.getSprites())
            {
            dat.draw(batch);
            }
        batch.end();
        controller.renderer(batch);
        }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
}
