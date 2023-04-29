package game.behaviours;

import java.util.List;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.weapons.Weapon;
import game.RandomNumberGenerator;
import game.SlamAttackAction;
import game.SpecialAttackType;
import game.actions.AttackAction;

/**
 * Behaviour that handles actors that have special attack skills
 * 
 * @version 1.0
 */
public class SpecialAttackBehaviour implements Behaviour {
    private Actor target;

     public SpecialAttackBehaviour(Actor target) {
         this.target = target;
     }

    /**
     * Determines whether the special attack exists or should be executed
     * 
     * @param actor the actor who is attempting to use the special attack
     * @param map   the game map
     * @return the attack action to be carried out, or a standard attack action if no special attack action is available
     */
    
    @Override
    public Action getAction(Actor actor, GameMap map) {
        // Get the weapon or intrinsic weapon from the actor
        Weapon actorWeapon = null;
        // Check whether weapon from the actor has any special skill
        if (!actor.getWeaponInventory().isEmpty()) {
            actorWeapon = actor.getWeaponInventory().get(0);
            if (actorWeapon.getSkill(actor) != null) {
                // Enemy uses special weapon skill with 50% chance
                if (RandomNumberGenerator.getRandomInt(0, 100) <= 50)
                    return actorWeapon.getSkill(actor);
            }
        }
        // Get the capabilities from the actor
        List<SpecialAttackType> specialAttacks = actor.findCapabilitiesByType(SpecialAttackType.class);
        if (!specialAttacks.isEmpty()) {
            // Get the first actor special attack
            SpecialAttackType specialAttackType = specialAttacks.get(0);
            // Return the appropriate special attack action
            return specialAttackType.getSpecialAttack(actorWeapon);
        }
        // If no special attacks found, return normal attack action
        if (actorWeapon == null) {
            return new AttackAction(target, null);
        } else {
            return new AttackAction(target, null, actorWeapon);
        }
    }
}
