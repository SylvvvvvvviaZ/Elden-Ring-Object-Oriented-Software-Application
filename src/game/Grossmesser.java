package game;
import edu.monash.fit2099.engine.actions.Action;
import edu.monash.fit2099.engine.actors.Actor;
import edu.monash.fit2099.engine.weapons.WeaponItem;

/*
A class that represents a Grossmesser, a curved sword that can perform targeted and spinning attacks.
*/

public class Grossmesser extends WeaponItem {

    /**
	 * Constructor 
	 * Set its damage, accuracy, and verb for the targeted attack.
	 */
    public Grossmesser() {
		super("Grossmesser", '?', 115, "slash", 85);
	}

    public void spinningAttack(Actor user, ArrayList<Actor> targets) {
        for (Actor target : targets) {
            if (target != user) {
                target.takeDamage(this.getDamage(), this.getAccuracy());
            }
        }
    }

	/*
	Returns a list of allowable actions for this weapon.
	@param actor the actor wielding this weapon
	@return a list of allowable actions
	*/
	@Override
	public ActionList getAllowableActions(Actor actor) {
		ActionList actions = new ActionList();
		if (actor.hasCapability(Status.HOSTILE_TO_ENEMY)) {
			actions.add(new AttackAction(this, "slashes"));
			actions.add(new SpinningAttack(this, DAMAGE, ACCURACY));
		}
		return actions;
	}

	@Override
    public Action getSkill() {
        return new SpinningAttack();
    }
}









}




