package hu.legjava.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import hu.legjava.game.Net.Events;

public abstract class VDat {
    protected float x;
    protected float y;
    protected int id;
    protected int spriteid;
    protected float hp;
    protected boolean local;
    protected  abstract void update(float s);
    //protected abstract void pull();
    protected abstract void draw(SpriteBatch batch);
    protected abstract Events event();

}
