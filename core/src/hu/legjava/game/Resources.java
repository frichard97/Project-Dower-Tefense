package hu.legjava.game;

import hu.legjava.game.Types.AType;

import java.util.ArrayList;
import java.util.HashMap;

import static hu.legjava.game.Types.AType.ICE;

public class Resources {
    HashMap<AType,Integer> max;
    HashMap<AType,Integer> hasznalt;
    int gold = 0;

    public Resources()
    {
        max = new HashMap<AType, Integer>();
        hasznalt = new HashMap<AType, Integer>();
        //TODO RESOURCES TEST
        addResources(ICE,10);
        System.out.println("RESOURCE TEST");
        System.out.println(felhasznal(ICE,3)); //TRUE
        System.out.println(felhasznal(ICE,3)); //TRUE
        System.out.println(felhasznal(ICE,3)); //TRUE
        System.out.println(felhasznal(ICE,3)); // FALSE
        System.out.println(getResorces(ICE)+"   "+getCurrent(ICE)); // 10  1
        System.out.println("RESOURCE TEST END");

    }
    public int getResorces(AType type)
    {
        Integer a = max.get(type);
        if(a != null) {
            return a;
        }
        return 0;
    }
    public void addResources(AType type,Integer value)
    {
        max.put(type,value);
        if(hasznalt.get(type) == null) {
            hasznalt.put(type, 0);
        }
    }
    public Integer getCurrent(AType type)
    {
        if(max.get(type) != null) {
            return max.get(type) - hasznalt.get(type);
        }
        return 0;
    }
    public boolean felhasznal(AType type, Integer value)
    {
        Integer elozo = hasznalt.get(type);
        if(elozo == null)
        {
            elozo = 0;
        }
        Integer current = elozo+value;
        if(max.get(type) > current)
        {
            hasznalt.put(type,current);
            return true;
        }
        return false;
    }
}
