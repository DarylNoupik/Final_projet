package model.element.mobile;

import java.awt.Rectangle;

import java.io.IOException;

import contract.controller.IStrategy;
import contract.model.IMap;
import entity.Permeability;
import entity.Sprite;
//import model.element.strategy.StoneStrategy;
import model.element.strategy.DiamondStrategy;

/**
 * <h1>The Rockford Class.</h1>
 *<img src= "  C:\Users\daryl\Downloads\dafy.png " alt="Flowers in Chania">
 * @author D.A.F.Y
 *
 */
public class Diamond extends Mobile {

	/** The Constant SPRITE. */
	private static final Sprite sprite = new Sprite('D', Sprite.mapTileSet, new Rectangle(64, 0, 16, 16));

	private static final IStrategy strategy = new DiamondStrategy();

	/**
	 * Instantiates a new my vehicle.
	 *
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * @param map
	 *            the map
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	public Diamond(final int x, final int y, final IMap map) throws IOException {
		super(x, y, sprite, map, Permeability.MINEABLE);
		sprite.loadImage();
	}

	@Override
	public final void moveLeft() {
		super.moveLeft();
	}

	
	@Override
	public final void moveRight() {
		super.moveRight();
	}

	
	@Override
	public final void moveUp() {
		// Nop
	}

	
	@Override
	public final void moveDown() {
		super.moveDown();
	}

	
	@Override
	protected final void die() {
		// Nop
	}

	@Override
	public final void doNothing() {
		super.doNothing();
	}
	
    /**
     * Executes an action according to the DiamondStrategy.
     * @see BoulderStrategy
     */
	@Override
	public void followMyStrategy() {
		Diamond.strategy.followStrategy(this, this.getMap());
	}
}
