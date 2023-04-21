package game;

import edu.monash.fit2099.engine.actions.Action;

public enum SpecialAttackType {
    SLAM(SlamAttackAction.class);

    private Class<? extends Action> specialAttackClass;

    private SpecialAttackType(Class<? extends Action> specialAttackClass) {
        this.specialAttackClass = specialAttackClass;
    }

    public Class<? extends Action> getSpecialAttack() {
        return specialAttackClass;
    }
}
