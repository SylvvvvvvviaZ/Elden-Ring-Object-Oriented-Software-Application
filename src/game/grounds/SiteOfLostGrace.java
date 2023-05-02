package game.grounds;

import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.Status;
import game.actions.RestAction;

/**
 * The Site of Lost Grace ground
 */
public class SiteOfLostGrace extends Ground {

    /**
     * Constructor
     */
    public SiteOfLostGrace() {
        super('U');
        addCapability(Status.RESPAWN_POINT);
    }

    /**
     * The Site of Lost Grace allows players to rest
     * 
     * @param actor     the Actor acting
     * @param location  the current Location
     * @param direction the direction of the Ground from the Actor
     * @return
     */
    @Override
    public ActionList allowableActions(Actor actor, Location location, String direction) {
        ActionList list = new ActionList();
        if (actor.hasCapability(Status.HOSTILE_TO_ENEMY))
            list.add(new RestAction());
        return list;
    }
}
