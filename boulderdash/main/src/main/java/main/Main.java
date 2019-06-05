package main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
    	
    	BufferedImage myPicture = ImageIO.read(new File("C:/Users/daryl/Downloads/dafy.png"));
    	ImageIcon image = new ImageIcon(myPicture);
    	String idToAsk= "1"; JOptionPane.showInputDialog(null,"Hello ! We are the group 9 ! Please input your name  : ", "Boulder Dash", 1,image,null,null);
        idToAsk = JOptionPane.showInputDialog("Please input the level (1-6)");
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
