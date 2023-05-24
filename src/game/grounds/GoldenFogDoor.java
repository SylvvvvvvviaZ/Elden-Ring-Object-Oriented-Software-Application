package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.Ground;
import game.Player;
import game.Status;

public class GoldenFogDoor extends Ground {
    public GoldenFogDoor() {super('D');
    }

    @Override
    public boolean canActorEnter(Actor actor) {
        // Only the player can enter the golden fog door
        return actor instanceof Player;
    }

    @Override
    public boolean blocksThrownObjects() {
        // The golden fog door blocks thrown objects
        return true;
    }

}
