package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * Great Knife weapon item
 * @version 1.0
 */
public class GreatKnife extends WeaponItem {
    /**
     * Constructor
     */
    public GreatKnife() {
        super("Great Knife", '/', 75, "slashes", 70);
    }

    /**
     * Gets the Great Knife's skill: QuickStep
     * @return the QuickStep action
     */
    @Override
    public Action getSkill(Actor target, String direction) {
       return new QuickStepAction();
    }
}
