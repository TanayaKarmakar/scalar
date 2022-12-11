package entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.scalar.design.lld.parkinglot.entities.ParkingFloor;
import com.scalar.design.lld.parkinglot.entities.VehicleType;
import org.junit.jupiter.api.Test;

/**
 * @author t0k02w6 on 11/12/22
 * @project scalar-ds
 */
public class ParkingFloorTests {
  @Test
  void canCreateAParkingFloor() {
    var builder = new ParkingFloor.Builder();
    builder.addSpots(VehicleType.CAR, 10);
    builder.addSpots(VehicleType.MOTORBIKE, 5);

    var floor1 = builder.setNumber(1).build();
    var floor2 = builder.setNumber(2).build();
    var floor3 = builder.setNumber(3).build();
    assertNotNull(floor1);
  }

  @Test
  void canFindFirstFreeSpot() {
    var builder = new ParkingFloor.Builder();

    builder.addSpots(VehicleType.CAR, 10);
    builder.addSpots(VehicleType.MOTORBIKE, 5);

    var floor1 = builder.setNumber(1).build();
    var freeSlot = floor1.getFirstFreeSpot(VehicleType.CAR);

    assertEquals(0, freeSlot);
  }
}
