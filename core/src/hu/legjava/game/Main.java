package hu.legjava.game;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.assets.AssetManager;
import hu.legjava.game.Menus.StartingScreen;

public class Main extends Game {
	static public AssetManager manager;
	@Override
	public void create () {
		manager = new AssetManager();
		setScreen(new StartingScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
}
