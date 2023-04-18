package game;

import java.rmi.server.RMIClientSocketFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * A reset manager class that manages a list of resettables.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class ResetManager {
    private List<Resettable> resettables;
    private static ResetManager instance;

    public static ResetManager getInstance() {
        if (instance == null) instance = new ResetManager();
        return instance;
    }

    /**
     * Constructor
     */
    private ResetManager() {
        this.resettables = new ArrayList<>();
    }

    /**
     * Calls each resettable item to reset
     */
    public void run(ResetType resetType) {
        for (Resettable resettable : resettables) {
            resettable.reset(resetType);
        }
    }

    public void registerResettable(Resettable resettable) {
        resettables.add(resettable);
    }

    public void removeResettable(Resettable resettable) {
        resettables.remove(resettable);
    }
}
