package view;


import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import contract.controller.IOrderPerformer;
import contract.model.IMap;
import entity.IMobile;
import entity.UserOrder;
import fr.exia.showboard.BoardFrame;

/**
 * The Class GenericView.</h1>
 * 
 * @author GROUP 9 DAFY
 * @version 1.0
 */
public abstract class GenericView {
	/** The Constant squareSize. */
	protected static final int squareSize = Toolkit.getDefaultToolkit().getScreenSize().width / 40;

	/** The map. */
	protected IMap map = null;

	/** The player's character. */
	protected IMobile myCharacter = null;

	/** The list of pawns. */
	protected ArrayList<IMobile> pawns = null;

	/** The close view on the player. */
	protected Rectangle closeView = null;

	/** The order performer. */
	protected IOrderPerformer orderPerformer = null;

	/** The BoardFrame. */
	protected final BoardFrame boardFrame = new BoardFrame(" D.A.F.Y Boulder Dash");

	/**
	 * Key code to user order.
	 *
	 * @param keyCode
	 *            the key code
	 * @return the user order
	 */
	protected static UserOrder keyCodeToUserOrder(final int keyCode) {
		UserOrder userOrder;
		switch (keyCode) {
		case KeyEvent.VK_RIGHT:
			userOrder = UserOrder.RIGHT;
			break;
		case KeyEvent.VK_LEFT:
			userOrder = UserOrder.LEFT;
			break;
		case KeyEvent.VK_UP:
			userOrder = UserOrder.UP;
			break;
		case KeyEvent.VK_DOWN:
			userOrder = UserOrder.DOWN;
			break;
		default:
			userOrder = UserOrder.NOP;
			break;
		}
		return userOrder;
	}

	protected void setMyCharacter(final IMobile newCharacter) {
		this.myCharacter = newCharacter;
	}

	protected IMobile getMyCharacter() {
		return this.myCharacter;
	}

	protected void setCloseView(final Rectangle newView) {
		this.closeView = newView;
	}

	/**
	 * Gets a reasonable size for the close view depending on the map.
	 * 
	 * @return A rectangle with reasonable dimensions
	 */
	protected Rectangle getReasonableViewPort() {
		int reasonableWidth;
		int reasonableHeight;

		// First let's find a reasonable width
		if ((int) (map.getWidth() * 0.75) > 40) {
			reasonableWidth = 10;
		} else if ((int) (map.getWidth() * 0.75) < 40) {
			reasonableWidth = map.getWidth();
		} else {
			reasonableWidth = (int) (map.getWidth() * 0.75);
		}

		// Now the same with height
		if ((int) (map.getHeight() * 0.75) > 40) {
			reasonableHeight = 10;
		} else if ((int) (map.getHeight() * 0.75) < 40) {
			reasonableHeight = map.getHeight();
		} else {
			reasonableHeight = (int) (map.getHeight() * 0.75);
		}

		return new Rectangle(0, 0, reasonableWidth, reasonableHeight);
	}

	protected IMap getMap() {
		return this.map;
	}

	public Rectangle getCloseView() {
		return closeView;
	}

	protected IOrderPerformer getOrderPerformer() {
		return this.orderPerformer;
	}

	public void setOrderPerformer(final IOrderPerformer newPerformer) {
		this.orderPerformer = newPerformer;
	}

	/**
	 * Update the board frame and redraws squares.
	 */
	public void updateBoardFrame() {
		for (int x = 0; x < this.getMap().getWidth(); x++) {
			for (int y = 0; y < this.getMap().getHeight(); y++) {
				boardFrame.addSquare(this.map.getOnTheMapXY(x, y), x, y);
			}
		}
	}

	/**
	 * 
	 * @param newPawns
	 *            The pawn list.
	 */
	protected void setPawns(final ArrayList<IMobile> newPawns) {
		this.pawns = newPawns;
	}

}
