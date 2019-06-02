package model.element.motionlesselement;

import java.awt.Rectangle;

import entity.Permeability;
import entity.Sprite;

/**
 * The DugDirt motionless element if a basic PENETRABLE element which rockford dig.
 * @author D.A.F.Y
 *
 */
public class DugDirt extends MotionlessElement{
	
	private static final Sprite sprite = new Sprite(' ', Sprite.mapTileSet, new Rectangle(32, 0, 16, 16));

	public DugDirt() {
		super(sprite, Permeability.PENETRABLE);
	}

}
