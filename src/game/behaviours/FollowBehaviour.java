package game.behaviours;

import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.positions.Exit;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import game.Status;

/**
 * A class that figures out a MoveAction that will move the actor one step 
 * closer to a target Actor.
 * @see edu.monash.fit2099.demo.mars.Application
 *
 * @author Riordan D. Alfredo, modified by dkon0020
 *
 */
public class FollowBehaviour implements Behaviour {

	private final Actor target;

	/**
	 * Constructor.
	 * 
	 * @param subject the Actor to follow
	 */
	public FollowBehaviour(Actor subject) {
		this.target = subject;
	}

	@Override
	public Action getAction(Actor actor, GameMap map) {
		if(!map.contains(target) || !map.contains(actor)) {
			// If following is no longer possible, remove the status in case the actor used to be following the player
			actor.removeCapability(Status.FOLLOWING_PLAYER);
			return null;
		}
		
		Location here = map.locationOf(actor);
		Location there = map.locationOf(target);

		int currentDistance = distance(here, there);
		for (Exit exit : here.getExits()) {
			Location destination = exit.getDestination();
			if (destination.canActorEnter(actor)) {
				int newDistance = distance(destination, there);
				if (newDistance < currentDistance) {
					// Add the following-player status if the target to follow is a player
					if (target.hasCapability(Status.HOSTILE_TO_ENEMY))
						actor.addCapability(Status.FOLLOWING_PLAYER);
					return new MoveActorAction(destination, exit.getName());
				}
			}
		}

		// If following is no longer possible, remove the status in case the actor used to be following the player
		actor.removeCapability(Status.FOLLOWING_PLAYER);
		return null;
	}

	/**
	 * Compute the Manhattan distance between two locations.
	 * 
	 * @param a the first location
	 * @param b the first location
	 * @return the number of steps between a and b if you only move in the four cardinal directions.
	 */
	private int distance(Location a, Location b) {
		return Math.abs(a.x() - b.x()) + Math.abs(a.y() - b.y());
	}
}