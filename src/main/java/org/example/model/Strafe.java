package org.example.model;

public class Strafe {

    private int id;
    private int fahrer_id;
    private StrafeGrund strafe;
    private int seconds;
    private int lap;

    public Strafe(int id, int fahrer_id, StrafeGrund strafe, int seconds, int lap) {
        this.id = id;
        this.fahrer_id = fahrer_id;
        this.strafe = strafe;
        this.seconds = seconds;
        this.lap = lap;
    }
    public int getId() {
        return id;
    }
    public int getFahrer_id() {
        return fahrer_id;

    }
    public StrafeGrund getStrafe() {
        return strafe;
    }
    public int getSeconds() {
        return seconds;

    }
    public int getLap() {
        return lap;
    }
}
