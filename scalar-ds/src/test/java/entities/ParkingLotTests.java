package entities;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.scalar.design.lld.parkinglot.entities.ParkingFloor;
import com.scalar.design.lld.parkinglot.entities.ParkingLot;
import com.scalar.design.lld.parkinglot.entities.VehicleType;
import org.junit.jupiter.api.Test;

/**
 * @author t0k02w6 on 11/12/22
 * @project scalar-ds
 */
public class ParkingLotTests {
  @Test
  public void canBuildParkingLot() {
    var parkingFloorBuilder = new ParkingFloor.Builder()
        .addSpots(VehicleType.CAR, 10)
        .addSpots(VehicleType.MOTORBIKE, 20);

    var parkingLot = new ParkingLot.Builder(2)
        .addFloor(parkingFloorBuilder.setNumber(0).build())
        .addFloor(parkingFloorBuilder.setNumber(1).build())
        .setParkingFees(VehicleType.CAR, 10)
        .setParkingFees(VehicleType.MOTORBIKE, 5)
        .build();


      assertNotNull(parkingLot);
  }
}
