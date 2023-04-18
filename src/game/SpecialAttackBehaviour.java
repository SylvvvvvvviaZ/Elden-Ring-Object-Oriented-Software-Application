package game;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.management.RuntimeErrorException;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;

/**
 * Behaviour that handles actors that have special attack skills
 * 
 * @version 1.0
 */
public class SpecialAttackBehaviour implements Behaviour {

    // public SpecialAttackBehaviour() {}

    /**
     * Determines whether the special attack exists or should be executed
     * 
     * @param actor the actor who is attempting to use the special attack
     * @param map   the game map
     * @return the attack action to be carried out, or null if
     */
    
    @Override
    public Action getAction(Actor actor, GameMap map) {
        // Get the weapon or intrinsic weapon from the actor
        Weapon actorWeapon; 
        // Check whether weapon from the actor has any special skill
        if (!actor.getWeaponInventory().isEmpty()) {
            actorWeapon = actor.getWeaponInventory().get(0);
            if (actorWeapon.getSkill(actor) != null) {
                return actorWeapon.getSkill(actor);
            }
        } else {
            actorWeapon = actor.getIntrinsicWeapon();
        } 
        // Get the capabilities from the actor
        List<SpecialAttackType> specialAttacks = actor.findCapabilitiesByType(SpecialAttackType.class);
        if (!specialAttacks.isEmpty()) {
            // Action specialAttackAction = null
            SpecialAttackType specialAttackType = specialAttacks.get(0);
            // Return the appropriate special attack action
            switch (specialAttackType) {
                case SLAM -> {
                    return new SlamAttack(actorWeapon);
                }
            }
        }
        // If no special attacks found, return normal attack action
        return new AttackAction(actor, null, actorWeapon);
    }
}
