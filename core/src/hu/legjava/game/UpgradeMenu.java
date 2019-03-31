package hu.legjava.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import hu.legjava.game.Objects.Player;
import hu.legjava.game.Objects.Tower;

public class UpgradeMenu extends Window {
    Tower tower;
    Resources resources;
    Table table;
    TextButton levelup;
    TextButton leveldown;



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
        table = new Table();
        table.setFillParent(true);
        this.addActor(table);
        levelup = new TextButton("Level Up",Main.getSkin());
        leveldown = new TextButton("Level Down",Main.getSkin());
        table.add(levelup).size(100,100).row();
        table.add(leveldown).size(100,100).row();


    }
    public void setTower(Tower tower)
    {
        this.tower = tower;
        this.setPosition(Gdx.input.getX()-this.getWidth()/2,Main.GAMEHEIGHT-Gdx.input.getY()-this.getHeight()/2);
        this.setVisible(true);
    }
}
