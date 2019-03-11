package hu.legjava.game.Types;

import com.badlogic.gdx.scenes.scene2d.Actor;
import hu.legjava.game.ATowerUpgrade;
import hu.legjava.game.Main;

public enum ObjectTypes {
    WALL,
    ATTACKTOWER,
    RESOURCETOWER,
    BASE;
    public static Actor getMENU(ObjectTypes type)
    {
        if(type == ATTACKTOWER) {
            return new ATowerUpgrade("Upgrade", Main.getSkin());
        }
        return null;
    }
}

