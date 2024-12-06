package org.advent24;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

@SuppressWarnings({"DuplicatedCode", "UseBulkOperation"})
public class day2 {

    @SuppressWarnings("ExtractMethodRecommender")
    public void part1() throws FileNotFoundException{
        ArrayList<String> input = new ArrayList<>();
        ArrayList<Boolean> safety = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("/Users/john/IdeaProjects/adventOfCode24/src/main/java/org/advent24/input_2"))) {
            String line;
            while ((line = br.readLine()) != null) {
                input.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (String s : input){
            ArrayList<Integer> report = new ArrayList<>();
            String[] parsed = s.split(" ");
            for (String x : parsed){
                report.add(Integer.valueOf(x));
            }

            boolean inc = false;
            boolean safe = true;

            if (report.get(1) > report.get(0)){
                inc = true;
            } else if (Objects.equals(report.get(1), report.get(0))){
                safe = false;
            }

            for (int i = 1; i < report.size(); i++){
                if (inc){
                    if ((report.get(i) - report.get(i-1)) < 1 ||
                            (report.get(i) - report.get(i-1)) > 3){
                        safe = false;
                    }
                } else {
                    if ((report.get(i-1) - report.get(i)) < 1 ||
                            (report.get(i-1) - report.get(i)) > 3){
                        safe = false;
                    }
                }
            }

            safety.add(safe);
        }

        int count = 0;
        for (boolean b : safety){
            if (b){
                count++;
            }
        }
        System.out.println(count);
    }


    public boolean safetyCheck(ArrayList<Integer> report){
        boolean inc = false;
        boolean safe = true;

        if (report.get(1) > report.get(0)){
            inc = true;
        } else if (Objects.equals(report.get(1), report.get(0))){
            safe = false;
        }

        for (int i = 1; i < report.size(); i++){
            if (inc){
                if ((report.get(i) - report.get(i-1)) < 1 ||
                        (report.get(i) - report.get(i-1)) > 3){
                    safe = false;
                }
            } else {
                if ((report.get(i-1) - report.get(i)) < 1 ||
                        (report.get(i-1) - report.get(i)) > 3){
                    safe = false;
                }
            }
        }
        return safe;
    }

    public boolean checkAll(ArrayList<Integer> report){
        for (int i = 0; i < report.size(); i++){
            ArrayList<Integer> edit = new ArrayList<>();
            boolean safe = false;
            for (Integer integer : report) {
                edit.add(integer);
            }
            edit.remove(i);
            if (safetyCheck(edit)){
                return true;
            }
        }
        return false;
    }

    @SuppressWarnings({"ExtractMethodRecommender", "RedundantSuppression"})
    public void runPt2() throws FileNotFoundException{
        ArrayList<String> input = new ArrayList<>();
        ArrayList<Boolean> safety = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("/Users/john/IdeaProjects/adventOfCode24/src/main/java/org/advent24/input_2"))) {
            String line;
            while ((line = br.readLine()) != null) {
                input.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (String s : input){
            day2 check = new day2();
            ArrayList<Integer> report = new ArrayList<>();
            String[] parsed = s.split(" ");
            for (String x : parsed){
                report.add(Integer.valueOf(x));
            }

            safety.add(check.safetyCheck(report));
        }

        for (int i = 0; i < safety.size(); i++){
            day2 check = new day2();
            if (!safety.get(i)){
                String s = input.get(i);
                ArrayList<Integer> report = new ArrayList<>();
                String[] parsed = s.split(" ");
                for (String x : parsed){
                    report.add(Integer.valueOf(x));
                }

                safety.set(i, check.checkAll(report));
            }
        }

        int count = 0;
        for (boolean b : safety){
            if (b){
                count++;
            }
        }
        System.out.println(count);
    }
}
