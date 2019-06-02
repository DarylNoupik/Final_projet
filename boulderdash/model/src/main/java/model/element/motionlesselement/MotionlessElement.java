package model.element.motionlesselement;

import element.Element;
import entity.Permeability;
import entity.Sprite;

/**
 * Abstract representation of a motionless element
 * @author D.A.F.Y
 *
 */
public abstract class MotionlessElement extends Element {
	public MotionlessElement(Sprite sprite, Permeability permeability)
	{
		super(sprite, permeability);
	}
}
