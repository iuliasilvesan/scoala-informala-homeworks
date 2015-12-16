package homework4;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class CarApplicationTest {
 
	private static final double DELTA = 1e-15;
	private static final double DELTA1 = 0.009;
	
	@Test
	public void checkStart() {
		Car car = new Logan(27,"Logan Chassis Number");
		car.start();
		Assert.assertEquals(0,car.getCurrentConsumption(),DELTA);
		Assert.assertEquals(0,car.getPollution(), DELTA);
		Assert.assertEquals(0,car.getCurrentNoOfKm(),DELTA);
		Assert.assertEquals(27,car.getAvailableFuel(),DELTA);
	}
	
	@Test
	public void checkShiftGear(){
		Car car = new Polo(30,"Polo Chassis Number");
		car.setCurrentGear(2);
		car.shiftGear(4);
		Assert.assertEquals(4,car.getCurrentGear());
	}
	
	@Test
	public void checkStop_for_Logan(){
		Car car = new Logan(40,"Logan Chassis Number");
		car.shiftGear(4);
		car.drive(50);
		car.stop();
		Assert.assertEquals(132,car.pollutionPerKm,DELTA);
		Assert.assertEquals(37.18,car.getAvailableFuel(),DELTA1);
	}
	
	@Test
	public void checkStop_for_Supernova(){
		Car car = new Supernova(38,"Supernova Chassis Number");
		car.shiftGear(3);
		car.drive(100);
		car.stop();
		Assert.assertEquals(150,car.pollutionPerKm,DELTA);
		Assert.assertEquals(30.23,car.getAvailableFuel(),DELTA1);
	}
	
	@Test
	public void checkStop_for_Polo(){
		Car car = new Polo(38,"Polo Chassis Number");
		car.shiftGear(2);
		car.drive(75);
		car.stop();
		Assert.assertEquals(120,car.pollutionPerKm,DELTA);
		Assert.assertEquals(32,car.getAvailableFuel(),DELTA1);
	}
	
	@Test
	public void checkStop_for_Golf(){
		Car car = new Golf(25,"Golf Chassis Number");
		car.shiftGear(5);
		car.drive(100);
		car.stop();
		Assert.assertEquals(110,car.pollutionPerKm,DELTA);
		Assert.assertEquals(21.2,car.getAvailableFuel(),DELTA1);
	}
	
	@Test
	public void checkDrive(){
		Car car = new Golf(40,"Golf Chassis Number");
		car.setCurrentGear(3);
		car.drive(150);
		Assert.assertEquals(150, car.getCurrentNoOfKm(),DELTA);
		Assert.assertEquals(8.97,car.getCurrentConsumption(),DELTA1);
	}
  
	@Test(expected = IllegalArgumentException.class)
	public void checkCarConstructor_with_exception(){
		Car car = new Golf(60,"Golf chassis number");

	}
	
	@Test
	public void checkShiftGear_with_exception(){
		Car car = new Golf(25,"Golf chassis number");
		car.shiftGear(8);
	}
	
	@Test
	public void checkStart_with_exception_on_gear(){
		Car car = new Logan(28,"Logan chassis number");
		car.setCurrentGear(4);
		car.start();
	}
}
