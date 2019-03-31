package hu.legjava.game.Menus;

import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import hu.legjava.game.Main;

public class StartingScreen implements Screen {
    Main main;
    private Texture betoltokep;
    private SpriteBatch batch;
    private ShapeRenderer sr;

    public StartingScreen(Main main)
    {
        this.main = main;
    }
    @Override
    public void show() {

        Main.manager.load("magus2.png", Texture.class);
        Main.manager.load("kristaly.png", Texture.class);
        Main.manager.load("basetower.png", Texture.class);
        Main.manager.load("levelkristaly.png", Texture.class);
        Main.manager.load("viz30.png",Texture.class);
        Main.manager.load("tuz30.png",Texture.class);
        Main.manager.load("magma30.png",Texture.class);
        Main.manager.load("life30.png",Texture.class);
        Main.manager.load("futotuz30.png",Texture.class);
        Main.manager.load("goz30.png",Texture.class);
        Main.manager.load("jeg30.png",Texture.class);
        Main.manager.load("villam30.png",Texture.class);
        Main.manager.load("base.png",Texture.class);


        batch = new SpriteBatch();
        //betoltokep = new Texture("betoltoscreen.png");
    }

    @Override
    public void render(float delta) {
        sr = new ShapeRenderer();

        batch.begin();
        //batch.draw(betoltokep, 0, 0);
        batch.end();

        sr.begin(ShapeRenderer.ShapeType.Filled);
        sr.setColor(Color.GREEN);
        sr.rect(Main.GAMEWIDTH/2-200, Main.GAMEHEIGHT/7,(400*Main.manager.getProgress()),20);

        sr.end();
        if(Main.manager.update())
        {
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
