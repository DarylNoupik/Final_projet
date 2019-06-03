package main;

import java.io.IOException;


import java.sql.SQLException;

import javax.swing.JOptionPane;

import contract.controller.IBoulderDashController;
import contract.model.IModel;
import controller.Controller;
import model.Model;
import view.View;

/**
 * <h1>The Class Main.</h1>
 * <img src= "  C:\Users\daryl\Downloads\dafy.png " alt="Flowers in Chania">
 * @author GROUP 9 DAFY 
 *
 */
public abstract class Main {

    /**
     * This is the main method.
     *
     * @param args
     *            the arguments
     * @throws SQLException 
     * @throws IOException 
     */
    public static void main(final String[] args) throws SQLException, IOException {
    	
    	String idToAsk= JOptionPane.showInputDialog("Hello ! We are the group 9 ! Please input the level number of the map : ", 1);
        int idAsked = Integer.parseInt(idToAsk);
        
    	final IModel model = new Model(idAsked);
    	final View view = new View(model.getMap(), model.getMyCharacter(), model.getMap().getPawns());
        final IBoulderDashController controller = new Controller(view, model);
        view.setOrderPerformer(controller.getOrderPeformer());

        try {
            controller.start();
        } catch (InterruptedException e) {
        	System.out.println(e.getMessage());
			e.printStackTrace();
		}
    }
}
