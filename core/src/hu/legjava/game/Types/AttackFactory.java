package hu.legjava.game.Types;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import hu.legjava.game.Main;

import static hu.legjava.game.Types.AType.*;

public class AttackFactory {
    public Attack getAttackType(AType type)
    {
        if(type == ICE) return new Attack((Texture)Main.manager.get("jeg30.png"),100,34,32,getSpecial(ICE));
        if(type == BASIC) return new Attack((Texture)Main.manager.get("magus2.png"),33,15,34,getSpecial(BASIC));
        return null;
    }
    public Special getSpecial(AType type)
    {
        //TODO SPECIÁLOK LEIRÁSA
        Special spec = new Special();
        if(type == ICE) {
            spec.AddSpecial(Special.SpecialTypes.SLOW,10);
        }
        return spec;
    }
}
