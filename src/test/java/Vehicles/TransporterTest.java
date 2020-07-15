package Vehicles;

import Driving.Teleporter;
import org.junit.Assert;
import org.junit.Test;

public class TransporterTest {
    @Test
    public void teleporterConstructorTest(){
        //Given
        Double expected = Double.MAX_VALUE;

        //When
        Teleporter teleport = new Teleporter();
        Double actual = teleport.getTopSpeed();

        //Then
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getTopSpeedTest(){
        //Given
        Double expected = Double.MAX_VALUE;

        //When
        Teleporter teleport = new Teleporter();
        Double actual = teleport.getTopSpeed();

        //Then
        Assert.assertEquals(expected, actual);
    }
    @Test
    public void getTransportTest(){
        //Given
        Integer expected = 0;

        //When
        Teleporter teleport = new Teleporter();
        Integer actual = teleport.transport(8958474.88);
        //Then
        Assert.assertEquals(expected, actual);
    }

}
