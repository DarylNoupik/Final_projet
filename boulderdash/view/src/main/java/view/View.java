 package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import contract.model.IMap;
import contract.view.IView;
import entity.IMobile;

/**
 * <h1>The Class View provides a facade of the View component.</h1>
 *
 * @author GROUP 9 DAFY
 * 
 */
public class View extends GenericView implements IView, Runnable, KeyListener {
	/**
	 * Instantiates a new view facade.
	 * 
	 * @throws IOException
	 *             reject exceptions
	 */
	public View(final IMap map, final IMobile character, final ArrayList<IMobile> pawns) throws IOException {
		super();
		this.setMap(map);
		this.setMyCharacter(character);
		this.setPawns(pawns);
		this.setCloseView(this.getReasonableViewPort());

		SwingUtilities.invokeLater(this);
	}

	/**
	 * Displays the message in dialog box.
	 * 
	 * @see contract.view.IView#displayMessage(java.lang.String)
	 */
	@Override
	public final void displayMessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	private void setMap(final IMap newMap) throws IOException {
		this.map = newMap;
		for (int x = 0; x < this.getMap().getWidth(); x++) {
			for (int y = 0; y < this.getMap().getHeight(); y++) {
				this.getMap().getOnTheMapXY(x, y).getSprite().loadImage();
			}
		}
	}

	/**
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public final void keyPressed(final KeyEvent keyEvent) {
		try {
			this.getOrderPerformer().orderPerform(keyCodeToUserOrder(keyEvent.getKeyCode()));
		} catch (final IOException exception) {
			exception.printStackTrace();
		}
	}

	@Override
	public void keyReleased(final KeyEvent keyEvent) {
		// Nop
	}

	@Override
	public void keyTyped(final KeyEvent keyEvent) {
		
	}

	@Override
	public final void run() {
		boardFrame.setDimension(new Dimension(this.getMap().getWidth(), this.getMap().getHeight()));
		boardFrame.setDisplayFrame(this.closeView);
		boardFrame.setSize(this.closeView.width * squareSize, this.closeView.height * squareSize);
		boardFrame.addKeyListener(this);
		boardFrame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:/Users/daryl/Downloads/dafy.png"));
		boardFrame.setFocusable(true);
		boardFrame.setFocusTraversalKeysEnabled(false);
		
		for (int x = 0; x < this.getMap().getWidth(); x++) {
			for (int y = 0; y < this.getMap().getHeight(); y++) {
				boardFrame.addSquare(this.map.getOnTheMapXY(x, y), x, y);
			}
		}
		boardFrame.addPawn(this.getMyCharacter());
		for (IMobile pawn : this.pawns) {
			boardFrame.addPawn(pawn);
		}

		this.getMap().getObservable().addObserver(boardFrame.getObserver());
		this.followMyCharacter();

		boardFrame.setVisible(true);

	}

	/**
	 * Move the view to focus on the character.
	 */
	@Override
	public void followMyCharacter() {
		this.getCloseView().y = (int) (this.myCharacter.getY() - (this.getCloseView().getHeight() / 2));
		this.getCloseView().x = (int) (this.myCharacter.getX() - (this.getCloseView().getWidth() / 2));

		if (this.myCharacter.getY() < this.getCloseView().getHeight() / 2) {
			this.getCloseView().y = 0;
		} else if (this.myCharacter.getY() > (this.map.getHeight() - (this.getCloseView().getHeight() / 2))) {
			this.getCloseView().y = (int) (this.map.getHeight() - this.getCloseView().getHeight());
		}
		if (this.myCharacter.getX() < this.getCloseView().getWidth() / 2) {
			this.getCloseView().x = 0;
		} else if (this.myCharacter.getX() > (this.map.getWidth() - (this.getCloseView().getWidth() / 2))) {
			this.getCloseView().x = (int) (this.map.getWidth() - this.getCloseView().getWidth());
		}
	}
}
