package edu.hillel.homework.lesson17.ball_factory;

public abstract class Ball {

    private final float ballDiameter;
    private final String kindOfSport;
    private final int serialNumber;

    public Ball(float ballDiameter, String kindOfSport, int serialNumber) {
        this.ballDiameter = ballDiameter;
        this.kindOfSport = kindOfSport;
        this.serialNumber = serialNumber;
    }

    public float getBallDiameter() {
        return ballDiameter;
    }

    public String getKindOfSport() {
        return kindOfSport;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public abstract void play();

    @Override
    public String toString() {
        return "Ball{" +
                "ballDiameter=" + ballDiameter +
                ", kindOfSport='" + kindOfSport + '\'' +
                ", serialNumber=" + serialNumber +
                "}";
    }
}
