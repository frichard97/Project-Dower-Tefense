package hu.legjava.game.Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import hu.legjava.game.Main;
import hu.legjava.game.Net.Events;
import hu.legjava.game.Types.Attack;
import hu.legjava.game.Types.EnemyType;
import hu.legjava.game.Types.Priority;
import hu.legjava.game.VDat;

import java.util.ArrayList;
import java.util.List;

import static hu.legjava.game.Main.PPM;
import static hu.legjava.game.Types.Special.SpecialTypes.IGNITE;
import static hu.legjava.game.Types.Special.SpecialTypes.SLOW;

public class Enemy extends VDat {
    private float speed;
    private Priority prio;
    private Sprite a ;
    public Enemy(float speed, EnemyType type,boolean local,float x,float y)
    {
        //TODO TEST HP
        this.hp = 60;
        this.local = local;
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.prio = new Priority(type);
        a = new Sprite((Texture) Main.manager.get("magus2.png"));
        a.setBounds(x,y,a.getWidth()/PPM,a.getHeight()/PPM);


    }
    @Override
    protected void update(float s) {

    }

    @Override
    protected void draw(SpriteBatch batch) {
        a.draw(batch);
    }
    public float attack(ArrayList<Tower> towers)
    {
        //TODO ENEMY ATTACK
        return 0;
    }

    @Override
    protected Events event() {
        return null;
    }
    public void getDMG(Attack attack)
    {
        //TODO ezeket kell kibővíteni a többi hatással
        this.hp -= attack.getDmg();
        this.speed -= attack.getSpecial(SLOW);
        this.armor -= attack.getSpecial(IGNITE);
        if(this.hp <= 0)
        {
            destroy();
        }
        System.out.println("TESTENEMY: "+this.hp);

    }
}
