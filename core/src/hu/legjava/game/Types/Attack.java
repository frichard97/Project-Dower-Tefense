package hu.legjava.game.Types;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import hu.legjava.game.Objects.Enemy;

import java.util.Date;

public  class Attack {

    protected Sprite sprite;
    private float dmg = 0;
    private boolean attack_end = false;
    private float x, y;
    private float aoe;
    private Special special;
    public Attack(Sprite sprite, float aoe, float dmg,Special special) {
        this.sprite = sprite;
        this.dmg = dmg;
        this.aoe = aoe;
        this.special = special;
    }

    public boolean isAttack_end() {
        return attack_end;
    }

    public void setBase(float x,float y)
    {
        this.x = x;
        this.y = y;
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
        sprite.draw(batch);
    }
    public void update(float ex,float ey){
            double tavolsagx = ex - x;
            double tavolsagy = ey - y;
            double ossztavolsag = Math.sqrt(Math.pow(tavolsagx, 2) + Math.pow(tavolsagy, 2));
            this.x += ossztavolsag / tavolsagx;
            this.y += ossztavolsag / tavolsagy;
            if(ossztavolsag < 0.1f) attack_end = true;
            //TODO ANIMATION END

    }


}
