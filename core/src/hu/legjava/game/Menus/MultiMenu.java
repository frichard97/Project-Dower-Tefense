package hu.legjava.game.Menus;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import hu.legjava.game.Main;

public class MultiMenu implements Screen {
    private Main main;
    private TextButton create;
    private TextButton join;
    private TextButton back;
    private Stage stage;
    private Table table;
    public MultiMenu(Main main)
    {
        this.main = main;
    }
    @Override
    public void show() {
        stage = new Stage();
        table = new Table();
        table.setFillParent(true);
        join = new TextButton("Join",main.getSkin());
        create = new TextButton("Create",main.getSkin());
        back = new TextButton("Back",main.getSkin());
        table.add(create).size(200,90).spaceBottom(5f).row();
        table.add(join).size(200,90).spaceBottom(5f).row();
        table.add(back).size(200,90).spaceBottom(5f).row();
        stage.addActor(table);
        Gdx.input.setInputProcessor(stage);
        create.addListener(new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y) {

                main.setScreen(new CreateMenu(main));
                dispose();
                super.clicked(event, x, y);
            }
        });
        join.addListener(new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y) {
                main.setScreen(new JoinMenu(main));
                dispose();
                super.clicked(event, x, y);
            }
        });
        back.addListener(new ClickListener(){

            @Override
            public void clicked(InputEvent event, float x, float y) {
                main.setScreen(new MainMenu(main));
                dispose();
                super.clicked(event, x, y);
            }
        });

    }

    @Override
    public void render(float delta) {
        stage.act(delta);
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
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
        stage.dispose();
    }
}
