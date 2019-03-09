package hu.legjava.game.Types;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import static hu.legjava.game.Types.AType.*;

public class AttackFactory {
    public static Attack getAttackType(AType type)
    {
        if(type == ICE) return new Attack(new Sprite(new Texture("magus2.png")),100,45,getSpecial(ICE));
        if(type == BASIC) return new Attack(new Sprite(new Texture("magus2.png")),0,10,getSpecial(BASIC));
        return null;
    }
    public static Special getSpecial(AType type)
    {
        //TODO SPECIÁLOK LEIRÁSA
        Special spec = new Special();
        if(type == ICE) {
            spec.AddSpecial(Special.SpecialTypes.SLOW,10);
        }
        return spec;
    }
}
