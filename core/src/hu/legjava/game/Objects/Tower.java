package hu.legjava.game.Objects;

import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import hu.legjava.game.Controller;
import hu.legjava.game.Main;
import hu.legjava.game.Net.Events;
import hu.legjava.game.Types.ObjectTypes;
import hu.legjava.game.UpgradeMenu;
import hu.legjava.game.VDat;

public class Tower extends VDat {
    protected ObjectTypes type;
    private Actor clicklistener;
    public Tower(ObjectTypes type,float x,float y)
    {
        this.x = x;
        this.y = y;
        this.type = type;
        clicklistener = new Actor();
        clicklistener.setBounds(x,y,1,1);
        clicklistener.addListener(new ClickListener(Input.Buttons.RIGHT){

            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                if(!Controller.upgradeIsOn()) {
                    showupgrademenu();
                    Player.setMove(false);
                }
            }
        });
        System.out.println(x+" "+y);

    }
    public Actor getClickListener()
    {
        return clicklistener;
    }
    @Override
    protected void update(float s) {
    }

    @Override
    protected void draw(SpriteBatch batch) {

    }

    @Override
    protected Events event() {
        return null;
    }

    @Override
    public void destroy() {

    }
    private void showupgrademenu() {
        Controller.showUpgradeMenu(this);
    }
}
