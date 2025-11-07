package com.kafka.producer;

public class RiderLocation {

    private String riderId;

    private double longitute;

    private double latitude;

    public RiderLocation() {
    }

    public RiderLocation(String riderId, double longitute, double latitude) {
        this.riderId = riderId;
        this.longitute = longitute;
        this.latitude = latitude;
    }

    public String getRiderId() {
        return riderId;
    }

    public void setRiderId(String riderId) {
        this.riderId = riderId;
    }

    public double getLongitute() {
        return longitute;
    }

    public void setLongitute(double longitute) {
        this.longitute = longitute;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }
}
