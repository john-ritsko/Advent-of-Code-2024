package org.advent24;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class day3 {
    private static final Logger logger = LoggerFactory.getLogger(day3.class);

    public static void main(String[] args) throws FileNotFoundException {
        try {
            ArrayList<String> input = new ArrayList<>();
            ArrayList<String> muls = new ArrayList<>();
            ArrayList<Integer[]> nums = new ArrayList<>();
            boolean enabled = true;

            try (BufferedReader br = new BufferedReader(new FileReader("/Users/john/IdeaProjects/adventOfCode24/src/main/java/org/advent24/input_3"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    input.add(line);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            for (String s : input){
                for (int i = 0; i < s.length()-4; i++){
                    String sub = s.substring(i, i+4);
                    if (sub.equals("do()")){
                        enabled = true;
                    }
                    if (sub.equals("don'")){
                        enabled = false;
                    }
                    if (sub.equals("mul(") && enabled){
                        for (int j = i+3; j < i+12; j++){
                            if (String.valueOf(s.charAt(j)).equals(")")){
                                muls.add(s.substring(i, j+1));
                                break;
                            }
                        }
                    }
                }
            }

            System.out.println(muls);

            muls.replaceAll(s -> s.substring(4, s.length() - 1));

            System.out.println(muls);

            for (String s : muls){
                boolean allNums = true;
                boolean splittable = s.contains(",");

                if (splittable) {
                    String[] numStr = s.split(",");
                    Integer[] num = new Integer[2];


                    for (int i = 0; i < numStr[0].length(); i++) {
                        if (!Character.isDigit(numStr[0].charAt(i))) {
                            allNums = false;
                            break;
                        }
                    }

                    for (int i = 0; i < numStr[1].length(); i++) {
                        if (!Character.isDigit(numStr[1].charAt(i))) {
                            allNums = false;
                            break;
                        }
                    }

                    if (allNums) {
                        num[0] = Integer.valueOf(numStr[0]);
                        num[1] = Integer.valueOf(numStr[1]);

                        nums.add(num);
                        System.out.print(Arrays.toString(num) + " ");
                    }
                }
            }

            for (Integer[] i : nums){
                System.out.print(Arrays.toString(i) + " ");
            }
            System.out.println();

            int count = 0;
            for (Integer[] i : nums){
                count += i[0] * i[1];
            }

            System.out.println(count);
        } catch (RuntimeException e) {
            logger.error("An error occurred: {}", e.getMessage(), e);
        }
    }
}
