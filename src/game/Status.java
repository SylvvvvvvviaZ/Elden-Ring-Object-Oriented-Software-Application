package game;

/**
 * Use this enum class to give `buff` or `debuff`.
 * Created by:
 * @author Riordan D. Alfredo, modified by dkon0020
 */
public enum Status {
    HOSTILE_TO_ENEMY,
    RESPAWNABLE,
    RESTING,
    FOLLOWING_PLAYER,
    /**
     * Actor will become a Pile of Bones upon death
     */
    DIES_TO_PILE_OF_BONES,
    RESPAWN_POINT,
    UNMOVABLE,
    /**
     * Item should only be dropped if actor died due to player attack
     * @see Player
     */
    DROP_ON_PLAYER_ATTACK_ONLY,
    /**
     * Item should be picked up immediately by the player attacker
     * @see Player
     */
    IMMEDIATE_PICK_UP
}
