package hu.legjava.game.Objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import hu.legjava.game.Net.Events;
import hu.legjava.game.Types.ObjectTypes;
import hu.legjava.game.Types.Updateable;
import hu.legjava.game.VDat;

public class Tower extends VDat implements Updateable {
    protected ObjectTypes type;
    private Actor upgrademenu;
    private Actor clicklistener;
    public Tower(ObjectTypes type)
    {
        this.type = type;
        clicklistener = new Actor();
        upgrademenu = ObjectTypes.getMENU(type);

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

    @Override
    public void showupgrademenu() {
        upgrademenu.setVisible(true);
    }
}
