package hu.legjava.game;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import hu.legjava.game.Objects.AttackTower;
import hu.legjava.game.Objects.Enemy;
import hu.legjava.game.Objects.Tower;
import hu.legjava.game.Types.Attack;

import java.util.ArrayList;
import java.util.List;

public class AttackListener {
    private ArrayList<Enemy> enemy;
    private ArrayList<Tower> tower;
    public AttackListener()
    {
     enemy = new ArrayList<Enemy>();
     tower = new ArrayList<Tower>();
    }
    public void setLists(ArrayList<Enemy> enemy,ArrayList<Tower> tower){this.enemy = enemy; this.tower = tower; }
    public void TowerAttack(SpriteBatch batch)
    {
        for(Tower first : tower)
        {
            if(first instanceof AttackTower)
            {
                    if( ((AttackTower) first).isCan_Attack()&&((AttackTower) first).getFocus() == null) {
                        float min = 100f;
                        for (Enemy e : enemy) {
                            float tavolsag = tavolsagprio(e, (AttackTower) first);
                            if (tavolsag < ((AttackTower) first).getRange()) {
                                if (min > tavolsag) {
                                    min = tavolsag;
                                    ((AttackTower) first).setFocus(e);
                                }
                            }
                        }
                    }

                if(((AttackTower) first).getFocus() != null) {
                    if(((AttackTower) first).isCan_Attack())
                    ((AttackTower) first).attack(enemy, batch);
                }

            }
        }
    }
    public float tavolsagprio(Enemy e, AttackTower a)
    {
        return (float)Math.sqrt(Math.pow(e.getX()-a.getX(),2)+Math.pow(e.getY()-a.getY(),2));
    }

}
