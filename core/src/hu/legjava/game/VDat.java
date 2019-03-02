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
    protected Events pull(){
        Events.Datas  a = new Events.Datas();
        a.hp = hp;
        a.x = x;
        a.id = id;
        a.spriteid = spriteid;
        a.local = false;
        return a;
    }
    protected abstract void draw(SpriteBatch batch);
    protected abstract Events event();

}
