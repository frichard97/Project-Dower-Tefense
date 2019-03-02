package hu.legjava.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import hu.legjava.game.Net.Events;
import hu.legjava.game.Net.Net;

import java.util.ArrayList;
import java.util.List;

import static hu.legjava.game.Main.STATES.*;

public class Controller {
    private List<VDat> dat = new ArrayList<VDat>();
    Net net;
    OrthographicCamera cam;
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
        //TODO LOCALPLAYER
        //TODO Felhasználó HUD inicializálás
        //TODO Input kezelés definiálása
    }
    public void Send(Events event){net.Send(event);}
    public List<VDat> getSprites(){return dat;}
    public void update(float delta){
        for(VDat dat: dat)
        {
            if(Main.state == SINGLEPLAYER)
            {
                dat.update(delta);
            }
            if(Main.state == CLIENT)
            {
                if(dat.local)net.Send(dat.pull());

            }
        }
        //TODO JÁTÉKMENET
    }
}
