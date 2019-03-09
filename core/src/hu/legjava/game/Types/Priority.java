package hu.legjava.game.Types;

import java.util.ArrayList;
import java.util.List;

public class Priority {
    private List<ObjectTypes> prio;
    public Priority(EnemyType type)
    {
        prio  = new ArrayList<ObjectTypes>();
        if(type == EnemyType.FAST)
        {
            //SZÁMÍT A SORREND
            prio.add(ObjectTypes.RESOURCETOWER);
            prio.add(ObjectTypes.ATTACKTOWER);
            prio.add(ObjectTypes.WALL);
            prio.add(ObjectTypes.BASE);
        }

    }
    public List<ObjectTypes> getPrio()
    {
        return prio;
    }
}
