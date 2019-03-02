package hu.legjava.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import hu.legjava.game.Net.Events;
import hu.legjava.game.Net.Net;
import hu.legjava.game.Objects.Player;

import java.util.ArrayList;
import java.util.List;

import static hu.legjava.game.Main.*;
import static hu.legjava.game.Main.STATES.*;

public class Controller {
    private List<VDat> dat = new ArrayList<VDat>();
    private Net net;

    public OrthographicCamera getCam() {
        return cam;
    }

    private OrthographicCamera cam;
    private World world;
    private Box2DDebugRenderer b2dr;
    private Viewport gameport;
    public Controller(Net net)
    {
        this.net = net;
        net.InitList(dat);
        init();
    }
    public Controller()
    {
        init();
    }
    private void init()
    {
        cam = new OrthographicCamera();
        gameport = new StretchViewport(GAMEWIDTH/PPM,GAMEHEIGHT/PPM,cam);
        cam.setToOrtho(false,GAMEWIDTH/PPM,GAMEHEIGHT/PPM);
        cam.zoom = 2f; //TODO NEM KELL MAJD IDE
        world = new World(new Vector2(0,0),false);
        b2dr = new Box2DDebugRenderer();
        Player player = new Player(world,true,cam);
        dat.add(player);
        //TODO Felhasználó HUD inicializálás
        //TODO Input kezelés definiálása
    }
    public void Send(Events event){net.Send(event);}
    public List<VDat> getSprites(){return dat;}
    public void update(float delta) {
        for (VDat dat : dat) {
            if (Main.state == SINGLEPLAYER) {
                dat.update(delta);
            }
            if (Main.state == CLIENT) {
                if (dat.local) net.Send(dat.pull());

            }
            world.step(delta,6,2);
            cam.update();
        }
    }
        public void renderer(SpriteBatch batch)
        {
            b2dr.render(world,cam.combined);
        }
        //TODO JÁTÉKMENET
}
