package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import game.weapons.Club;

/**
 * Class representing the Player. It implements the Resettable interface.
 * It carries around a club to attack a hostile creature in the Lands Between.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class Player extends Actor implements Resettable {

	private final Menu menu = new Menu();

	private static Player instance;

	public static Player getInstance() {
		return instance;
	}

	/**
	 * Constructor.
	 *
	 * @param name        Name to call the player in the UI
	 * @param displayChar Character to represent the player in the UI
	 * @param hitPoints   Player's starting number of hitpoints
	 */
	public Player(String name, char displayChar, int hitPoints) {
		super(name, displayChar, hitPoints);
		this.addCapability(Status.HOSTILE_TO_ENEMY);
		this.addWeaponToInventory(new Club());
		instance = this;
		// Add the Flask of Crimson Tears
		FlaskOfCrimsonTears flaskOfCrimsonTears = new FlaskOfCrimsonTears();
		addItemToInventory(flaskOfCrimsonTears);
		ResetManager.getInstance().registerResettable(flaskOfCrimsonTears);
	}

	/**
	* Returns a list of allowable actions for the Player based on their inventory, location and other factors.
	* @param actions The list of allowable actions for the Player to be modified and returned.
	* @param lastAction The last action performed by the player, if any.
	* @param map The map containing the Player.
	* @param display The Display where the map is drawn.
	* @return an Action representing the Player's action for this turn.
	*/

	@Override
	public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
		// Handle multi-turn Actions
		if (lastAction.getNextAction() != null)
			return lastAction.getNextAction();

		// return/print the console menu
		return menu.showMenu(this, actions, display);
	}
	/**
	* Resets the player's state.
	*/
	@Override
	public void reset(ResetType resetType) {
		
	}
}
