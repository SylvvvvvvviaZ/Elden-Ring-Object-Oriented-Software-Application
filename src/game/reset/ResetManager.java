package game.reset;

import edu.monash.fit2099.engine.positions.GameMap;
import game.FancyMessage;

import java.util.ArrayList;
import java.util.List;

/**
 * A reset manager class that manages a list of resettables.
 * Created by:
 *
 * @author Adrian Kristanto
 * Modified by:
 */
public class ResetManager {
    //    private GameMap gameMap;
    private List<Resettable> resettables;
    private static ResetManager instance;

//    /**
//     * Gets an instance of the reset manager
//     *
//     * @param gameMap the game map
//     * @return instance of reset manager
//     */
//    public static ResetManager getInstance(GameMap gameMap) {
//        if (instance == null) instance = new ResetManager(gameMap);
//        return instance;
//    }

    /**
     * Gets the instance of the reset manager
     *
     * @return instance of reset manager
     */
    public static ResetManager getInstance() {
        if (instance == null) instance = new ResetManager();
        return instance;
    }

    /**
     * Constructor
     */
    private ResetManager(/* GameMap gameMap */) {
//        this.gameMap = gameMap;
        this.resettables = new ArrayList<>();
    }

    /**
     * Calls each resettable item to reset
     *
     * @param resetType the type of reset to do
     * @param gameMap   the game map
     */
    public void run(ResetType resetType, GameMap gameMap) {
        if (resetType == ResetType.RESET_ON_DEATH) System.out.println(FancyMessage.YOU_DIED);
        // Make list of resettable items before initiating reset
        ArrayList<Resettable> resetItems = new ArrayList<>(resettables.size());
        resetItems.addAll(resettables);
        for (Resettable resettable : resetItems) {
            resettable.reset(resetType, gameMap);
        }
    }

    public void registerResettable(Resettable resettable) {
        resettables.add(resettable);
    }

    public void removeResettable(Resettable resettable) {
        resettables.remove(resettable);
    }
}
