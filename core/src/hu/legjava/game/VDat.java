package hu.legjava.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import hu.legjava.game.Net.Events;
import hu.legjava.game.Types.Attack;

import static hu.legjava.game.Types.Special.SpecialTypes.IGNITE;
import static hu.legjava.game.Types.Special.SpecialTypes.SLOW;

public abstract class VDat {
    protected enum Type{
        ENEMY,
        TOWER,
        PLAYER
    }
    protected float x;
    protected float y;
    protected int id;
    protected int spriteid;
    protected float hp;
    protected boolean local;
    protected  float armor;
    protected  abstract void update(float s);
    private  Type type;
    protected Events pull(){
        Events.Datas  a = new Events.Datas();
        a.hp = hp;
        a.x = x;
        a.id = id;
        a.spriteid = spriteid;
        a.local = false;
        return a;
    }
    public VDat(Type type)
    {
        this.type = type;
    }
    protected abstract void draw(SpriteBatch batch);
    protected abstract Events event();

}
