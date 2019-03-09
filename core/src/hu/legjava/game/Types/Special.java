package hu.legjava.game.Types;
import java.util.HashMap;
import java.util.Map;

public class Special {
    //TODO ezeket kell kibővíteni a többi hatással
    public enum SpecialTypes{
        SLOW,
        IGNITE,
        HEAL,
        SPAWN,
    }
    Map<SpecialTypes,Float> specials;
    public Special()
    {
        specials = new HashMap<SpecialTypes, Float>();
    }
    public void AddSpecial(SpecialTypes type,float value)
    {
        specials.put(type,value);
    }
    public float getSpecial(SpecialTypes type)
    {
        Float return_value = specials.get(type);
        if(return_value != null) {
            return specials.get(type);
        }
        return 0;
    }
}
