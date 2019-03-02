package hu.legjava.game.Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.World;
import hu.legjava.game.Types.AType;
import hu.legjava.game.Types.Attack;
import hu.legjava.game.Types.AttackFactory;
import hu.legjava.game.Net.Events;
import hu.legjava.game.VDat;

import java.util.ArrayList;

import static hu.legjava.game.Main.PPM;
/**************************
 * MAX LEVEL 5
 *
 * ***********************************/
/***********************GRAFIKA****************************/
public class AttackTower extends VDat {
    private Sprite alap;
    private Sprite kristaly;
    private Sprite levelkristaly;
    private World world;
    private float timer;
    private int level = 1; //TODO MAX 5
    private float[][] bounds = new float[][]{
            { 32, 33 },
            { 33, -32 },
            { -33,-32},
            {-32,33}
    };
     /*************************Végleges*************************/
     private Attack attack;
    public AttackTower(World world,boolean local)
    {
        x = 200;
        y = 200;
        this.local = local;
        this.world = world;
        //TODO EZ MÉG CSAK GRAFIKA TEST
        alap = new Sprite(new Texture("basetower.png"));
        kristaly = new Sprite(new Texture("kristaly.png"));
        alap.setBounds(20000/PPM,20000/PPM,alap.getWidth()/PPM,alap.getHeight()/PPM);
        kristaly.setBounds(20000/PPM,20000/PPM,kristaly.getWidth()/PPM,kristaly.getHeight()/PPM);
        kristaly.setOriginCenter();
        levelkristaly = new Sprite(new Texture("levelkristaly.png"));
        levelkristaly.setBounds(0,0,levelkristaly.getWidth()/PPM,levelkristaly.getHeight()/PPM);
        attack = AttackFactory.getAttackType(AType.Basic);
        attack.setBase(x,y);
    }
    @Override
    protected void update(float s) {
        timer += s*20;
        if(timer > 360)
        {
            timer = 0;
        }
        kristaly.setRotation(timer);
    }

    @Override
    protected void draw(SpriteBatch batch) {
        alap.draw(batch);
        kristaly.draw(batch);
        for(int i = 0; i < level-1; i++)
        {
                levelkristaly.setPosition(x + bounds[i][0] / PPM, y + bounds[i][1] / PPM);
                levelkristaly.draw(batch);
        }

    }
    public boolean attack(Enemy focus,ArrayList<Enemy> enemies, SpriteBatch batch){

        attack.update(focus.getX(),focus.getY());
        attack.draw(batch);
        if(attack.isAttack_end()) {
            for(Enemy enemy : enemies)
            {
                //TODO SPECIAL WITH AOE
                //TODO SPAWN HERE
            }
        }
        return false;

    }
    private float tavolsag(float enemyx,float enemyy)
    {
        return (float)Math.sqrt(Math.pow(enemyx-x,2)+Math.pow(enemyy-y,2));
    }

    @Override
    protected Events event() {
        return null;
    }
}