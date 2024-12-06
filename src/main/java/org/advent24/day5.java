package org.advent24;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class day5 {
    private static final Logger logger = LoggerFactory.getLogger(day5.class);

    @SuppressWarnings("DuplicatedCode")
    public void runPt1() {
        try {
            ArrayList<String> input = new ArrayList<>();
            ArrayList<String> rulesStr = new ArrayList<>();
            ArrayList<String> updatesStr = new ArrayList<>();
            HashMap<Integer, Integer[]> rules = new HashMap<>();

            try (BufferedReader br = new BufferedReader(new FileReader("/Users/john/IdeaProjects/adventOfCode24/src/main/java/org/advent24/input_5"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    input.add(line);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            for (int i = 0; i < 1176; i++){
                rulesStr.add(input.get(i));
            }

            for (int i = 1177; i < 1374; i++){
                updatesStr.add(input.get(i));
            }

            ArrayList<Integer[]> ruleList = new ArrayList<>();
            for (String s : rulesStr){
                String[] temp = s.split("\\|");
                Integer[] ints = {Integer.valueOf(temp[0]), Integer.valueOf(temp[1])};
                ruleList.add(ints);
            }

            ArrayList<Integer[]> updates = new ArrayList<>();
            for (String s : updatesStr){
                String[] temp = s.split(",");
                Integer[] ints = new Integer[temp.length];

                for (int i = 0; i < temp.length; i++){
                    ints[i] = Integer.valueOf(temp[i]);
                }

                updates.add(ints);
            }


            for (Integer[] ints : ruleList){
                if (rules.containsKey(ints[0])){
                    ArrayList<Integer> temp = new ArrayList<>();
                    Collections.addAll(temp, rules.get(ints[0]));

                    temp.add(ints[1]);
                    Integer[] newValue = new Integer[temp.size()];
                    newValue = temp.toArray(newValue);

                    rules.replace(ints[0], newValue);
                } else {
                    rules.put(ints[0], new Integer[] {ints[1]});
                }
            }

            int sum = 0;
            for (Integer[] update : updates){
                boolean valid = true;
                for (int i = 1; i < update.length; i++){
                    if (rules.containsKey(update[i])){
                        Integer[] subset = Arrays.copyOfRange(update, 0, i);
                        Integer[] values = rules.get(update[i]);
                        for (Integer value : values){
                            for (Integer num : subset){
                                if (Objects.equals(num, value)){
                                    valid = false;
                                    break;
                                }
                            }
                            if (!valid){
                                break;
                            }
                        }
                        if (!valid){
                            break;
                        }
                    }
                }
                if(valid){
                    sum += update[(update.length / 2)];
                }
            }

            System.out.println(sum);

        } catch (RuntimeException e) {
            logger.error("An error occurred: {}", e.getMessage(), e);
        }
    }

    @SuppressWarnings("DuplicatedCode")
    public static void main(String[] args) {
        try {
            ArrayList<String> input = new ArrayList<>();
            ArrayList<String> rulesStr = new ArrayList<>();
            ArrayList<String> updatesStr = new ArrayList<>();
            HashMap<Integer, Integer[]> rules = new HashMap<>();

            try (BufferedReader br = new BufferedReader(new FileReader("/Users/john/IdeaProjects/adventOfCode24/src/main/java/org/advent24/input_5"))) {
                String line;
                while ((line = br.readLine()) != null) {
                    input.add(line);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            for (int i = 0; i < 1176; i++){
                rulesStr.add(input.get(i));
            }

            for (int i = 1177; i < input.size(); i++){
                updatesStr.add(input.get(i));
            }

            ArrayList<Integer[]> ruleList = new ArrayList<>();
            for (String s : rulesStr){
                String[] temp = s.split("\\|");
                Integer[] ints = {Integer.valueOf(temp[0]), Integer.valueOf(temp[1])};
                ruleList.add(ints);
            }

            ArrayList<Integer[]> updates = new ArrayList<>();
            for (String s : updatesStr){
                String[] temp = s.split(",");
                Integer[] ints = new Integer[temp.length];

                for (int i = 0; i < temp.length; i++){
                    ints[i] = Integer.valueOf(temp[i]);
                }

                updates.add(ints);
            }


            for (Integer[] ints : ruleList){
                if (rules.containsKey(ints[0])){
                    ArrayList<Integer> temp = new ArrayList<>();
                    Collections.addAll(temp, rules.get(ints[0]));

                    temp.add(ints[1]);
                    Integer[] newValue = new Integer[temp.size()];
                    newValue = temp.toArray(newValue);

                    rules.replace(ints[0], newValue);
                } else {
                    rules.put(ints[0], new Integer[] {ints[1]});
                }
            }

            int sum = 0;
            for (Integer[] update : updates){
                boolean valid = true;
                for (int i = 1; i < update.length; i++){
                    boolean validYet = true;
                    if (rules.containsKey(update[i])){
                        Integer[] subset = Arrays.copyOfRange(update, 0, i);
                        Integer[] values = rules.get(update[i]);
                        for (Integer value : values){
                            for (int j = 0; j < subset.length; j++){
                                if (Objects.equals(subset[j], value)){
                                    int temp = update[j+1];
                                    for (int k = j+1; k > 0; k--){
                                        update[k] = update[k-1];
                                    }
                                    update[0] = temp;
                                    valid = false;
                                    validYet = false;
                                    i = -1;
                                    break;
                                }
                            }
                            if (!validYet){
                                break;
                            }
                        }
                    }
                }
                if(!valid){
                    sum += update[(update.length / 2)];
                }
            }

            System.out.println(sum);

        } catch (RuntimeException e) {
            logger.error("An error occurred: {}", e.getMessage(), e);
        }
    }
}
