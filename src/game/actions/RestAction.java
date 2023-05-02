package game.actions;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;
import game.reset.ResetManager;
import game.reset.ResetType;

/**
 * The rest action that players can choose at the Site of Lost Grace
 *
 * @version 1.0
 */
public class RestAction extends Action {
    /**
     * When the player rests, the game resets
     *
     * @param actor The actor performing the action.
     * @param map   The map the actor is on.
     * @return
     */
    @Override
    public String execute(Actor actor, GameMap map) {
        ResetManager.getInstance().run(ResetType.RESET_ON_REST, map);
        return menuDescription(actor);
    }

    /**
     * Menu description of the action
     *
     * @param actor The actor performing the action.
     * @return a description describing the action
     */
    @Override
    public String menuDescription(Actor actor) {
        return String.format("%s rests", actor);
    }
}
