package Vehicles;

import Driving.Bike;

public class ElectricBike extends Bike{
    private Double topSpeed;
    private Integer tirePressure;

    public ElectricBike(){
        this.topSpeed = 20.0;
        this.tirePressure = 50;
    }

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

    @Override
    public Integer transport(Double distance) {
        Integer time = 0;
        Double dist = distance;
        Double speed = this.topSpeed;
        int tirePress = this.tirePressure;
        if(dist < 15.0){
            time = (int) Math.round((dist / speed) * 3600);
        }
        else{
            int minusTirePress = (int) Math.round(dist / 15.0);
            if(tirePress - minusTirePress <= 40){
                this.tirePressure = 40;
            }
            else {
                tirePress -= minusTirePress;
                this.tirePressure -= minusTirePress;

            }
            time = (int) Math.round((dist / speed) * 3600);
        }
        return time;
    }

    @Override
    public Integer getTirePressure() {

        return this.tirePressure;
    }

    @Override
    public void inflateTires() {
        this.tirePressure = recommendedTirePressure();

    }

    @Override
    public Integer recommendedTirePressure() {
        return 50;
    }
}
