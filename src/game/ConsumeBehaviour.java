package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.positions.GameMap;

public class ConsumeBehaviour implements Behaviour {
  private int maxUses;
  private int useCount;

  public ConsumeBehaviour(int maxUses) {
    this.maxUses = maxUses;
    this.useCount = 0;
  }

  @Override
  public Action getAction(Actor actor, GameMap map) {
   if (useCount < maxUses) {
    // The action has not yet reached its max no. of uses
    
   }
    useCount += 1;
    return null;
  }
}
