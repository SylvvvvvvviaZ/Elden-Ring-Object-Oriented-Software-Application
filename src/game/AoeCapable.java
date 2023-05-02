package game;

import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;

import java.util.ArrayList;
import java.util.List;

/**
 * Interface for actions that utilise AOE-based actions
 *
 * @author dkon0020
 * @version 1.0
 */
public interface AoeCapable {
    /**
     * Get the valid locations of the surrounding 8 locations (is within the map, has actor)
     *
     * @param map             the game map
     * @param currentLocation the location to get surroundings from
     * @return the list of valid locations in the surroundings
     */
    default List<Location> getSurroundingLocations(GameMap map, Location currentLocation) {
        List<Location> surroundingLocations = new ArrayList<>(8);
        for (int xOffset = -1; xOffset <= 1; xOffset++) {
            for (int yOffset = -1; yOffset <= 1; yOffset++) {
                // Don't add the location of myself
                if (xOffset == 0 && yOffset == 0) {
                    continue;
                }
                if (!map.getXRange().contains(currentLocation.x() + xOffset) || !map.getYRange().contains(currentLocation.y() + yOffset)) {
                    continue;
                }
                surroundingLocations.add(map.at(currentLocation.x() + xOffset, currentLocation.y() + yOffset));
            }
        }
        return surroundingLocations;
    }

    /**
     * Get the string description of the direction of the target location from the current location
     *
     * @param currentLocation the current location
     * @param targetLocation  the target location
     * @return a string description of the direction of the target
     */
    default String getDirection(Location currentLocation, Location targetLocation) {
        int xOffset = targetLocation.x() - currentLocation.x();
        int yOffset = targetLocation.y() - currentLocation.y();
        String direction = "";
        direction += switch (yOffset) {
            case -1 -> "north";
            case 1 -> "south";
            default -> "";
        };
        direction += switch (xOffset) {
            case -1 -> "west";
            case 1 -> "east";
            default -> "";
        };
        return direction;
    }
}
