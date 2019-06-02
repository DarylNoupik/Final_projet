package model.element.motionlesselement;

import java.awt.Rectangle;

import contract.model.element.Permeability;
import contract.model.element.Sprite;

/**
 * The FilledDirt motionless element is a basic MINEABLE element.
 * @author D.A.F.Y
 *
 */
public class FilledDirt extends MotionlessElement{
	
	private static final Sprite sprite = new Sprite('G', Sprite.mapTileSet, new Rectangle(16, 0, 16, 16));

	public FilledDirt() {
		super(sprite, Permeability.MINEABLE);
	}

}
