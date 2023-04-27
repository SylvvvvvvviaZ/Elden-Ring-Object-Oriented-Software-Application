package game.grounds;

import edu.monash.fit2099.engine.positions.Ground;
import edu.monash.fit2099.engine.positions.Location;
import game.MapArea;
import game.interfaces.EnemyFactory;

public abstract class Environment extends Ground {
    protected EnemyFactory enemyFactory;
    /**
     * Constructor.
     *
     * @param displayChar character to display for this type of terrain
     */
    public Environment(char displayChar, EnemyFactory enemyFactory) {
        super(displayChar);
        this.enemyFactory = enemyFactory;
    }

    abstract void spawn(Location location);
}
