package hu.legjava.game.Objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import hu.legjava.game.Net.Events;
import hu.legjava.game.Types.ObjectTypes;
import hu.legjava.game.VDat;

public class Tower extends VDat {
    protected ObjectTypes type;
    public Tower(ObjectTypes type)
    {
        super(Type.TOWER);
        this.type = type;
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
}
