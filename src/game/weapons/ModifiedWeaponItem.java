package game.weapons;

import edu.monash.fit2099.engine.weapons.WeaponItem;

/**
 * Weapon Item with modified attack characteristics -- useful for effects that change a weapon's characteristics
 */
public class ModifiedWeaponItem extends WeaponItem {
    /**
     * Constructor with modified damage <b>and</b> hitrate
     *
     * @param originalWeapon the original weapon
     * @param damage         amount of damage this weapon does
     * @param hitRate        the probability/chance to hit the target
     */
    public ModifiedWeaponItem(WeaponItem originalWeapon, int damage, int hitRate) {
        super(originalWeapon.toString(), originalWeapon.getDisplayChar(), damage, originalWeapon.verb(), hitRate);
    }
}
