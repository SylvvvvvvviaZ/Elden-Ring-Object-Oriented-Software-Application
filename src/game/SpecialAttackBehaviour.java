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

    public SpecialAttackBehaviour() {

    }

    /**
     * Determines whether the special attack exists or should be executed
     * 
     * @param actor the actor who is attempting to use the special attack
     * @param map   the game map
     * @return the attack action to be carried out, or null if
     */
    @Override
    public Action getAction(Actor actor, GameMap map) {
        Weapon actorWeapon; 
        if (!actor.getWeaponInventory().isEmpty()) {
            actorWeapon = actor.getWeaponInventory().get(0);
            if (actorWeapon.getSkill(actor) != null) {
                return actorWeapon.getSkill(actor);
            }
        } else {
            actorWeapon = actor.getIntrinsicWeapon();
        } 

        List<SpecialAttackType> specialAttacks = actor.findCapabilitiesByType(SpecialAttackType.class);
        if (!specialAttacks.isEmpty()) {
            Action specialAttackAction = null;

            SpecialAttackType specialAttackType = specialAttacks.get(0);
            switch (specialAttackType) {
                case SLAM -> {
                    specialAttackAction = new SlamAttack(actorWeapon);
                }
            }

//            try {
//                if (RandomNumberGenerator.getRandomInt(0, 100) <= 50) {
//                    Action specialAttackAction = specialAttacks.get(0).getSpecialAttack().getConstructor()
//                            .newInstance();
//                    return specialAttackAction;
//                }
//            } catch (Exception e) {
//                throw new RuntimeErrorException(null);
//            }
        }
        return new AttackAction(actor, null, null)
    }
}
