package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import game.reset.ResetManager;

import static game.reset.ResetType.RESET_ON_DEATH;

public class Cliff extends Ground {
    public Cliff() {super('+');
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        return actor.hasCapability(RESET_ON_DEATH);
    }
}

