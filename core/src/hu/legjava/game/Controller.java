package hu.legjava.game;

import com.badlogic.gdx.graphics.OrthographicCamera;
import hu.legjava.game.Net.Events;
import hu.legjava.game.Net.Net;

import java.util.ArrayList;
import java.util.List;

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
        //TODO JÁTÉKMENET
    }
}
