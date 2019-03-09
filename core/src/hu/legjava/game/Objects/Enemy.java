package hu.legjava.game.Objects;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import hu.legjava.game.Net.Events;
import hu.legjava.game.Types.Attack;
import hu.legjava.game.Types.EnemyType;
import hu.legjava.game.Types.Priority;
import hu.legjava.game.VDat;

import java.util.List;

import static hu.legjava.game.Types.Special.SpecialTypes.IGNITE;
import static hu.legjava.game.Types.Special.SpecialTypes.SLOW;

public class Enemy extends VDat {
    private float speed;
    private Priority prio;
    public Enemy(float speed, EnemyType type)
    {
        super(Type.ENEMY);
        this.speed = speed;
        this.prio = new Priority(type);

    }
    @Override
    protected void update(float s) {

    }

    @Override
    protected void draw(SpriteBatch batch) {

    }
    public float attack(List<Tower> towers)
    {
        //TODO ENEMY ATTACK
        return 0;
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
    public void getDMG(Attack attack)
    {
        //TODO ezeket kell kibővíteni a többi hatással
        this.hp -= attack.getDmg();
        this.speed -= attack.getSpecial(SLOW);
        this.armor -= attack.getSpecial(IGNITE);

    }
}
