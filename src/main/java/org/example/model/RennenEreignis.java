package org.example.model;

public class RennenEreignis {
    private int id;
    private int fahrer_id;
    private EreignisTyp typ;
    private int basePoint;
    private int lap;

    public RennenEreignis( int id, int fahrer_id, EreignisTyp typ, int basePoint, int lap ) {
        this.id = id;
        this.fahrer_id = fahrer_id;
        this.typ = typ;
        this.basePoint = basePoint;
        this.lap = lap;
    }
    public int getId() {
        return id;
    }
    public int getFahrer_id() {
        return fahrer_id;
    }
    public EreignisTyp getTyp() {
        return typ;
    }
    public int getBasePoint() {
        return basePoint;
    }
    public int getLap() {
        return lap;
    }
}
