package game.grounds;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.capabilities.CapabilitySet;
import edu.monash.fit2099.engine.positions.Ground;

import static game.reset.ResetType.RESET_ON_DEATH;

/**
 * A class representing a cliff in the game world.
 * Cliffs are represented by the symbol '+' and can cause instant death to the player character if stepped on.
 * Player characters with the RESET_ON_DEATH capability can enter and traverse cliffs.
 */

public class Cliff extends Ground {
    private final CapabilitySet capabilities;

    /**
     * Constructor for the Cliff class.
     * Initializes the cliff with the symbol '+'.
     */

    public Cliff() {
        super('+');
        capabilities = new CapabilitySet();
    }

    /**
     * Constructor add Capability for the Cliff.
     */
    
    public void addCapability(Enum<?> capability) {
        capabilities.addCapability(capability);
    }

    /**
     * Checks whether an actor can enter and traverse the cliff.
     * Only actors with the RESET_ON_DEATH capability can enter cliffs.
     *
     * @param actor the actor to check
     * @return true if the actor has the RESET_ON_DEATH capability, false otherwise
     */
    @Override
    public boolean canActorEnter(Actor actor) {
        return actor.hasCapability(RESET_ON_DEATH);
    }
}

