package hu.legjava.game.Types;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import hu.legjava.game.Objects.Enemy;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import static hu.legjava.game.Main.PPM;

public  class Attack{

    protected Sprite sprite;
    private float dmg = 0;
    private boolean attack_end = false;
    private float x, y;
    private float aoe;
    private Special special;
    private float basex;
    private float basey;

    public boolean isCan_Attack() {
        return can_Attack;
    }

    private boolean can_Attack = true;
    public Attack(Sprite sprite, float aoe, float dmg,Special special) {
        this.sprite = sprite;
        this.dmg = dmg;
        this.aoe = aoe;
        this.special = special;
        sprite.setBounds(x,y,sprite.getWidth()/PPM,sprite.getHeight()/PPM);

    }

    public boolean isAttack_end() {
        return attack_end;
    }

    public void setBase(float x,float y)
    {
        this.basex = x;
        this.basey = y;
        this.x = basex;
        this.y = basey;
    }
    public float getSpecial(Special.SpecialTypes type)
    {
        return special.getSpecial(type);
    }

    public float getAoe() {
        return aoe;
    }
    public float getDmg()
    {
        return dmg;
    }

    public void draw(SpriteBatch batch){
        if(!attack_end) {
            sprite.setPosition(x, y);
            sprite.draw(batch);
        }
    }
    public void update(float ex,float ey) {
        attack_end = false;
        double tavolsagx = ex - x;
        double tavolsagy = ey - y;
        double ossztavolsag = Math.sqrt(Math.pow(tavolsagx, 2) + Math.pow(tavolsagy, 2));
        this.x += ossztavolsag / tavolsagx / PPM;
        this.y += ossztavolsag / tavolsagy / PPM;
        if (ossztavolsag < 0.1f) {
            attack_end = true;
            this.x = basex;
            this.y = basey;
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    can_Attack = true;
                }
            };
            Timer a = new Timer();
            a.schedule(task,1000);
            can_Attack = false;
        }
        //TODO ANIMATION END

    }
}
