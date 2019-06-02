package contract.model;

import entity.IMobile;

/**
 * <h1>The Interface IModel.</h1>
 * @author GROUP 9 DASH
 *
 */
public interface IModel {

    /**
     * Gets the map.
     */
    public IMap getMap();
    
    /** @return the player's character */
    public IMobile getMyCharacter();
    
    /** Makes the pawn follow their strategy */
    public void movePawns();
}
