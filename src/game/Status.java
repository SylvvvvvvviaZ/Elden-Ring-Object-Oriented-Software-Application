package game;

/**
 * Use this enum class to give `buff` or `debuff`.
 * Created by:
 * @author Riordan D. Alfredo
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
    UNMOVABLE
}
