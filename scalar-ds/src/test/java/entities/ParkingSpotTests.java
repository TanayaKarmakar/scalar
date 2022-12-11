package entities;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.scalar.design.lld.parkinglot.entities.ParkingSpot;
import com.scalar.design.lld.parkinglot.entities.Vehicle;
import com.scalar.design.lld.parkinglot.entities.VehicleColor;
import com.scalar.design.lld.parkinglot.entities.VehicleType;
import org.junit.jupiter.api.Test;

/**
 * @author t0k02w6 on 11/12/22
 * @project scalar-ds
 */
public class ParkingSpotTests {
  @Test
  void canParkCarInSpot() {
    var spot = new ParkingSpot();
    spot.setParkingSpotNumber(1);
    spot.setType(VehicleType.CAR);

    var car = new Vehicle();
    car.setRegNumber("A1234");
    car.setVehicleType(VehicleType.CAR);
    car.setColor(VehicleColor.GREEN);
    car.setBrand("Maruti");
    car.setModel("van");

    assertTrue(spot.park(car));
  }

  @Test
  void cannotParkCarInBikeSpot() {
    var spot = new ParkingSpot();
    spot.setParkingSpotNumber(1);
    spot.setType(VehicleType.MOTORBIKE);

    var car = new Vehicle();
    car.setRegNumber("A1234");
    car.setVehicleType(VehicleType.CAR);
    car.setColor(VehicleColor.GREEN);
    car.setBrand("Maruti");
    car.setModel("van");

    assertFalse(spot.park(car));
  }
}
