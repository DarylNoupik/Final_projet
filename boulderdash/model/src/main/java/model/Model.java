package model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import contract.model.IMap;
import contract.model.IModel;
import entity.IMobile;
import entity.Sprite;
import model.dao.MapDAO;
import model.element.mobile.Rockford;

/**
 * <h1>The Class Model provides a facade of the Model component.</h1>
 * 
 * @author Paul Combaldieu
 * @version 1.0
 */
public class Model implements IModel {

	/** The map. */
	private IMap map;

	/** The player's character. */
	private Rockford rockford;

	/**
	 * Instantiates a new model facade.
	 * 
	 * @throws SQLException
	 * @throws IOException
	 */
	public Model(final int mapID) throws SQLException, IOException {
		super();
		Sprite.loadBuffers();
		this.setMap(MapDAO.getMapById(mapID));
		this.setMyCharacter(new Rockford(1, 1, this.getMap()));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.IModel#getExampleById(int)
	 */
	@Override
	public IMap getMap() {
		return this.map;
	}

	public void setMap(final Map newMap) {
		this.map = newMap;
	}

	private void setMyCharacter(final Rockford newChara) {
		this.rockford = newChara;
	}

	/**
	 * Moves pawns (boulders, diamonds, ...).
	 * Their movement is related to their strategy.
	 */
	public void movePawns() {
		ArrayList<IMobile> copyPawns = new ArrayList<>(this.getMap().getPawns());
		
		for (IMobile pawn : copyPawns) {
			pawn.followMyStrategy();
		}

		if (this.getMyCharacter().isCrushed())
			this.getMyCharacter().die();
	}

	@Override
	public Rockford getMyCharacter() {
		return this.rockford;
	}
}
