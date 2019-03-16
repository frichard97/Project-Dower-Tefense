package hu.legjava.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import hu.legjava.game.Objects.Player;
import hu.legjava.game.Objects.Tower;

public class UpgradeMenu extends Window {
    Tower tower;
    Resources resources;
    public UpgradeMenu(String title, Skin skin,Resources resources)
    {
        super(title, skin);
        this.resources = resources;
        this.setVisible(false);
        this.setSize(400,500);
        this.setMovable(false);
        this.addListener(new InputListener(){

            @Override
            public boolean keyDown(InputEvent event, int keycode) {
                if(keycode == Input.Keys.ESCAPE)
                {
                    setVisible(false);
                    Player.setMove(true);
                }
                return super.keyDown(event, keycode);
            }
        });

    }
    public void setTower(Tower tower)
    {
        this.tower = tower;
        this.setPosition(Gdx.input.getX()-this.getWidth()/2,Main.GAMEHEIGHT-Gdx.input.getY()-this.getHeight()/2);
        this.setVisible(true);
    }
}
