package game;

import edu.monash.fit2099.engine.items.Item;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.GroundFactory;
import edu.monash.fit2099.engine.positions.Location;

import java.io.IOException;
import java.util.List;

public class ResettableGameMap extends GameMap implements Resettable {
    public ResettableGameMap(GroundFactory groundFactory, char groundChar, int width, int height) {
        super(groundFactory, groundChar, width, height);
    }

    public ResettableGameMap(GroundFactory groundFactory, List<String> lines) {
        super(groundFactory, lines);
    }

    public ResettableGameMap(GroundFactory groundFactory, String mapFile) throws IOException {
        super(groundFactory, mapFile);
    }


    @Override
    public void reset(ResetType resetType) {
        // Iterates through the Actor locations to remove the ones needed for reset
        while (actorLocations.iterator().hasNext()) {
            if (actorLocations.iterator().next().hasCapability(resetType)) {
                removeActor(actorLocations.iterator().next());
            }
        }
        // Go through each location on the map to remove the items that need to be reset
        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[x].length; y++) {
                for (Item item : map[x][y].getItems()) {
                    if (item.hasCapability(resetType)) {
                        map[x][y].removeItem(item);
                    }
                }
            }
        }
    }
}
