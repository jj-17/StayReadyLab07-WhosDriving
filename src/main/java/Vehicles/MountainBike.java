package Vehicles;

import Driving.Bike;

public class MountainBike extends Bike {
    private Double topSpeed;
    private Integer tirePressure;

    public MountainBike(){
        this.topSpeed = 28.5;
        this.tirePressure = 30;
    }



    /**
     * The top speed of a mountain bike should be 28.5
     * but for every 1 PSI under the recommended tire
     * pressure the tires of the bike are, the top
     * speed should be reduced 1mph.
     *
     * @return 28.5 minus any reduction to top speed
     */
    @Override
    public Double getTopSpeed() {
        int actualPsi = 0;
        Double actualTopSpeed = 0.0;
        if(this.tirePressure < recommendedTirePressure()){
            actualPsi = recommendedTirePressure() - this.tirePressure;
            actualTopSpeed = this.topSpeed - actualPsi;
        }
        else{
            actualTopSpeed = this.topSpeed;
        }
        return actualTopSpeed;
    }


    /**
     * transport should calculate the time it takes in
     * seconds to travel a distance base on the top
     * speed and update the tire pressure. Long trips
     * on a mountain bike will reduce its PSI, so for
     * every 30 miles traveled in a single trip, the
     * tires of the bike should reduce 1 PSI until
     * the tires register 20 PSI where no more air
     * will be lost on trips.
     *
     * @param distance - length of travel in miles
     * @return time in seconds to travel distance
     */

    @Override
    public Integer transport(Double distance) {
        Integer time = 0;
        Double dist = distance;
        Double speed = this.topSpeed;
        int tirePress = this.tirePressure;
        if(dist < 30.0){
            time = (int) Math.round((dist / speed) * 3600);
        }
        else{
            int minusTirePress = (int) Math.round(dist / 30.0);
            if(tirePress - minusTirePress <= 20){
                this.tirePressure = 20;
            }
            else {
                tirePress -= minusTirePress;
                this.tirePressure -= minusTirePress;

            }
            time = (int) Math.round((dist / speed) * 3600);
        }
        return time;
    }

    /**
     * Gets the current amount of pressure in PSI
     * in the tires
     *
     * @return PSI as Integer
     */
    @Override
    public Integer getTirePressure() {

        return this.tirePressure;
    }

    /**
     * Returns the tires to the recommended PSI
     */
    @Override
    public void inflateTires() {
        this.tirePressure = recommendedTirePressure();

    }

    /**
     * The Recommended PSI of a mountain bike is 30
     * @return recommended PSI
     */
    @Override
    public Integer recommendedTirePressure() {
        return 30;
    }
}
