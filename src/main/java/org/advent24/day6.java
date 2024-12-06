package org.advent24;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class day6 {
    private static final Logger logger = LoggerFactory.getLogger(day6.class);

    public String rotate(String oldDir){
        String newDir = "";

        switch (oldDir){
            case "U" -> newDir = "R";
            case "R" -> newDir = "D";
            case "D" -> newDir = "L";
            case "L" -> newDir = "U";
        }

        return newDir;
    }

    @SuppressWarnings("DuplicatedCode")
    public static void main(String[] args) {
        try {
            ArrayList<String> input = new ArrayList<>();
            ArrayList<Integer[]> cords = new ArrayList<>();
            String dir = "U";
            Integer[] pos = new Integer[2];

            try (BufferedReader br = new BufferedReader(new FileReader("/Users/john/IdeaProjects/adventOfCode24/src/main/java/org/advent24/input_test_6"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    input.add(line);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            for (int i = 0; i < input.size(); i++){
                for (int j = 0; j < input.get(i).length(); j++){
                    if (input.get(i).charAt(j) == '#'){
                        cords.add(new Integer[] {j, i});
                    }
                    if (input.get(i).charAt(j) == '^'){
                        pos[0] = j;
                        pos[1] = i;
                    }
                }
            }

            int count = 0;
            boolean outOfBounds = false;
            while (!outOfBounds){
                boolean canMove = true;
                Integer[] mover = new Integer[2];

                switch (dir){
                    case "U" -> mover = new Integer[] {0, -1};
                    case "R" -> mover = new Integer[] {1, 0};
                    case "D" -> mover = new Integer[] {0, 1};
                    case "L" -> mover = new Integer[] {-1, 0};
                }

                while (canMove){
                    pos[0] += mover[0];
                    pos[1] += mover[1];

                    if (){

                    }
                }
            }

        } catch (RuntimeException e) {
            logger.error("An error occurred: {}", e.getMessage(), e);
        }
    }
}