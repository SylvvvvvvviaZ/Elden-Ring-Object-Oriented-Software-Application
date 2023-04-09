package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;

public class GiantCrab extends Actor {
    public GiantCrab() {
        super("Giant Crab", 'C', 407);
    }
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {

        return null;
    }

    /**
     * 'Slams' other creatures, including the player, dealing 208 damage with 90% attack accuracy
     * @return the 'slam' intrinsic weapon
     */
    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(208, "slams", 90);
    }
}