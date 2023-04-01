package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;

import java.util.HashMap;
import java.util.Map;

public class HeavySkeletalSwordsman extends Actor {
    private Map<Integer, Behaviour> behaviours = new HashMap<>();

    public HeavySkeletalSwordsman() {
        super("Heavy Skeletal Swordsman", 'q', 153);
        this.behaviours.put(999, new WanderBehaviour());
        addWeaponToInventory(new Grossmesser());
    }
    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {

        // TODO
        return null;
    }

    // TODO: Become a 'pile of bones'
}
