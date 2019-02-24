package hu.legjava.game.Net;

import hu.legjava.game.VDat;

import java.util.ArrayList;
import java.util.List;

public abstract class Net {
    List<VDat> dat;
    public abstract void Send(Events event);
    public void InitList(List<VDat> dat)
    {
        this.dat = dat;
    }
}
