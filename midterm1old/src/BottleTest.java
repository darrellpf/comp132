import static org.junit.Assert.*;

import org.junit.Test;


public class BottleTest {

	@Test
	public void poursDecreaseBottle() {
		Bottle gin = new Bottle("Gin", 6);
		
		gin.pourSingle();
		assertTrue(gin.getCurrentVolume() == 5);
		
		gin.pourDouble();
		assertTrue(gin.getCurrentVolume() == 3);		
	}

	@Test
	public void poursAreAccounted() {
		Bottle gin = new Bottle("Gin", 6);
		
		gin.pourSingle();
		gin.pourDouble();
		
		assertTrue(gin.allPoursAccounted() == true);
		assertTrue(gin.getCurrentVolume() == 6 - 1 - 2);
		
		gin.pourDouble();
		
		assertTrue(gin.allPoursAccounted() == true);
		assertTrue(gin.getCurrentVolume() == 6 - 1 - 2 - 2);
	}
}
