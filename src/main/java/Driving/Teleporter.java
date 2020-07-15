package Driving;

public class Teleporter implements Drivable{
    private Double topSpeed;


    public Teleporter(){
        this.topSpeed = Double.MAX_VALUE;
    }

    @Override
    public Double getTopSpeed() {
        return this.topSpeed;
    }

    @Override
    public Integer transport(Double distance) {
        return 0;
    }
}
