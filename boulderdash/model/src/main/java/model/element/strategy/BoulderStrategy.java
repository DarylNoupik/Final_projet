package model.element.strategy;

import contract.model.IMap;
import entity.IMobile;

/**
 * The strategy followed by boulders. Basically the FallingObject strategy.
 * @author Group9 D.A.F.Y
 *
 */
public class BoulderStrategy extends FallingObjectsStrategy {

	@Override
	public void followStrategy(IMobile currentPawn, IMap map) {
		super.followStrategy(currentPawn, map);
	}
}
