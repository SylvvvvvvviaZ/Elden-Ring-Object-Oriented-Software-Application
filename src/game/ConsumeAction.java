package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;


 /**
  * Constructs a new ConsumeAction.
  */
public class ConsumeAction extends Action {
  private Consumable item;


    /**
    * Constructs a new ConsumeAction with the specified consume item.
    * @param item the item to consume
    */
  public ConsumeAction(Consumable item) {
    this.item = item;
  }

    /**
    * Executes the ConsumeItemAction, consuming the item and returning a message describing.
    * @param actor the actor performing the action
    * @param map the gamemap where the action is performed
    * @return a message describing the action taken
    */
  @Override
  public String execute(Actor actor, GameMap map) {
     item.consume(actor);
     return menuDescription(actor);
  }

    /**
    * Returns a menu description of the ConsumeItemAction.
    * @param actor the actor performing the action
    * @return a menu description of the action
    */
  @Override
  public String menuDescription(Actor actor) {
    return String.format("%s consumes %s", actor, item);
  }
}
