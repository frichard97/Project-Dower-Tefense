package hu.legjava.game;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class GameScreen implements Screen {
    private Main main;
    private Controller controller;
    private SpriteBatch batch;
    private OrthographicCamera cam;
    public GameScreen(Main main,Controller controller) {
        super();

    }

    @Override
    public void show() {
        this.main = main;
        this.controller = controller;
        cam = controller.cam;
        batch.setTransformMatrix(cam.combined);
    }

    @Override
    public void render(float delta) {
        controller.update(delta);
        for(VDat dat : controller.getSprites())
            {
            if(dat.local)dat.update(delta);
            dat.draw(batch);
            }
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
