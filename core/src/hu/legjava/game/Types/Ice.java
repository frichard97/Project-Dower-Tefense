package hu.legjava.game.Types;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Ice extends Attack {
    public Ice(Sprite sprite,float aoe,float dmg) {
        super(sprite, aoe,dmg);
    }

    @Override
    public void draw(SpriteBatch batch) {

    }
}
