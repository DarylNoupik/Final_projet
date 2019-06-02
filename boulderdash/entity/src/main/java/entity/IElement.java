package entity;

import java.awt.Image;

import fr.exia.showboard.ISquare;

/**
 * The interface that represents elements on the board.
 * @author GROUP 9 DASH
 *
 */
public interface IElement extends ISquare {

    /**
     * Gets the sprite.
     *
     * @return the sprite
     */
    Sprite getSprite();

    /**
     * Gets the permeability.
     *
     * @return the permeability
     */
    Permeability getPermeability();

    /*
     * (non-Javadoc)
     */
    @Override
    Image getImage();

}
