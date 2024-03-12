package com.example.simulation;

import com.example.simulation.exceptions.InvalidPositionException;
import com.example.simulation.movements.MovementExecutor;
import com.example.simulation.movements.MovementReader;
import com.example.simulation.map.Map;
import com.example.simulation.map.MapReader;

import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    private static final String MAP_FILE = "res/map.txt";
    private static final String MOVE_FILE = "res/move.txt";

    public static void main(String[] args) throws FileNotFoundException {
        File mapFile = new File(MAP_FILE);
        File moveFile = new File(MOVE_FILE);

        if (!mapFile.exists() || !moveFile.exists()) {
            System.err.println("Map or Move files do not exist.");
            System.exit(1);
        }

        MapReader mapReader = new MapReader(MAP_FILE);
        Map map = mapReader.readMap();

        MovementReader movementReader = new MovementReader(MOVE_FILE);
        Person person = movementReader.readPerson();
        String movements = movementReader.readMovements();

        MovementExecutor movementExecutor = new MovementExecutor(person, map);
        try {
            movementExecutor.executeMovements(movements);
            System.out.println("New position: (" + person.getPositionY() + "," + person.getPositionX() + ")");

        } catch (InvalidPositionException e) {
            System.err.println(e.getMessage());
        }
    }
}