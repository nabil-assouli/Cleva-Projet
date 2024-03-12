package com.example.simulation.movements;

import com.example.simulation.Person;
import com.example.simulation.exceptions.InvalidPositionException;
import com.example.simulation.map.Map;

public class MovementExecutor {
    private final Person person;
    private final Map map;

    public MovementExecutor(Person person, Map map) {
        this.person = person;
        this.map = map;
    }

    public void executeMovements(String movements) throws InvalidPositionException {
        for (char movement : movements.toCharArray()) {
            moveInDirection(movement);
        }
    }

    private void moveInDirection(char direction) throws InvalidPositionException {
        int newPosX = person.getPositionX();
        int newPosY = person.getPositionY();

        switch (direction) {
            case 'N' -> newPosX--;
            case 'S' -> newPosX++;
            case 'E' -> newPosY++;
            case 'O' -> newPosY--;
            default -> {
                System.out.println("Invalid Direction : " + direction);
                return;
            }
        }
        try {
            if (isPositionValid(newPosX, newPosY)) {
                person.setPositionX(newPosX);
                person.setPositionY(newPosY);
            }
        } catch (InvalidPositionException e) {
            System.out.println(e.getMessage());
        }
    }

    private boolean isPositionValid(int x, int y) throws InvalidPositionException {
        char[][] grid = this.map.getMap();
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length) {
            return false;        }
        if (grid[x][y] == '#') {
            return false;        }
        return true;
    }
}