package hu.legjava.game.Menus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import hu.legjava.game.Main;

public class MainMenu implements Screen {
    private Main main;
    private TextButton singlePlayer;
    private TextButton multiPlayer;
    private TextButton exit;
    private Stage stage;
    private Table table;
    public MainMenu(Main main)
    {
        this.main = main;
    }
    @Override
    public void show() {
            stage = new Stage();
            table = new Table();
            table.setFillParent(true);
            singlePlayer = new TextButton("SinglePlayer",main.getSkin());
            multiPlayer = new TextButton("MultiPlayer",main.getSkin());
            exit = new TextButton("Exit",main.getSkin());
            table.add(singlePlayer).size(200,90).spaceBottom(5f).row();
            table.add(multiPlayer).size(200,90).spaceBottom(5f).row();
            table.add(exit).size(200,90).spaceBottom(5f).row();
            stage.addActor(table);
            Gdx.input.setInputProcessor(stage);

    }

    @Override
    public void render(float delta) {
        stage.act(delta);
        stage.draw();
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
