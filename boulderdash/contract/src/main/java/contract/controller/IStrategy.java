package contract.controller;

import contract.model.IMap;
import entity.IMobile;

/**
 * The IStrategy interface.
 * @author GROUP 9 DASH
 *
 */
public interface IStrategy {
  
  /** 
   * Makes a pawn perform actions on a map 
   * 
   * @param currentPawn 
   * The pawn to perform actions.
   * 
   * @param map
   * The map to use for the pawn.
   */
  public void followStrategy(IMobile currentPawn, IMap map);
}
