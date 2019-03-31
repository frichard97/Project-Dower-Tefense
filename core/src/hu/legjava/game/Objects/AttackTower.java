package hu.legjava.game.Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.scenes.scene2d.Actor;
import hu.legjava.game.Main;
import hu.legjava.game.Types.*;
import hu.legjava.game.Net.Events;
import hu.legjava.game.VDat;

import java.util.ArrayList;

import static hu.legjava.game.Main.PPM;
import static hu.legjava.game.Types.Special.SpecialTypes.SPAWN;
/**************************
 * MAX LEVEL 5
 *
 * ***********************************/
/***********************GRAFIKA****************************/
public class AttackTower extends Tower {

    /*************************Végleges*************************/
    private Attack attack;
    private final float attack_bounds = 0.15f;

    private final float range = 4f;
    private Sprite alap;
    private Sprite kristaly;
    private Sprite levelkristaly;
    private World world;
    private float timer;
    private int level = 1; //TODO MAX 5
    private Body body;
    private AttackFactory factory;

    public Enemy getFocus() {
        return focus;
    }

    public void setFocus(Enemy focus) {
        this.focus = focus;
    }


    private Enemy focus = null;
    private float[][] bounds = new float[][]{
            { 32, 33 },
            { 33, -32 },
            { -33,-32},
            {-32,33}
    };
    public AttackTower(World world, boolean local, float x,float y)
    {
        super(ObjectTypes.ATTACKTOWER,x,y);
        this.local = local;
        this.world = world;
        /********************GRAFIKA******************/
        alap = new Sprite((Texture) Main.manager.get("basetower.png"));
        kristaly = new Sprite((Texture) Main.manager.get("kristaly.png"));
        alap.setBounds(x,y,alap.getWidth()/PPM,alap.getHeight()/PPM);
        kristaly.setBounds(x,y,kristaly.getWidth()/PPM,kristaly.getHeight()/PPM);
        kristaly.setOriginCenter();
        levelkristaly = new Sprite((Texture) Main.manager.get("levelkristaly.png"));
        levelkristaly.setBounds(0,0,levelkristaly.getWidth()/PPM,levelkristaly.getHeight()/PPM);
        /*****************Incializálja a grafikát*****************/
        factory = new AttackFactory();
        attack = factory.getAttackType(AType.ICE);
        attack.setBase(x+alap.getWidth()/2-attack_bounds,y+alap.getHeight()/2-attack_bounds);
        /*********************************ENGINE************************/
        BodyDef bdef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fdef = new FixtureDef();
        bdef.type = BodyDef.BodyType.StaticBody;
        bdef.position.set(x+alap.getWidth()/2,y+alap.getHeight()/2);
        body = world.createBody(bdef);
        shape.setAsBox(alap.getWidth()/2,alap.getHeight()/2);
        fdef.shape = shape;
        body.createFixture(fdef);
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
    public boolean isCan_Attack()
    {
        return attack.isCan_Attack();
    }
    public float attack(ArrayList<Enemy> enemies, SpriteBatch batch){
        attack.update(focus.getX(),focus.getY());
        attack.draw(batch);
        if(attack.isAttack_end()) {
            for (Enemy enemy : enemies) {
                if (aoe(focus.getX(), focus.getY(), enemy.getX(), enemy.getY())) {
                    enemy.getDMG(attack);
                }
            }
            focus = null;
            return attack.getSpecial(SPAWN);
        }
        return 0;

    }
    private boolean aoe(float focusx,float focusy,float enemyx,float enemyy)
    {
        return  attack.getAoe() >= (float)Math.sqrt(Math.pow(enemyx-focusx,2)+Math.pow(enemyy-focusy,2));
    }
    public float getRange()
    {
        return range;
    }

    @Override
    public float getX()
    {
        return x+alap.getWidth()/2;
    }
    @Override
    public float getY()
    {
        return y+alap.getHeight()/2;
    }
    @Override
    protected Events event() {
        return null;
    }
}
