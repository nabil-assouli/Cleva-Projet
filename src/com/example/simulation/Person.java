package com.example.simulation;

public class Person {
    private int positionX;
    private int positionY;

    public Person(int positionX, int positionY) {
        this.positionX = positionX;
        this.positionY = positionY;
    }

    @Override
    public String toString() {
        return "Person{" +
                "positionX=" + positionY +
                ", positionY=" + positionX +
                '}';
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }
}