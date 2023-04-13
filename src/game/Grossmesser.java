package game;

import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;

public class Grossmesser extends WeaponItem {

    /**
	 * Constructor.
	 */
    public Grossmesser() {
		super("Grossmesser", '?', 115, "slash", 85);
	}

    @Override
	public Action getSkill(Actor holder) {
		// No skill without a target
        return new SpinningAttack();
	}    









}




