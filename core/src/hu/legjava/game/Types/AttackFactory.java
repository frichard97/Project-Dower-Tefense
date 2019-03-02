package hu.legjava.game.Types;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;

import static hu.legjava.game.Types.AType.*;

public class AttackFactory {
    public static Attack getAttackType(AType type)
    {
        if(type == ICE) return new Ice(new Sprite(new Texture("ice.png")),100,45); //TODO SPECIAL FACOTRY ATTACK HELYETT
        return null;
    }
}
