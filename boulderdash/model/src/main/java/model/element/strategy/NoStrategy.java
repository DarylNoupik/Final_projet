package model.element.strategy;

import contract.model.IMap;
import entity.IMobile;

/**
 * A strategy that does nothing. Used when monsters are taken out of the board.
 * 
 * 
 * @author D.A.F.Y
 *
 */
public class NoStrategy extends MonsterStrategy {

	@Override
	public void followStrategy(IMobile currentPawn, IMap map) {
		
	}
}
