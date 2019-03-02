package hu.legjava.game;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import hu.legjava.game.Menus.StartingScreen;

public class Main extends Game {
	static public AssetManager manager;
	public enum STATES{
		SINGLEPLAYER,
		SERVER,
		CLIENT
	}
	static public STATES state;

	public static Skin getSkin() {
		return skin;
	}

	public static void setSkin(Skin skin) {
		Main.skin = skin;
	}

	static private Skin skin;
	@Override
	public void create () {
		manager = new AssetManager();
		skin = new Skin(Gdx.files.internal("uiskin.json"));
		setScreen(new StartingScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
}
