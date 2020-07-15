package Vehicles;

import Driving.Bike;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ElectricBikeTest {
        Bike eb;

        @Before
        public void setUp() throws Exception {
            this.eb = new ElectricBike();
        }

        @Test
        public void getTopSpeed() {
            // Arrange
            Double expected = 20.0;

            // Act
            Double actual = eb.getTopSpeed();

            // Assert
            assertEquals(expected, actual);
        }

        @Test
        public void getTopSpeedAfterTransport() {
            // Arrange
            Double expected = 16.0;

            // Act
            eb.transport(30.0);
            eb.transport(30.0);
            Double actual = eb.getTopSpeed();

            // Assert
            assertEquals(expected, actual);
        }

        @Test
        public void getTopSpeedAfterTransportThenInflateTires() {
            // Arrange
            Double expected = 20.0;

            // Act
            eb.transport(30 * 2.0);
            eb.inflateTires();
            Double actual = eb.getTopSpeed();

            // Assert
            assertEquals(expected, actual);
        }

        @Test
        public void transport() {
            // Arrange
            Integer expected = 5130;

            // Act
            Integer actual = eb.transport(28.5);

            // Assert
            assertEquals(expected, actual);
        }

        @Test
        public void transportTirePressure() {
            // Arrange
            Integer expected = 46;

            // Act
            eb.transport(30.0 * 2);
            Integer actual = eb.getTirePressure();

            // Assert
            assertEquals(expected, actual);
        }

        @Test
        public void transportTirePressure2() {
            // Arrange
            Integer expected = 44;

            // Act
            eb.transport(30.0 * 3);
            Integer actual = eb.getTirePressure();

            // Assert
            assertEquals(expected, actual);
        }

        @Test
        public void transportTirePressure3() {
            // Arrange
            Integer expected = 40;

            // Act
            eb.transport(30.0 * 100);
            eb.transport(30.0 * 2);
            Integer actual = eb.getTirePressure();

            // Assert
            assertEquals(expected, actual);
        }

        @Test
        public void transportTirePressure4() {
            // Arrange
            Integer expected = 40;

            // Act
            eb.transport(29.9);
            eb.transport(29.9);
            eb.transport(29.9);
            eb.transport(29.9);
            eb.transport(29.9);
            eb.transport(29.9);
            Integer actual = eb.getTirePressure();

            // Assert
            assertEquals(expected, actual);
        }

        @Test
        public void getTirePressure() {
            // Arrange
            Integer expected = 50;

            // Act
            Integer actual = eb.getTirePressure();

            // Assert
            assertEquals(expected, actual);
        }

        @Test
        public void inflateTires() {
            // Arrange
            Integer expected = 50;

            // Act
            eb.transport(30.0 * 3);
            Integer tirePressureAfterTransport = eb.getTirePressure();

            eb.inflateTires();
            Integer actual = eb.getTirePressure();

            // Assert
            assertNotEquals(expected, tirePressureAfterTransport);
            assertEquals(expected, actual);
        }

        @Test
        public void recommendedTirePressure() {
            // Arrange
            Integer expected = 50;

            // Act
            Integer actual = eb.recommendedTirePressure();

            // Assert
            assertEquals(expected, actual);
        }
    }
