package hu.legjava.game.Objects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.*;
import hu.legjava.game.Main;
import hu.legjava.game.Net.Events;
import hu.legjava.game.Types.ObjectTypes;

import static hu.legjava.game.Main.PPM;

public class BaseTower extends Tower {
    private Sprite baseTower;
    private Body body;
    public BaseTower(World world, float x, float y) {
        super(ObjectTypes.BASE, x, y);
        baseTower = new Sprite((Texture)Main.manager.get("base.png"));
        baseTower.setBounds(x,y,baseTower.getWidth()/PPM,baseTower.getHeight()/PPM);
        /***********************************ENGINE***************************/
        BodyDef bdef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fdef = new FixtureDef();
        bdef.type = BodyDef.BodyType.StaticBody;
        bdef.position.set(x+baseTower.getWidth()/2,y+baseTower.getHeight()/2);
        body = world.createBody(bdef);
        shape.setAsBox(baseTower.getWidth()/2,baseTower.getHeight()/2);
        fdef.shape = shape;
        body.createFixture(fdef);
    }

    @Override
    protected void update(float s) {
        super.update(s);
    }

    @Override
    protected void draw(SpriteBatch batch) {
        baseTower.draw(batch);
    }

    @Override
    protected Events event() {
        return super.event();
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
