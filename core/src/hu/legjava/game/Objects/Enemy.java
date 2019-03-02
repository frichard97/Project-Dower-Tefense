package hu.legjava.game.Objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import hu.legjava.game.Net.Events;
import hu.legjava.game.VDat;

public class Enemy extends VDat {
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
    public float getX()
    {
        return x;
    }
    public float getY()
    {
        return y;
    }
}
