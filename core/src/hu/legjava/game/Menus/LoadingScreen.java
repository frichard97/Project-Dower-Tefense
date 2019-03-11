package hu.legjava.game.Menus;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import hu.legjava.game.Controller;
import hu.legjava.game.GameScreen;
import hu.legjava.game.Main;
import hu.legjava.game.Net.Net;




public class LoadingScreen implements Screen {

    Net net;
    Controller controller;




    public Net getNet() {
        return net;
    }
    private Main main;
    public LoadingScreen(Main main) {
        controller = new Controller();
        this.main = main;
    }
    public LoadingScreen(Main main,Net net) {
        controller = new Controller(net);
        this.main = main;
    }

    @Override
    public void show() {
        //TODO ESETLEGES JÁTÉK ELőKÉSZÜLETI MÜVELETEKNEK EGY LOADER
        main.setScreen(new GameScreen(main,controller));

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
