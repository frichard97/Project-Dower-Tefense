package hu.legjava.game.Types;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import hu.legjava.game.Objects.Enemy;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import static hu.legjava.game.Main.PPM;
import static hu.legjava.game.Main.TOWER_POWER;

public  class Attack{

    private Sprite sprite;
    private float dmg_arany = 0;
    private boolean attack_end = false;
    private float x, y;
    private Special special;
    private float basex;
    private float basey;
    private float kristaly = 1;
    private float arany;
    private float dmg = 0;
    private float hp_arany = 0;
    private float armor_arany = 0;

    public boolean isCan_Attack() {
        return can_Attack;
    }

    public void plusKristaly() {
        this.kristaly++;
        calculateStats();

    }
    public void calculateStats()
    {
        dmg = 0;
        arany = 0;
        for(int i = 0; i < kristaly; i++)
        {
            arany += TOWER_POWER*Math.pow(0.95,i)*2;
        }
        dmg = arany*(dmg_arany/100);

        System.out.println(arany);
    }
    public void minusKristaly()
    {
        if(kristaly > 1) {
            this.kristaly--;
            calculateStats();
        }
    }

    private boolean can_Attack = true;
    public Attack(Texture text, float dmg_arany, float armor_arany, float hp_arany, Special special) {
        this.sprite = new Sprite(text);
        this.dmg_arany = dmg_arany;
        this.special = special;
        this.armor_arany = armor_arany;
        this.hp_arany = hp_arany;
        sprite.setBounds(x,y,sprite.getWidth()/PPM,sprite.getHeight()/PPM);
        calculateStats();

    }
    public float getArmor()
    {
         return arany*(armor_arany/100);
    }
    public float getHp()
    {
        return arany*(hp_arany/100);
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
        return special.getSpecial(Special.SpecialTypes.AOE);
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
        float tavolsagx = ex - x;
        float tavolsagy = ey - y;
        float ossztavolsag = (float)Math.sqrt((Math.pow(tavolsagx, 2) +Math.pow(tavolsagy, 2)));
        this.x += (tavolsagx / ossztavolsag)*0.025;
        this.y += (tavolsagy / ossztavolsag)*0.025;
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
