package game;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.items.DropAction;
import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import game.actions.ConsumeAction;
import game.interfaces.Consumable;

/**
 * The Flask of Crimson Tears item that is always carried by the player and can be used to heal the player
 *
 * @version 1.0
 */
public class FlaskOfCrimsonTears extends Item implements Resettable, Consumable {
    private int noOfUses;
    private ConsumeAction action;

    /**
     * Constructor
     */
    public FlaskOfCrimsonTears() {
        super("Flask of Crimson Tears", ' ', true);
        this.action = new ConsumeAction(this);
        addAction(action);
    }

    /**
     * The Flask of Crimson Tears' effect(s) on the actor
     *
     * @param actor the actor who is consuming the item
     */
    @Override
    public void consume(Actor actor) {
        // The Flask of Crimson Tears heals the player with 250 HPs
        actor.heal(250);
        // Increment the no. of uses
        noOfUses += 1;
        // If the uses has exceeded the maximum, remove the action so it cannot be selected
        if (useCount() >= maxUseCount()) {
            removeAction(action);
        }
    }

    @Override
    public int useCount() {
        return noOfUses;
    }

    @Override
    public int maxUseCount() {
        return 2;
    }

    /**
     * The Flask of Crimson Tears cannot be dropped
     *
     * @param actor the actor holding the item
     * @return null
     */
    @Override
    public DropAction getDropAction(Actor actor) {
        return null;
    }

    /**
     * Reset the number of uses for the item
     */
    @Override
    public void reset(ResetType resetType, GameMap gameMap) {
        // If the player had previously used up the Flask, re-add the consume action
        if (noOfUses >= maxUseCount()) addAction(action);
        // Reset no. of uses
        noOfUses = 0;
    }
}
