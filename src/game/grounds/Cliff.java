package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import game.Status;

public class Cliff extends Ground {
    public Cliff() {super('+');
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        return false;
    }
}
