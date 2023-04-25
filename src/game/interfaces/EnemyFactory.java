package game.interfaces;

import edu.monash.fit2099.engine.positions.GameMap;

/**
 * Interface for generating enemies on different maps
 */
public interface EnemyFactory {
    /**
     * Generate Skeletal-type enemies
     *
     * @param gameMap the game map to generate the enemies
     */
    void generateSkeletal(GameMap gameMap);

    /**
     * Generate Canine-type enemies
     *
     * @param gameMap the game map to generate the enemies
     */
    void generateCanine(GameMap gameMap);

    /**
     * Generate Crustacean-type enemies
     *
     * @param gameMap the game map to generate the enemies
     */
    void generateCrustacean(GameMap gameMap);
}
