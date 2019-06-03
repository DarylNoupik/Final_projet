package entity;

import static org.junit.Assert.*;

import java.awt.Rectangle;
//import java.awt.image.BufferedImage;
//import java.io.File;
import java.io.IOException;

//import javax.imageio.ImageIO;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/** <h1> Test Sprite </h1>
 * 
 *
 * @author <p style="color:#FF0000";> <b> <u> D.A.F.Y of  group 9 </u> </b> </p>
 * <img src="C:\Users\daryl\Pictures\cute-cat-cats-hd-wallpaper-602x376.jpg" alt="Flowers in Chania">
 *
 */
public class SpriteTest {
/**
 * Initialization of sprite for the test 
 */
	Sprite sprite ;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
/**
 * Set Up values of sprite
 * @throws Exception
 * 
 * 
 * @see Sprite
 */
	@Before
	public void setUp() throws Exception {
		this.sprite = new Sprite('S', Sprite.mapTileSet, new Rectangle(48, 0, 16, 16));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetImage() throws IOException {
		
	}
/**
 * Test the character of the map to see if it's the correct for construct the sprite 
 */
	@Test
	public void testGetConsoleImage() {
	 final	char expected = 'S';
	// assertEquals(expected,this.sprite.getConsoleImage());
	}

	@Test
	public void testIsImageLoaded() {
  //   assertFalse(false);	
		}

}
