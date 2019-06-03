package contract.controller;

/**
 * <h1>The Interface .</h1>
 *
 * @see IOrderPerformer
 * @author GROUP 9 DASH
 *
 */
public interface IBoulderDashController {
  

    /**
     * Play.
     *
     * @throws InterruptedException
     *             the interrupted exception
     */
    void start() throws InterruptedException;
    

    /**
     * Gets the order peformer.
     *
     * @return the order peformer
     */
    IOrderPerformer getOrderPeformer();
}
