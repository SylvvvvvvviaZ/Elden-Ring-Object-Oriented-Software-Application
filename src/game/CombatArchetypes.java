package game;

import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * The available combat archetypes
 */
public enum CombatArchetypes {
  SAMURAI(new Uchigatana(), 455),
  BANDIT(new GreatKnife(), 414),
  WRETCH(new Club(), 414);

  private WeaponItem weapon;
  private int hitPoints;

  /**
   * Internal constructor
   * @param weapon the starting weapon
   * @param hitPoints the starting hit points
   */
  private CombatArchetypes(WeaponItem weapon, int hitPoints) {
    this.weapon = weapon;
    this.hitPoints = hitPoints;
  }

  /**
   * Get the starting weapon for this combat class
   * @return the starting weapon
   */
  public WeaponItem getStartingWeapon() {
    return weapon;
  }

  /**
   * Get the starting hit points for this combat class
   * @return the starting hit points
   */
  public int getHitPoints() {
    return hitPoints;
  }
}
