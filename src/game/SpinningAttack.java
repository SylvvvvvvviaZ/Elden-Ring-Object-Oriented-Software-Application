/*
A special action that allows an actor to perform an area attack on multiple targets around them using a weapon.
*/

package game;

import java.util.ArrayList;
import java.util.List;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.core.ActorLocations;
import edu.monash.fit2099.engine.core.Location;
import edu.monash.fit2099.engine.core.Map;
import edu.monash.fit2099.engine.items.Weapon;

/*
Constructor.
@param target - the target actor to attack
@param direction - the direction of the attack
@param weapon - the weapon used to perform the attack
*/

public class SpinningAttack extends AreaAttackAction {

    public SpinningAttack(Actor target, String direction, Weapon weapon) {
        super(target, direction, weapon);
    }

    /*
    Executes the spinning attack action by finding all the targets around the actor, performing the attack on each target,
    and returning the result of the action as a string.
    @param actor - the actor performing the spinning attack
    @param map - the game map
    @return a string containing the result of the spinning attack action
    */

    @Override
    public String execute(Actor actor, Map map) {
        List<Actor> targets = new ArrayList<>();
        targets.add(target);

        ActorLocations actorLocations = map.locations();
        Location here = actorLocations.locationOf(actor);

        for (int x = -1; x <= 1; x++){
            for (int y = -1; y <= 1; y++){
                if (x == 0 && y == 0){
                    continue;
                }
                Location loc = actorLocations.at(here.x() + x, here.y() + y);
                if (loc != null && loc.canActorEnter(actor)){
                    targets.addAll(loc.getActors());
                }
            }
        }

        StringBuilder result = new StringBuilder(super.execute(actor, map));

        for (Actor target : targets){
            if (target != actor && weapon.makesAttack()) {
                int damage = weapon.damage();
                target.hurt(damage);
                result.append(System.lineSeparator());
                result.append(actor + " " + weapon.verb() + " " + target + " for " + damage + " damage.");
                if (!target.isConscious()){
                    result.append(System.lineSeparator());
                    result.append(target + " is knocked out.");
                }
            }
        }

        return result.toString();
    }
}
