package org.advent24;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class day4 {
    private static final Logger logger = LoggerFactory.getLogger(day4.class);

    public void runPt1() throws FileNotFoundException {
        try {
            ArrayList<String> input = new ArrayList<>();

            try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/org/advent24/input_4"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    input.add(line);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            int count = 0;
            for (int i = 0; i < input.size(); i++){
                for (int j = 0; j < input.get(i).length(); j++){
                    //up
                    if (i > 2){
                        if(input.get(i).charAt(j) == 'X'){
                            if(input.get(i-1).charAt(j) == 'M'){
                                if(input.get(i-2).charAt(j) == 'A'){
                                    if(input.get(i-3).charAt(j) == 'S'){
                                        count++;
                                    }
                                }
                            }
                        }
                    }

                    //down
                    if (i < input.size()-3){
                        if(input.get(i).charAt(j) == 'X'){
                            if(input.get(i+1).charAt(j) == 'M'){
                                if(input.get(i+2).charAt(j) == 'A'){
                                    if(input.get(i+3).charAt(j) == 'S'){
                                        count++;
                                    }
                                }
                            }
                        }
                    }

                    //left
                    if (j > 2){
                        if(input.get(i).charAt(j) == 'X'){
                            if(input.get(i).charAt(j-1) == 'M'){
                                if(input.get(i).charAt(j-2) == 'A'){
                                    if(input.get(i).charAt(j-3) == 'S'){
                                        count++;
                                    }
                                }
                            }
                        }
                    }

                    //right
                    if (j < input.get(i).length()-3){
                        if(input.get(i).charAt(j) == 'X'){
                            if(input.get(i).charAt(j+1) == 'M'){
                                if(input.get(i).charAt(j+2) == 'A'){
                                    if(input.get(i).charAt(j+3) == 'S'){
                                        count++;
                                    }
                                }
                            }
                        }
                    }

                    //UL
                    if (i > 2 && j > 2){
                        if(input.get(i).charAt(j) == 'X'){
                            if(input.get(i-1).charAt(j-1) == 'M'){
                                if(input.get(i-2).charAt(j-2) == 'A'){
                                    if(input.get(i-3).charAt(j-3) == 'S'){
                                        count++;
                                    }
                                }
                            }
                        }
                    }

                    //UR
                    if (i > 2 && j < input.get(i).length()-3){
                        if(input.get(i).charAt(j) == 'X'){
                            if(input.get(i-1).charAt(j+1) == 'M'){
                                if(input.get(i-2).charAt(j+2) == 'A'){
                                    if(input.get(i-3).charAt(j+3) == 'S'){
                                        count++;
                                    }
                                }
                            }
                        }
                    }

                    //DL
                    if (i < input.size()-3 && j > 2){
                        if(input.get(i).charAt(j) == 'X'){
                            if(input.get(i+1).charAt(j-1) == 'M'){
                                if(input.get(i+2).charAt(j-2) == 'A'){
                                    if(input.get(i+3).charAt(j-3) == 'S'){
                                        count++;
                                    }
                                }
                            }
                        }
                    }

                    //DR
                    if (i < input.size()-3 && j < input.get(i).length()-3){
                        if(input.get(i).charAt(j) == 'X'){
                            if(input.get(i+1).charAt(j+1) == 'M'){
                                if(input.get(i+2).charAt(j+2) == 'A'){
                                    if(input.get(i+3).charAt(j+3) == 'S'){
                                        count++;
                                    }
                                }
                            }
                        }
                    }
                }
            }

            System.out.println(count);

        } catch (RuntimeException e) {
            logger.error("An error occurred: {}", e.getMessage(), e);
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        try {
            ArrayList<String> input = new ArrayList<>();

            try (BufferedReader br = new BufferedReader(new FileReader("src/main/java/org/advent24/input_4"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    input.add(line);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            int count = 0;
            for (int i = 1; i < input.size()-1; i++) {
                for (int j = 1; j < input.get(i).length()-1; j++) {

                    if (input.get(i).charAt(j) == 'A'){
                        //X
                        if ((input.get(i-1).charAt(j-1) == 'M' && input.get(i+1).charAt(j+1) == 'S') ||
                                (input.get(i+1).charAt(j+1) == 'M' && input.get(i-1).charAt(j-1) == 'S')){
                            if ((input.get(i-1).charAt(j+1) == 'M' && input.get(i+1).charAt(j-1) == 'S') ||
                                    (input.get(i+1).charAt(j-1) == 'M' && input.get(i-1).charAt(j+1) == 'S')){
                                count++;
                            }
                        }
                    }
                }
            }

            System.out.println(count);
        } catch (RuntimeException e) {
            logger.error("An error occurred: {}", e.getMessage(), e);
        }
    }
}
