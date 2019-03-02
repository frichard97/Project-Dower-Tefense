package hu.legjava.game.Objects;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.*;
import hu.legjava.game.Net.Events;
import hu.legjava.game.VDat;

import static hu.legjava.game.Main.PPM;

public class Player  extends VDat {
    private OrthographicCamera cam;
    private Body body;
    private float speed = 4f;

    public Player(World world, boolean local, OrthographicCamera cam)
    {
        x = 10;
        y = 10;
        this.local = local;
        this.cam = cam;
        BodyDef bdef = new BodyDef();
        PolygonShape shape = new PolygonShape();
        FixtureDef fdef = new FixtureDef();
        bdef.type = BodyDef.BodyType.DynamicBody;
        bdef.position.set(x/PPM,y/PPM);
        body = world.createBody(bdef);
        shape.setAsBox(100/PPM,100/PPM);
        fdef.shape = shape;
        body.createFixture(fdef);
    }
    @Override
    protected void update(float s) {
        if(local)
        {
            input();
        }
    }
    private void input()
    {
        Vector2 pos = body.getPosition();
        Vector2 velocity = new Vector2();
        body.setLinearVelocity(0, 0);
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            velocity.x = -speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            velocity.x = speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            velocity.y = speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            velocity.y = -speed;
        }
        body.setLinearVelocity(velocity);
        x = body.getPosition().x;
        y = body.getPosition().y;


        Vector3 touch = new Vector3();
        float screenX = Gdx.input.getX();
        float screenY = Gdx.input.getY();
        cam.unproject(touch.set(screenX,screenY,0));
        double angle = 0;
        angle = Math.atan2(touch.y - y, touch.x - x);
        angle += Math.PI / 2;
        angle = Math.toDegrees(angle);

        if(angle < 0){
            angle += 360;
        }
        cam.position.x =x;
        cam.position.y = y;
        body.setTransform(pos.x, pos.y, (float) Math.toRadians(angle));
    }

    @Override
    protected void draw(SpriteBatch batch) {

    }

    @Override
    protected Events event() {
        return null;
    }
}
