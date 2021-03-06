package entity;

import java.awt.Point;

import fr.exia.showboard.IPawn;

/**
 * <h1>The Interface IMobile.</h1>
 *
 * @author GROUP 9 DASH
 * @version 0.1
 * @see IPawn
 * @see IElement
 */
public interface IMobile extends IPawn, IElement {

    /**
     * Move up.
     */
    void moveUp();

    /**
     * Move left.
     */
    void moveLeft();

    /**
     * Move down.
     */
    void moveDown();

    /**
     * Move right.
     */
    void moveRight();

    /**
     * Do nothing.
     */
    void doNothing();

    /**
     * Gets the x.
     *
     * @return the x
     */
    @Override
    int getX();

    /**
     * Gets the y.
     *
     * @return the y
     */
    @Override
    int getY();

    /**
     * Checks if is alive.
     *
     * @return the alive
     */
    Boolean isAlive();

    /**
     * Checks if the character is crushed.
     *
     * @return the boolean
     */
    Boolean isCrushed();
    
    /** 
     * @param direction The direction.
     * @return Whether this pawn can move to the given position 
     */
    Boolean canMoveTo(final UserOrder direction);

    /*
     * (non-Javadoc)
     * @see fr.exia.showboard.IPawn#getPosition()
     */
    @Override
    Point getPosition();
    
    /**
     * Removes this pawn from the board.
     */
    public void removeFromBoard();
    
    /**
     * Makes this pawn follow its strategy.
     */
    public void followMyStrategy();
    
    /**
     * Gets the direction of the last touched wall
     * @return the direction.
     */
    public UserOrder getLastWallTouched();
    
    /**
     * Sets the direction of the last touched wall.
     * @param userOrder The direction.
     */
    public void setLastWallTouched(final UserOrder userOrder);
    
    /** 
     * 
     * @return Whether this object is falling / has speed.
     */
    public boolean isFalling();

}
