package game;

import java.util.ArrayList;
import java.util.List;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.Weapon;

public class AreaAttackAction extends AttackAction {

    public AreaAttackAction(Actor target, String direction, Weapon weapon) {
        super(target, direction, weapon);
    }

    @Override
    public String execute(Actor actor, GameMap map) {
        List<Actor> targets = new ArrayList<>();
        targets.add(target);
        Location here = target.location();
        for (int x = -1; x <= 1; x++){
            for (int y = -1; y <= 1; y++){
                if (x == 0 && y == 0){
                    continue;
                }
                Location loc = here.add(x, y);
                if (map.isWalkable(loc)){
                    targets.add(map.getActor(loc));
                }
            }


        }

    }
}
