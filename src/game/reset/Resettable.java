package game.reset;

import edu.monash.fit2099.engine.positions.GameMap;

/**
 * A resettable interface
 * Created by:
 *
 * @author Adrian Kristanto
 * Modified by:
 */
public interface Resettable {
    /**
     * Implementation of game reset
     *
     * @param resetType the type of reset
     * @param gameMap   the game map
     */
    void reset(ResetType resetType, GameMap gameMap);
}
