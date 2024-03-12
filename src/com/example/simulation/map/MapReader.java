package com.example.simulation.map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MapReader {
    private final String mapFile;

    public MapReader(String mapFile) {
        this.mapFile = mapFile;
    }

    public Map readMap() {
        try (BufferedReader br = new BufferedReader(new FileReader(mapFile))) {
            String line;
            int lineIndex = 0;
            char[][] map = null;
            while ((line = br.readLine()) != null) {
                if (map == null) {
                    map = new char[line.length()][line.length()];
                }
                for (int i = 0; i < line.length(); i++) {
                    map[lineIndex][i] = line.charAt(i);
                }
                lineIndex++;
            }
            return new MapImpl(map);
        } catch (IOException e) {
            throw new RuntimeException("Error reading map file.", e);
        }
    }

    private static class MapImpl implements Map {
        private final char[][] map;

        public MapImpl(char[][] map) {
            this.map = map;
        }

        public char[][] getMap() {
            return map;
        }

        public void displayMap() {
            for (char[] line : map) {
                for (char cell : line) {
                    System.out.print(cell);
                }
                System.out.println();
            }
            System.out.println();
        }
    }
}