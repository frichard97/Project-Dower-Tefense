package hu.legjava.game.Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import hu.legjava.game.Net.Events;
import hu.legjava.game.Types.Attack;
import hu.legjava.game.Types.EnemyType;
import hu.legjava.game.Types.Priority;
import hu.legjava.game.VDat;

import java.util.List;

import static hu.legjava.game.Main.PPM;
import static hu.legjava.game.Types.Special.SpecialTypes.IGNITE;
import static hu.legjava.game.Types.Special.SpecialTypes.SLOW;

public class Enemy extends VDat {
    private float speed;
    private Priority prio;
    private Sprite a ;
    public Enemy(float speed, EnemyType type,boolean local)
    {
        this.local = local;
        x= 199.4f;
        y = 199.4f;
        this.speed = speed;
        this.prio = new Priority(type);
        a = new Sprite(new Texture("magus2.png"));
        a.setBounds(x,y,a.getWidth()/PPM,a.getHeight()/PPM);


    }
    @Override
    protected void update(float s) {

    }

    @Override
    protected void draw(SpriteBatch batch) {
        a.draw(batch);
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
        System.out.println("TESTENEMY: "+this.hp);

    }
}
