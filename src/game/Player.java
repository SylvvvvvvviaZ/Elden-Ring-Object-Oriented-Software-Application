package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actions.ActionList;
import edu.monash.fit2099.engine.actions.MoveActorAction;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.displays.Menu;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.weapons.IntrinsicWeapon;
import game.archetypes.CombatArchetype;
import game.weapons.Club;
import jdk.jshell.execution.LocalExecutionControl;

import java.util.ArrayList;

/**
 * Class representing the Player. It implements the Resettable interface.
 * It carries around a club to attack a hostile creature in the Lands Between.
 * Created by:
 *
 * @author Adrian Kristanto
 * Modified by:
 */
public class Player extends Actor implements Resettable {

    private final Menu menu = new Menu();

    private final ArrayList<Location> siteOfLostGraceVisits = new ArrayList<>();

    private final ArrayList<Location> locationHistory = new ArrayList<>();
    private final RuneManager runeManager;
    /**
     * Constructor.
     *
     * @param name              Name to call the player in the UI
     * @param displayChar       Character to represent the player in the UI
     * @param hitPoints         Player's starting number of hitpoints
     * @param resetManager      the reset manager
     * @param firstStepLocation the location of the First Step (of Site of Lost Grace)
     */
    public Player(String name, char displayChar, int hitPoints, ResetManager resetManager, Location firstStepLocation, RuneManager runeManager, Display display) {
        super(name, displayChar, hitPoints);
        this.addCapability(Status.HOSTILE_TO_ENEMY);
//        this.addWeaponToInventory(new Club());
        this.runeManager = runeManager;

        // Ask for Combat Archetype
        CombatArchetype archetype = CombatArchetype.askForClass(display);
        while (archetype == null) {
            archetype = CombatArchetype.askForClass(display);
        }
        // Set Combat Archetype
        addWeaponToInventory(archetype.getStartingWeapon());
        resetMaxHp(archetype.getStartingHitPoints());

        // Add the Flask of Crimson Tears
        FlaskOfCrimsonTears flaskOfCrimsonTears = new FlaskOfCrimsonTears();
        addItemToInventory(flaskOfCrimsonTears);
        resetManager.registerResettable(flaskOfCrimsonTears);
        siteOfLostGraceVisits.add(firstStepLocation);
    }

    /**
     * Returns a list of allowable actions for the Player based on their inventory, location and other factors.
     *
     * @param actions    The list of allowable actions for the Player to be modified and returned.
     * @param lastAction The last action performed by the player, if any.
     * @param map        The map containing the Player.
     * @param display    The Display where the map is drawn.
     * @return an Action representing the Player's action for this turn.
     */

    @Override
    public Action playTurn(ActionList actions, Action lastAction, GameMap map, Display display) {
        // Print the player's stats
        display.println(String.format("%s %s, runes: %d", this, printHp(), runeManager.getBalance(this)));
        // Add the locations the player has moved through to a list called locationHistory
        locationHistory.add(map.locationOf(this));

        // Check whether the player has visited a Site of Lost Grace
        if (map.locationOf(this).getGround().hasCapability(Status.RESPAWN_POINT)) {
            siteOfLostGraceVisits.add(map.locationOf(this));
        }
        // Handle multi-turn Actions
        if (lastAction.getNextAction() != null)
            return lastAction.getNextAction();

        // return/print the console menu
        return menu.showMenu(this, actions, display);
    }

    /**
     * Player gets their HP reset upon any reset
     * If ResetType is RESET_ON_REST, the player is resting and their health is restored to the maximum.
     * If ResetType is not RESET_ON_REST, the player has died and is removed from their current location on the game map
     *
     * @param resetType the type of reset (RESET_ON_REST or RESET_ON_DEATH)
     * @param gameMap the game map the player is on
     */
    @Override
    public void reset(ResetType resetType, GameMap gameMap) {
        heal(getMaxHp());
        if (resetType == ResetType.RESET_ON_DEATH) {
            // The player has died
            // Tell the Rune Manager to drop the Player's money on the location they were at before this turn
            RuneManager.getInstance().resetActor(this, locationHistory.get(locationHistory.size() - 2));
            // Get respawn point (last Site of Lost Grace visited by the player)
            Location respawnPoint = siteOfLostGraceVisits.get(siteOfLostGraceVisits.size() - 1);
            gameMap.moveActor(this, respawnPoint);
//            gameMap.removeActor(this);
//            // add to the last Site of Lost Grace visited by the player
//            gameMap.addActor(this, respawnPoint);
        }
    }

    @Override
    public IntrinsicWeapon getIntrinsicWeapon() {
        return new IntrinsicWeapon(11, "punches");
    }
}
