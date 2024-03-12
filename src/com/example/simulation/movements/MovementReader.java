package com.example.simulation.movements;

import com.example.simulation.Person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MovementReader {
    private final String moveFile;

    public MovementReader(String moveFile) {
        this.moveFile = moveFile;
    }

    public Person readPerson() {
        try (BufferedReader br = new BufferedReader(new FileReader(moveFile))) {
            String[] coordinates = br.readLine().split(",");
            int positionX = Integer.parseInt(coordinates[1]);
            int positionY = Integer.parseInt(coordinates[0]);
            return new Person(positionX, positionY);
        } catch (IOException e) {
            throw new RuntimeException("Error reading move file.", e);
        }
    }

    public String readMovements() {
        try (BufferedReader br = new BufferedReader(new FileReader(moveFile))) {
            br.readLine();
            return br.readLine();
        } catch (IOException e) {
            throw new RuntimeException("Error reading move file.", e);
        }
    }
}