package model.element.motionlesselement;

import java.awt.Rectangle;

import contract.model.element.Permeability;
import contract.model.element.Sprite;

/**
 * The Wall is a basic BLOCKING motionless element.
 * @author D.A.F.Y
 *
 */
public class Wall extends MotionlessElement{
	
	private static final Sprite sprite = new Sprite('W', Sprite.mapTileSet, new Rectangle(0, 0, 16, 16));

	public Wall() {
		super(sprite, Permeability.BLOCKING);
	}

}
