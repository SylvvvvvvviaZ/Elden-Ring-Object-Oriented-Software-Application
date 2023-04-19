package game.behaviours;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public class ConsumeBehaviour implements Behaviour {
  private int maxUses;
  private int useCount;

    /**
    * Constructs a new ConsumeBehaviour.
    * @param maxUses the maximum number of uses for this behaviour
    */    
  public ConsumeBehaviour(int maxUses) {
    this.maxUses = maxUses;
    this.useCount = 0;
  }
    
    /**
    * If the action has not yet reached its maximum number of uses,
    * it returns a new ConsumeAction. Otherwise, it returns null.
    * @param actor the actor performing the action
    * @param map the gamemap where the action is performed
    * @return a new ConsumeAction if the action has not yet reached its maximum number of uses, otherwise null
    */
  @Override
  public Action getAction(Actor actor, GameMap map) {
   if (useCount < maxUses) {
    // The action has not yet reached its max no. of uses
    
   }
    useCount += 1;
    return null;
  }
}
