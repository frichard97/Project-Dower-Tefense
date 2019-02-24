package hu.legjava.game.Menus;
import com.badlogic.gdx.Screen;
import hu.legjava.game.Controller;
import hu.legjava.game.Net.Net;

public class LoadingScreen implements Screen {
    Net net;
    Controller controller;

    public Net getNet() {
        return net;
    }
    public LoadingScreen() {
        controller = new Controller();
    }
    public LoadingScreen(Net net) {
        controller = new Controller(net);
    }

    @Override
    public void show() {
        //TODO ESETLEGES JÁTÉK ELPKÉSZÜLETI MÜVELETEKNEK EGY LOADER
    }

    @Override
    public void render(float delta) {
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
