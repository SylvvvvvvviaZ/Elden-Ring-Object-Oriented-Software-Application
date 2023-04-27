package game;

import java.util.*;

import edu.monash.fit2099.engine.displays.Display;
import edu.monash.fit2099.engine.positions.FancyGroundFactory;
import edu.monash.fit2099.engine.positions.GameMap;
import edu.monash.fit2099.engine.positions.Location;
import edu.monash.fit2099.engine.positions.World;
import game.archetypes.*;
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
				"..nnnn................................................~~~~~~~~~~~~~~~~~~~~~",
				"......................#####....######..................~~~~~~~~~~~~~~~~~~~~",
				"..nnnn................#..___....____#...................~~~~~~~~~~~~~~~~~~~",
				"..................................__#....................~~~~~~~~~~~~~~~~~~",
				"......................._____........#.....................~~~~~~~~~~~~~~~~~",
				"......................#............_#......................~~~~~~~~~~~~~~~~",
				"......................#...........###......................................",
				"...........................................................................",
				"...........................................................................",
				"~~~~~~~~~~~.......................###___###................................",
				"~~~~~~~~~~~~......................________#....nnnn........................",
				"~~~~~~~~~~~~~.....................#___U____................................",
				"~~~~~~~~~~~~......................#_______#....nnnn........................",
				"~~~~~~~~~~~.......................###___###................................",
				"~~~~~~~~~~..........................#___#..................................",
				"...........................................................................",
				"...........................................................................",
				"...........................................................................",
				"..####__##...........................................&&&......######..##...",
				"..#.....__...........................................&&&......#....____....",
				"..#___..............&&&..............................&&&........__.....#...",
				"..####__###.........&&&......................................._.....__.#...",
				"....................&&&.......................................###..__###...",
				"..........................................................................."
		);
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

		// Ask for combat archetype
		ArrayList<CombatArchetype> combatArchetypeOptions = new ArrayList<>(3);
		combatArchetypeOptions.add(new Samurai());
		combatArchetypeOptions.add(new Bandit());
		combatArchetypeOptions.add(new Wretch());

		Map<Character, CombatArchetype> combatArchetypes = new HashMap<>(3);
		for (CombatArchetype archetype : combatArchetypeOptions) {
			combatArchetypes.put(archetype.getHotKey(), archetype);
		}

		combatArchetypes.forEach((hotKey, archetype) -> {
			display.println(String.format("%s. %s", hotKey, archetype.getName()));
		});

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
				Thread.sleep(200);
			} catch (Exception exception) {
				exception.printStackTrace();
			}
		}

		world.run();
	}
}
