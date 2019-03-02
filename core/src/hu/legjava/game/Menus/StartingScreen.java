package hu.legjava.game.Menus;

import com.badlogic.gdx.Screen;
import hu.legjava.game.Main;

public class StartingScreen implements Screen {
    Main main;
    public StartingScreen(Main main)
    {
        this.main = main;
    }
    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        if(Main.manager.isFinished())
        {
            //TODO ASSETS LOAD
            main.setScreen(new MainMenu(main));
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
