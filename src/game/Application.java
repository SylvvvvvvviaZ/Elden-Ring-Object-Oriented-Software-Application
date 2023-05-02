package game;

import java.util.*;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.World;
import game.archetypes.*;
import game.factories.EastEnemyFactory;
import game.factories.WestEnemyFactory;
import game.grounds.*;
import game.traders.MerchantKale;

/**
 * The main class to start the game.
 * Created by:
 * @author Adrian Kristanto
 * Modified by:
 *
 */
public class Application {

	public static void main(String[] args) {
		Display display = new Display();

		World world = new World(display);

		FancyGroundFactory groundFactory = new FancyGroundFactory(new Dirt(), new Wall(), new Floor(), new SiteOfLostGrace());

		/*
		List<String> map = Arrays.asList(
						    10
				"..nnnn................................................~~~~~~~~~~~~~~~~~~~~~",
				"......................#####....######..................~~~~~~~~~~~~~~~~~~~~",
				"..nnnn................#..___....____#...................~~~~~~~~~~~~~~~~~~~",
				"..................................__#....................~~~~~~~~~~~~~~~~~~",
				"......................._____........#.....................~~~~~~~~~~~~~~~~~",
				"......................#............_#......................~~~~~~~~~~~~~~~~",
				"......................#...........###......................................",
				"...........................................................................",
				"...........................................................................",
			9	"~~~~~~~~~~~.......................###___###................................",
				"~~~~~~~~~~~~......................________#....nnnn........................",
				"~~~~~~~~~~~~~.....................#___U____................................",
				"~~~~~~~~~~~~......................#_______#....nnnn........................",
				"~~~~~~~~~~~.......................###___###................................",
				"~~~~~~~~~~..........................#___#..................................",
				"...........................................................................",
				"...........................................................................",
				"...........................................................................",
				"..####__##...........................................
			19	.......__.....#...",
			20	"..####__###.........&&&......................................._.....__.#...",
				"....................&&&.......................................###..__###...",
				"..........................................................................."
		);
		 */

		/*
				..nnnn................................................~~~~~~~~~~~~~~~~~~~~~
				......................#####....######..................~~~~~~~~~~~~~~~~~~~~
				..nnnn................#..___....____#...................~~~~~~~~~~~~~~~~~~~
				..................................__#....................~~~~~~~~~~~~~~~~~~
				......................._____........#.....................~~~~~~~~~~~~~~~~~
				......................#............_#......................~~~~~~~~~~~~~~~~
				......................#...........###......................................
				...........................................................................
				...........................................................................
				~~~~~~~~~~~.......................###___###................................
				~~~~~~~~~~~~......................__@_____#....nnnn........................
				~~~~~~~~~~~~~.....................#___U____................................
				~~~~~~~~~~~~......................#_____K_#....nnnn........................
				~~~~~~~~~~~.......................###___###................................
				~~~~~~~~~~..........................#___#..................................
				...........................................................................
				...........................................................................
				...........................................................................
				..####__##...........................................&&&......######..##...
				..#.....__...........................................&&&......#....____....
				..#___..............&&&..............................&&&........__.....#...
				..####__###.........&&&......................................._.....__.#...
				....................&&&.......................................###..__###...
				...........................................................................
		 */

		List<String> map = Arrays.asList(
				"...........................................................................",
				"......................#####....######......................................",
				"......................#..___....____#......................................",
				"..................................__#......................................",
				"......................._____........#......................................",
				"......................#............_#......................................",
				"......................#...........###......................................",
				"...........................................................................",
				"...........................................................................",
				"..................................###___###................................",
				"..................................________#................................",
				"..................................#___U____................................",
				"..................................#_______#................................",
				"..................................###___###................................",
				"....................................#___#..................................",
				"...........................................................................",
				"...........................................................................",
				"...........................................................................",
				"..####__##....................................................######..##...",
				"..#.....__....................................................#....____....",
				"..#___..........................................................__.....#...",
				"..####__###..................................................._.....__.#...",
				"..............................................................###..__###...",
				"..........................................................................."
		);

		GameMap gameMap = new GameMap(groundFactory, map);
		world.addGameMap(gameMap);

		// West Graveyards
		gameMap.at(2, 0).setGround(new Graveyard(new WestEnemyFactory()));
		gameMap.at(3, 0).setGround(new Graveyard(new WestEnemyFactory()));
		gameMap.at(4, 0).setGround(new Graveyard(new WestEnemyFactory()));
		gameMap.at(5, 0).setGround(new Graveyard(new WestEnemyFactory()));
		gameMap.at(2, 2).setGround(new Graveyard(new WestEnemyFactory()));
		gameMap.at(3, 2).setGround(new Graveyard(new WestEnemyFactory()));
		gameMap.at(4, 2).setGround(new Graveyard(new WestEnemyFactory()));
		gameMap.at(5, 2).setGround(new Graveyard(new WestEnemyFactory()));
		for (int x = 49; x <= 51; x++) {
			for (int y = 10; y <= 12; y += 2) {
				gameMap.at(x, y).setGround(new Graveyard(new EastEnemyFactory()));
			}
		}

		// West Puddle of Waters
		for (int x = 0; x <= 9; x++) {
			for (int y = 9; y <= 14; y++) {
				gameMap.at(x, y).setGround(new PuddleOfWater(new WestEnemyFactory()));
			}
		}
		// East Puddle of Waters
		for (int x = 54; x <= 74; x++) {
			for (int y = 0; y <= 5; y++) {
				gameMap.at(x, y).setGround(new PuddleOfWater(new EastEnemyFactory()));
			}
		}
		// West Gusts of Wind
		for (int x = 20; x <= 22; x++) {
			for (int y = 20; y <= 22; y++) {
				gameMap.at(x, y).setGround(new GustOfWind(new WestEnemyFactory()));
			}
		}
		// East Gust of Wind
		for (int x = 48; x <= 50; x++) {
			for (int y = 18; y <= 20; y++) {
				gameMap.at(x, y).setGround(new GustOfWind(new EastEnemyFactory()));
			}
		}

		// Ask for combat archetype
		Map<Character, CombatArchetype> combatArchetypes = new HashMap<>(CombatArchetype.values().length);
		for (CombatArchetype archetype : CombatArchetype.values()) {
			combatArchetypes.put(archetype.getHotKey(), archetype);
		}

		combatArchetypes.forEach((hotKey, archetype) -> display.println(String.format("%s. %s", hotKey, archetype.getName())));

		display.println("=== SELECT ONE ===");
		char archetypeSelection = display.readChar();
		while (!combatArchetypes.containsKey(archetypeSelection)) {
			archetypeSelection = display.readChar();
		}
		CombatArchetype archetype = combatArchetypes.get(archetypeSelection);

		ResetManager resetManager = ResetManager.getInstance();
		RuneManager runeManager = RuneManager.getInstance();

		gameMap.at(40, 12).addActor(new MerchantKale());

		Player player = new Player("Tarnished", '@', 300, resetManager, new Location(gameMap, 38, 11), runeManager, display);
		world.addPlayer(player, gameMap.at(38, 11));

		// Archetype chosen
		player.addWeaponToInventory(archetype.getStartingWeapon());
		player.resetMaxHp(archetype.getStartingHitPoints());

		resetManager.registerResettable(player);

		// BEHOLD, ELDEN RING
		for (String line : FancyMessage.ELDEN_RING.split("\n")) {
			new Display().println(line);
			try {
				Thread.sleep(0);
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}

		world.run();
	}
}
